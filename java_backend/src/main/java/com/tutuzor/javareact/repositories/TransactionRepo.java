package com.tutuzor.javareact.repositories;

import com.tutuzor.javareact.models.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TransactionRepo extends CrudRepository<Transaction, Long> {
}
