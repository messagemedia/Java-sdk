package com.messagemedia.api.models;

import java.util.*;

public class FontFamilyURL1Builder {
    //the instance to build
    private FontFamilyURL1 fontFamilyURL1;

    /**
     * Default constructor to initialize the instance
     */
    public FontFamilyURL1Builder() {
        fontFamilyURL1 = new FontFamilyURL1();
    }

    public FontFamilyURL1Builder type(String type) {
        fontFamilyURL1.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public FontFamilyURL1 build() {
        return fontFamilyURL1;
    }
}