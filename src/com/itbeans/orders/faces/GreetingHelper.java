package com.itbeans.orders.faces;

import java.io.Serializable;

import javax.enterprise.inject.Default;
import javax.inject.Singleton;

@Singleton
public class GreetingHelper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public String greet(String name) {
        return "Hello, " + name + ".";
    }


}
