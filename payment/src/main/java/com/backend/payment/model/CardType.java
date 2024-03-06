package com.backend.payment.model;

public enum CardType {
    STANDARD("Standard"),
    PREMIUM("Premium"),
    PLATINUM("Platinum");

    private final String displayName;

    CardType(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
