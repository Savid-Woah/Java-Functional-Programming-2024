package com.functionalprogramming.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MsgCode {

    OOPS_ERROR(500, "oops-error"),
    CUSTOMER_ALREADY_EXISTS(409, "customer-already-exists")

    ;

    private final Integer code;
    private final String languageKey;
}