package io.github.cbs.domain.enums;

public enum ServiceCode {

    ACC_SERVICE("User Service"),
    DEP_SERVICE("Order Service");

    private final String description;

    ServiceCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}

// just a dummy as of now
