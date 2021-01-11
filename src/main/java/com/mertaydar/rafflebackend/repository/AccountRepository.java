package com.mertaydar.rafflebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mertaydar.rafflebackend.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

}
