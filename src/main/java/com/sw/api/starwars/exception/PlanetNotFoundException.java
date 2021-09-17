package com.sw.api.starwars.exception;


public class PlanetNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4879234956320728508L;

	public PlanetNotFoundException(String message) {
		super(message);
	}
	
}
