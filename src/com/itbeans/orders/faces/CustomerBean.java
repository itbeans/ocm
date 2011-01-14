package com.itbeans.orders.faces;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import com.itbeans.orders.entity.Customer;
import com.itbeans.orders.service.CustomerService;

@ManagedBean
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	CustomerService cs;
	
	Customer c = new Customer();
	
	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public String addCustomer() {
		cs.insertCustomer(c);
		return null;
		
	}
}
