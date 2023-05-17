package com.ssafy.raid.auth.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.raid.auth.dto.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    Optional<Account> findById(String id);
}