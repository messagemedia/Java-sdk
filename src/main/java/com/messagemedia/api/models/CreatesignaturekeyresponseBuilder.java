package com.messagemedia.api.models;

import java.util.*;

public class CreatesignaturekeyresponseBuilder {
    //the instance to build
    private Createsignaturekeyresponse createsignaturekeyresponse;

    /**
     * Default constructor to initialize the instance
     */
    public CreatesignaturekeyresponseBuilder() {
        createsignaturekeyresponse = new Createsignaturekeyresponse();
    }

    public CreatesignaturekeyresponseBuilder keyId(String keyId) {
        createsignaturekeyresponse.setKeyId(keyId);
        return this;
    }

    public CreatesignaturekeyresponseBuilder publicKey(String publicKey) {
        createsignaturekeyresponse.setPublicKey(publicKey);
        return this;
    }

    public CreatesignaturekeyresponseBuilder cipher(String cipher) {
        createsignaturekeyresponse.setCipher(cipher);
        return this;
    }

    public CreatesignaturekeyresponseBuilder digest(String digest) {
        createsignaturekeyresponse.setDigest(digest);
        return this;
    }

    public CreatesignaturekeyresponseBuilder created(String created) {
        createsignaturekeyresponse.setCreated(created);
        return this;
    }

    public CreatesignaturekeyresponseBuilder enabled(boolean enabled) {
        createsignaturekeyresponse.setEnabled(enabled);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Createsignaturekeyresponse build() {
        return createsignaturekeyresponse;
    }
}