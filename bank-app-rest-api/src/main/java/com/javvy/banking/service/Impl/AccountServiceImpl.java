package com.javvy.banking.service.Impl;

import com.javvy.banking.Mapper.AccountMapper;
import com.javvy.banking.dto.AccountDto;
import com.javvy.banking.entity.Account;
import com.javvy.banking.exception.AccountException;
import com.javvy.banking.respository.AccountRepoistory;
import com.javvy.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepoistory accountRepoistory;

    public AccountServiceImpl(AccountRepoistory accountRepoistory) {
        this.accountRepoistory = accountRepoistory;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepoistory.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepoistory
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepoistory
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepoistory.save(account);


        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepoistory
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepoistory.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accounts = accountRepoistory.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepoistory
                .findById(id)
                .orElseThrow(() -> new AccountException("Account does not exists"));

        accountRepoistory.deleteById(id);
    }

}
