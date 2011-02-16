package com.itbeans.orders.faces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.itbeans.orders.entity.ShippingMethod;
import com.itbeans.orders.service.ReferencesService;
import com.itbeans.orders.service.SalesOrderService;

@Named
@SessionScoped
public class ReferencesBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	ReferencesService rs;
	
	List<SelectItem> customerList = new ArrayList<SelectItem>();
	
	List<SelectItem> salesRepList = new ArrayList<SelectItem>();
	List<SelectItem> shippingMethodList = new ArrayList<SelectItem>();
	List<SelectItem> payTermList = new ArrayList<SelectItem>();
	public List<SelectItem> getCustomerList() {
		return customerList;
	}
	public void setCustomerList(List<SelectItem> customerList) {
		this.customerList = customerList;
	}
	public List<SelectItem> getSalesRepList() {
		if (salesRepList.size() == 0) {
			for(String salesRep: rs.findAllSalesRepresentatives()) {
				salesRepList.add(new SelectItem(salesRep));
			}
		}
		return salesRepList;
	}
	public void setSalesRepList(List<SelectItem> salesRepList) {
		this.salesRepList = salesRepList;
	}
	public List<SelectItem> getShippingMethodList() {
		if (shippingMethodList.size() == 0) {
			for(ShippingMethod shippingMethod: rs.findAllShippingMethods()) {
				salesRepList.add(new SelectItem(shippingMethod.getShipmethodid(), shippingMethod.getDescription()));
			}
		}
		return shippingMethodList;
	}
	public void setShippingMethodList(List<SelectItem> shippingMethodList) {
		this.shippingMethodList = shippingMethodList;
	}
	public List<SelectItem> getPayTermList() {
		if (payTermList.size() == 0) {
			for(String payTerm: rs.findAllPayTerms()) {
				payTermList.add(new SelectItem(payTerm));
			}
		}
		return payTermList;
	}
	public void setPayTermList(List<SelectItem> payTermList) {
		this.payTermList = payTermList;
	}

	
}
