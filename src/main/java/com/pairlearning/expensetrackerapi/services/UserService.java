package com.pairlearning.expensetrackerapi.services;


import com.pairlearning.expensetrackerapi.domain.User;
import com.pairlearning.expensetrackerapi.exception.EtAuthException;

public interface UserService {

    User validateUser(String email, String password) throws EtAuthException;

    User registerUsaer(String firstName, String lastName, String email, String password) throws EtAuthException;
}
