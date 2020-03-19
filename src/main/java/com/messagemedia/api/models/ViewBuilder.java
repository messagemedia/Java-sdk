package com.messagemedia.api.models;

import java.util.*;

public class ViewBuilder {
    //the instance to build
    private View view;

    /**
     * Default constructor to initialize the instance
     */
    public ViewBuilder() {
        view = new View();
    }

    public ViewBuilder dt(String dt) {
        view.setDt(dt);
        return this;
    }

    public ViewBuilder userAgent(String userAgent) {
        view.setUserAgent(userAgent);
        return this;
    }

    public ViewBuilder ip(String ip) {
        view.setIp(ip);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public View build() {
        return view;
    }
}