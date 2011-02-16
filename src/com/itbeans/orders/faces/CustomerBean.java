package com.itbeans.orders.faces;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbeans.orders.entity.Customer;
import com.itbeans.orders.service.CustomerService;

@Named
@ConversationScoped
public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private CustomerService cs;
	
	@Inject
	private OrderBean ob;
	
	private Customer c = new Customer();
	
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
	@Produces
	public List<Customer> getCustomerList() {
		return cs.findAllCustomer();
	}
	
	
	public String selectCustomer() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		String selectedCustomer = context.getRequestParameterMap().get("selectedCustomer");
		int customerId = Integer.parseInt(selectedCustomer);
		ob.getSo().setCustomer(cs.findCustomer(customerId));
		return "/pages/order.xhtml";
	}

}
