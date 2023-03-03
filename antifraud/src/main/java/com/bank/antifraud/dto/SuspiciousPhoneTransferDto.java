package com.bank.antifraud.dto;

import java.math.BigInteger;

public class SuspiciousPhoneTransferDto {

    private BigInteger id;

    private BigInteger phoneTransferId;

    private Boolean isBlocked;

    private Boolean isSuspicious;

    private String blockedReason;

    private String suspiciousReason;

    public SuspiciousPhoneTransferDto(BigInteger id, BigInteger phoneTransferId,
                                      Boolean isBlocked, Boolean isSuspicious,
                                      String blockedReason, String suspiciousReason) {
        this.id = id;
        this.phoneTransferId = phoneTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getPhoneTransferId() {
        return phoneTransferId;
    }

    public void setPhoneTransferId(BigInteger phoneTransferId) {
        this.phoneTransferId = phoneTransferId;
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
