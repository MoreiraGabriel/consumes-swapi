package com.sw.api.starwars.entity.dto;

import java.util.List;

public class Result {

    public int count;
    public String next;
    public Object previous;
    public List<Result> results;
}
