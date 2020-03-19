package com.messagemedia.api.models;

import java.util.*;

public class HeadersBuilder {
    //the instance to build
    private Headers headers;

    /**
     * Default constructor to initialize the instance
     */
    public HeadersBuilder() {
        headers = new Headers();
    }

    public HeadersBuilder account(String account) {
        headers.setAccount(account);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Headers build() {
        return headers;
    }
}