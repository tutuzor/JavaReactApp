package com.tutuzor.javareact.repositories;

import com.tutuzor.javareact.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepo extends CrudRepository<Account, Long> {
}
