package com.itbeans.orders.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
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
@ConversationScoped
public class OrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Conversation conversation;

	@Inject
	SalesOrderService sos;
	
	@Inject
	SalesOrder so;
	
	@Inject
	CustomerService cs;
	
	@Inject
	ReferencesBean referencesBean;
	
	String customerNameSearch;

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
		referencesBean.setCustomerList(new ArrayList<SelectItem>());
		for (Customer cust: cs.searchCustomers((String)vce.getNewValue())) {
			SelectItem selectItem = new SelectItem(cust.getCustomerid(), cust.getFirstname() + " " 
																+ cust.getMiddlename() + " "
																+ cust.getLastname());
			referencesBean.getCustomerList().add(selectItem);
		}
		System.out.println("findCustomer(): Displaying customer info: count" + referencesBean.customerList.size() );
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
			conversation.end();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
		}
		System.out.println("Saved.");
		return null;
	}

	public ReferencesBean getReferenceBean() {
		System.out.println("Conversation: " + conversation.getId() + so);
		return referencesBean;
	}

	public void setReferenceBean(ReferencesBean referencesBean) {
		this.referencesBean = referencesBean;
	}
	
	public String start() {
		conversation.begin();
		return "/pages/order";
	}
}
