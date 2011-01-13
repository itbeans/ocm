package com.itbeans.orders.faces;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

import com.itbeans.orders.dao.CustomerDAO;

@Named
@SessionScoped
public class Greeting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String greet = "Hello, ";
	private String name;
	
	@Inject GreetingHelper gh;
	

	@Inject CustomerDAO cs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}
	
	public String sayHi() {
		
		greet = "Hi, " + name;
		System.out.println("Greeting Helper: " + gh);
		System.out.println("Customer Service: " + cs.findAllCustomer().size());
		return "/pages/greetings?faces-redirect=true";
	}

}
