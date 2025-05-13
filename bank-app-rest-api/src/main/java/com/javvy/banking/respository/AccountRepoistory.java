package com.javvy.banking.respository;

import com.javvy.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepoistory extends JpaRepository<Account,Long> {
}
