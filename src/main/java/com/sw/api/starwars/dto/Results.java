package com.sw.api.starwars.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Results implements Serializable {
	
	private static final long serialVersionUID = 5247256397061742311L;
	
    public String name;
    public String rotation_period;
    public String orbital_period;
    public String diameter;
    public String climate;
    public String gravity;
    public String terrain;
    public String surface_water;
    public String population;
    public List<String> residents;
    public List<String> films;
    public Date created;
    public Date edited;
    public String url;

}
