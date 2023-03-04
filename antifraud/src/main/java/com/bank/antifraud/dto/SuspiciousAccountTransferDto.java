package com.bank.antifraud.dto;

import java.math.BigInteger;


public class SuspiciousAccountTransferDto {

    private BigInteger accountTransferId;

    private Boolean isBlocked;

    private Boolean isSuspicious;

    private String blockedReason;

    private String suspiciousReason;

    public SuspiciousAccountTransferDto(BigInteger accountTransferId, Boolean isBlocked,
                                        Boolean isSuspicious, String blockedReason,
                                        String suspiciousReason) {
        this.accountTransferId = accountTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public BigInteger getAccountTransferId() {
        return accountTransferId;
    }

    public void setAccountTransferId(BigInteger accountTransferId) {
        this.accountTransferId = accountTransferId;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Boolean getSuspicious() {
        return isSuspicious;
    }

    public void setSuspicious(Boolean suspicious) {
        isSuspicious = suspicious;
    }

    public String getBlockedReason() {
        return blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public String getSuspiciousReason() {
        return suspiciousReason;
    }

    public void setSuspiciousReason(String suspiciousReason) {
        this.suspiciousReason = suspiciousReason;
    }
}
