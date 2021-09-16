package com.sw.api.starwars.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result implements Serializable {

	private static final long serialVersionUID = 7676123862334824815L;
	
	public int count;
    public String next;
    public Object previous;
    public List<Results> results;
}
