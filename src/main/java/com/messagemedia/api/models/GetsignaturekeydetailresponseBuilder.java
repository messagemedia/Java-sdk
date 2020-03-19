package com.messagemedia.api.models;

import java.util.*;

public class GetsignaturekeydetailresponseBuilder {
    //the instance to build
    private Getsignaturekeydetailresponse getsignaturekeydetailresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetsignaturekeydetailresponseBuilder() {
        getsignaturekeydetailresponse = new Getsignaturekeydetailresponse();
    }

    public GetsignaturekeydetailresponseBuilder keyId(String keyId) {
        getsignaturekeydetailresponse.setKeyId(keyId);
        return this;
    }

    public GetsignaturekeydetailresponseBuilder cipher(String cipher) {
        getsignaturekeydetailresponse.setCipher(cipher);
        return this;
    }

    public GetsignaturekeydetailresponseBuilder digest(String digest) {
        getsignaturekeydetailresponse.setDigest(digest);
        return this;
    }

    public GetsignaturekeydetailresponseBuilder created(String created) {
        getsignaturekeydetailresponse.setCreated(created);
        return this;
    }

    public GetsignaturekeydetailresponseBuilder enabled(Boolean enabled) {
        getsignaturekeydetailresponse.setEnabled(enabled);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Getsignaturekeydetailresponse build() {
        return getsignaturekeydetailresponse;
    }
}