package com.test.hplusapp.repository;

import com.test.hplusapp.beans.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User , Integer> {
}