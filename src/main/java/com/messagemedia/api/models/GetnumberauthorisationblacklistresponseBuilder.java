package com.messagemedia.api.models;

import java.util.*;

public class GetnumberauthorisationblacklistresponseBuilder {
    //the instance to build
    private Getnumberauthorisationblacklistresponse getnumberauthorisationblacklistresponse;

    /**
     * Default constructor to initialize the instance
     */
    public GetnumberauthorisationblacklistresponseBuilder() {
        getnumberauthorisationblacklistresponse = new Getnumberauthorisationblacklistresponse();
    }

    /**
     * URL of the current API call, used to show the current pagination token for calls subsequent to the first one in the case of paginated data.
     */
    public GetnumberauthorisationblacklistresponseBuilder uri(String uri) {
        getnumberauthorisationblacklistresponse.setUri(uri);
        return this;
    }

    /**
     * List of numbers belonging to the blacklist.
     */
    public GetnumberauthorisationblacklistresponseBuilder numbers(List<String> numbers) {
        getnumberauthorisationblacklistresponse.setNumbers(numbers);
        return this;
    }

    public GetnumberauthorisationblacklistresponseBuilder pagination(Pagination pagination) {
        getnumberauthorisationblacklistresponse.setPagination(pagination);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Getnumberauthorisationblacklistresponse build() {
        return getnumberauthorisationblacklistresponse;
    }
}