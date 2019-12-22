package com.example.makeup.model;

import java.util.List;

public class RestMakeUpResponse {
    private List<Lipstick> res_lip;
    private List<Blush> res_blush;
    private List<Foundation> res_found;

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

