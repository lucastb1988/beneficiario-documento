package com.beneficiariodocumento.domain.security;


import com.beneficiariodocumento.exception.UnprocessableEntityAPIException;

public enum ProfileEnum {

    FUNCIONARIO("FUNCIONARIO"), ADMIN("ADMIN");

    private String description;

    ProfileEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static ProfileEnum fromDescription(String description) {
        if (description != null) {
            for (ProfileEnum value : ProfileEnum.values()) {
                if (value.getDescription().equalsIgnoreCase(description)) {
                    return value;
                }
            }
        }
        throw new UnprocessableEntityAPIException("Profile incorreto!");
    }
}