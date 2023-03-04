package com.bank.antifraud.dto;

import java.math.BigInteger;

public class SuspiciousCardTransferDto {

    private BigInteger cardTransferId;

    private Boolean isBlocked;

    private Boolean isSuspicious;

    private String blockedReason;

    private String suspiciousReason;

    public SuspiciousCardTransferDto(BigInteger cardTransferId, Boolean isBlocked,
                                     Boolean isSuspicious, String blockedReason,
                                     String suspiciousReason) {
        this.cardTransferId = cardTransferId;
        this.isBlocked = isBlocked;
        this.isSuspicious = isSuspicious;
        this.blockedReason = blockedReason;
        this.suspiciousReason = suspiciousReason;
    }

    public BigInteger getCardTransferId() {
        return cardTransferId;
    }

    public void setCardTransferId(BigInteger cardTransferId) {
        this.cardTransferId = cardTransferId;
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
