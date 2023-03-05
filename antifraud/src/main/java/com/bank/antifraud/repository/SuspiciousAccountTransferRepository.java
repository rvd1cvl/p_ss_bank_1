package com.bank.antifraud.repository;

import com.bank.antifraud.entity.SuspiciousAccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SuspiciousAccountTransferRepository extends JpaRepository<SuspiciousAccountTransfer, BigInteger> {
}
