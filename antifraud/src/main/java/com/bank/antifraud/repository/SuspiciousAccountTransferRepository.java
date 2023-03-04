package com.bank.antifraud.repository;

import com.bank.antifraud.model.SuspiciousAccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface SuspiciousAccountTransferRepository extends JpaRepository<SuspiciousAccountTransfer, BigInteger> {
}
