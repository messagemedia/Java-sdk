package com.messagemedia.api.models;

import java.util.*;

public class ButtonFontFamilyBuilder {
    //the instance to build
    private ButtonFontFamily buttonFontFamily;

    /**
     * Default constructor to initialize the instance
     */
    public ButtonFontFamilyBuilder() {
        buttonFontFamily = new ButtonFontFamily();
    }

    public ButtonFontFamilyBuilder type(String type) {
        buttonFontFamily.setType(type);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ButtonFontFamily build() {
        return buttonFontFamily;
    }
}