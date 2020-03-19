package com.messagemedia.api.models;

import java.util.*;

public class LogoLinkBuilder {
    //the instance to build
    private LogoLink logoLink;

    /**
     * Default constructor to initialize the instance
     */
    public LogoLinkBuilder() {
        logoLink = new LogoLink();
    }

    public LogoLinkBuilder type(String type) {
        logoLink.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public LogoLink build() {
        return logoLink;
    }
}