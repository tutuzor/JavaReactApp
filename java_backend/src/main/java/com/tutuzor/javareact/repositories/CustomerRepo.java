package com.tutuzor.javareact.repositories;

import com.tutuzor.javareact.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
