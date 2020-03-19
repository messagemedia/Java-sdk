package com.messagemedia.api.models;

import java.util.*;

public class GetenabledsignaturekeyresponseBuilder {
    //the instance to build
    private Getenabledsignaturekeyresponse getenabledsignaturekeyresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetenabledsignaturekeyresponseBuilder() {
        getenabledsignaturekeyresponse = new Getenabledsignaturekeyresponse();
    }

    public GetenabledsignaturekeyresponseBuilder keyId(String keyId) {
        getenabledsignaturekeyresponse.setKeyId(keyId);
        return this;
    }

    public GetenabledsignaturekeyresponseBuilder cipher(String cipher) {
        getenabledsignaturekeyresponse.setCipher(cipher);
        return this;
    }

    public GetenabledsignaturekeyresponseBuilder digest(String digest) {
        getenabledsignaturekeyresponse.setDigest(digest);
        return this;
    }

    public GetenabledsignaturekeyresponseBuilder created(String created) {
        getenabledsignaturekeyresponse.setCreated(created);
        return this;
    }

    public GetenabledsignaturekeyresponseBuilder enabled(Boolean enabled) {
        getenabledsignaturekeyresponse.setEnabled(enabled);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Getenabledsignaturekeyresponse build() {
        return getenabledsignaturekeyresponse;
    }
}