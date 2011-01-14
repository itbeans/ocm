package com.itbeans.orders.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbeans.orders.entity.Customer;
import com.itbeans.orders.entity.SalesOrder;
import com.itbeans.orders.entity.SalesOrderDetail;
import com.itbeans.orders.service.CustomerService;
import com.itbeans.orders.service.SalesOrderService;

@Named
@SessionScoped
public class OrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	SalesOrderService sos;
	
	@Inject
	SalesOrder so;
	
	@Inject
	CustomerService cs;
	
	String customerNameSearch;
	
	List<SelectItem> customerList = new ArrayList<SelectItem>();
	
	List<SelectItem> salespersonList = new ArrayList<SelectItem>();
	List<SelectItem> shippingMethodList = new ArrayList<SelectItem>();
	List<SelectItem> shiptermsList = new ArrayList<SelectItem>();
	List<SelectItem> paytermsList = new ArrayList<SelectItem>();

	public List<SelectItem> getSalespersonList() {
		return salespersonList;
	}

	public void setSalespersonList(List<SelectItem> salespersonList) {
		this.salespersonList = salespersonList;
	}

	public List<SelectItem> getShippingMethodList() {
		return shippingMethodList;
	}

	public void setShippingMethodList(List<SelectItem> shippingMethodList) {
		this.shippingMethodList = shippingMethodList;
	}

	public List<SelectItem> getShiptermsList() {
		return shiptermsList;
	}

	public void setShiptermsList(List<SelectItem> shiptermsList) {
		this.shiptermsList = shiptermsList;
	}

	public List<SelectItem> getPaytermsList() {
		return paytermsList;
	}

	public void setPaytermsList(List<SelectItem> paytermsList) {
		this.paytermsList = paytermsList;
	}

	public List<SelectItem> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<SelectItem> customerList) {
		this.customerList = customerList;
	}

	public SalesOrder getSo() {
		if (so.getCustomer() == null) {
			so.setCustomer(new Customer());
		}
		//customerList.add(new SelectItem(-1, "Select Customer"));
		so.setSalesOrderDetails(new HashSet<SalesOrderDetail>());
		so.getSalesOrderDetails().add(new SalesOrderDetail());
		return so;
	}

	public void setSo(SalesOrder so) {
		this.so = so;
	}

	public String getCustomerNameSearch() {
		return customerNameSearch;
	}

	public void setCustomerNameSearch(String customerNameSearch) {
		this.customerNameSearch = customerNameSearch;
	}
	
	public void findCustomer(ValueChangeEvent vce) {
		customerList = new ArrayList<SelectItem>();
		for (Customer cust: cs.searchCustomers((String)vce.getNewValue())) {
			SelectItem selectItem = new SelectItem(cust.getCustomerid(), cust.getFirstname() + " " 
																+ cust.getMiddlename() + " "
																+ cust.getLastname());
			customerList.add(selectItem);
		}
		System.out.println("findCustomer(): Displaying customer info: count" + customerList.size() );
	}
	
	public void findCustomerDetail(ValueChangeEvent vce) {
		System.out.println("in findCustomerDetail()");
		so.setCustomer(cs.findCustomer((Integer)vce.getNewValue()));
		System.out.println("findCustomerDetail(): Displaying customer detail: ");
	}
	
	public String addSalesOrder() {
		System.out.println("Trying to save order...");
		try {
			SalesOrderDetail sod = new SalesOrderDetail();
			sod.setAssignedto("Gautam");
			sod.setSalesOrder(so);
			Set<SalesOrderDetail> sodList = new HashSet<SalesOrderDetail>();
			sodList.add(sod);
			so.setSalesOrderDetails(sodList);
			sos.insertSalesOrder(so, sodList);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Order saved successfully"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
		System.out.println("Saved.");
		return null;
	}
}
