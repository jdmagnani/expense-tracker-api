package com.pairlearning.expensetrackerapi.repositories;

import com.pairlearning.expensetrackerapi.domain.Transaction;
import com.pairlearning.expensetrackerapi.exception.EtBadRequestException;
import com.pairlearning.expensetrackerapi.exception.EtResourceNotFoundException;

import java.util.List;

public interface TransactionRepository {


    List<Transaction> findAll(Integer userId, Integer categoryId) throws EtBadRequestException;

    Transaction findById(Integer userId, Integer categoryId, Integer transactionId) throws EtBadRequestException;

    Integer create(Integer userId, Integer categoryId, Double amount, String note, Long transactionDate) throws EtBadRequestException;

    void update(Integer userId, Integer categoryId, Integer transactionId, Transaction transaction) throws EtBadRequestException;

    void removeById(Integer userId, Integer categoryId, Integer transactionId) throws EtResourceNotFoundException;

}
