package com.example.makeup.model;

import java.util.List;

public class RestMakeUpResponse {
    //private int count;
    //private String next;
    private List<Lipstick> res_lip;
    private List<Blush> res_blush;
    private List<Foundation> res_found;

    /*public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }
*/
    public List<Lipstick> getResults() {
        return res_lip;
    }
    public List<Blush> getResultsBlush() {
        return res_blush;
    }
    public List<Foundation> getResultsFoundation() {
        return res_found;
    }
}

