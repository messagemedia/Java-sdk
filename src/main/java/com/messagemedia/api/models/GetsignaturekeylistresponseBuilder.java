package com.messagemedia.api.models;

import java.util.*;

public class GetsignaturekeylistresponseBuilder {
    //the instance to build
    private Getsignaturekeylistresponse getsignaturekeylistresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetsignaturekeylistresponseBuilder() {
        getsignaturekeylistresponse = new Getsignaturekeylistresponse();
    }

    public GetsignaturekeylistresponseBuilder keyId(String keyId) {
        getsignaturekeylistresponse.setKeyId(keyId);
        return this;
    }

    public GetsignaturekeylistresponseBuilder cipher(String cipher) {
        getsignaturekeylistresponse.setCipher(cipher);
        return this;
    }

    public GetsignaturekeylistresponseBuilder digest(String digest) {
        getsignaturekeylistresponse.setDigest(digest);
        return this;
    }

    public GetsignaturekeylistresponseBuilder created(String created) {
        getsignaturekeylistresponse.setCreated(created);
        return this;
    }

    public GetsignaturekeylistresponseBuilder enabled(Boolean enabled) {
        getsignaturekeylistresponse.setEnabled(enabled);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Getsignaturekeylistresponse build() {
        return getsignaturekeylistresponse;
    }
}