package com.tutuzor.javareact.repositories;

import com.tutuzor.javareact.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepo extends CrudRepository<User, Long> {
}
