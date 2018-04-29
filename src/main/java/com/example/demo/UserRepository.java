package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserRecord;

@Repository
public interface UserRepository extends CrudRepository<UserRecord, String>{

}
