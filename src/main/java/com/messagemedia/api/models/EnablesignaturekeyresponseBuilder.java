package com.messagemedia.api.models;

import java.util.*;

public class EnablesignaturekeyresponseBuilder {
    //the instance to build
    private Enablesignaturekeyresponse enablesignaturekeyresponse;

    /**
     * Default constructor to initialize the instance
     */
    public EnablesignaturekeyresponseBuilder() {
        enablesignaturekeyresponse = new Enablesignaturekeyresponse();
    }

    public EnablesignaturekeyresponseBuilder keyId(String keyId) {
        enablesignaturekeyresponse.setKeyId(keyId);
        return this;
    }

    public EnablesignaturekeyresponseBuilder cipher(String cipher) {
        enablesignaturekeyresponse.setCipher(cipher);
        return this;
    }

    public EnablesignaturekeyresponseBuilder digest(String digest) {
        enablesignaturekeyresponse.setDigest(digest);
        return this;
    }

    public EnablesignaturekeyresponseBuilder created(String created) {
        enablesignaturekeyresponse.setCreated(created);
        return this;
    }

    public EnablesignaturekeyresponseBuilder enabled(Boolean enabled) {
        enablesignaturekeyresponse.setEnabled(enabled);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Enablesignaturekeyresponse build() {
        return enablesignaturekeyresponse;
    }
}