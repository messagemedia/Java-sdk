package com.messagemedia.api.models;

import java.util.*;

public class ClickBuilder {
    //the instance to build
    private Click click;

    /**
     * Default constructor to initialize the instance
     */
    public ClickBuilder() {
        click = new Click();
    }

    public ClickBuilder dt(String dt) {
        click.setDt(dt);
        return this;
    }

    public ClickBuilder userAgent(String userAgent) {
        click.setUserAgent(userAgent);
        return this;
    }

    public ClickBuilder ip(String ip) {
        click.setIp(ip);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Click build() {
        return click;
    }
}