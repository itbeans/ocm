package com.itbeans.orders.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import com.itbeans.orders.entity.SalesOrder;
import com.itbeans.orders.entity.SalesOrderDetail;
import com.itbeans.orders.entity.ShippingMethod;

@Singleton
public class ReferencesService implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="orders")
	private EntityManager em;
	
	@Resource
	UserTransaction utx;
	
	public List<ShippingMethod> findAllShippingMethods() {
		
		List<ShippingMethod> methodList = new ArrayList<ShippingMethod>();
		TypedQuery<ShippingMethod> query = em.createQuery("SELECT sm from ShippingMethod sm", ShippingMethod.class);
		
		methodList = query.getResultList();
		return methodList;
	}
	
	public List<String> findAllSalesRepresentatives() {
		
		List<String> salesRepList = new ArrayList<String>();
		//TypedQuery<String> query = em.createQuery("SELECT sm from Employee sm where sm.role = 'SALESREP'", Employee.class);
		salesRepList.add("John");
		salesRepList.add("Alex");
		salesRepList.add("Alok");
		//methodList = query.getResultList();
		return salesRepList;
	}
	
	public List<String> findAllPayTerms() {
		
		List<String> payTermList = new ArrayList<String>();
		//TypedQuery<String> query = em.createQuery("SELECT sm from Employee sm where sm.role = 'SALESREP'", Employee.class);
		payTermList.add("Due On Receipt");
		payTermList.add("30 days from delivery");
		//methodList = query.getResultList();
		return payTermList;
	}

}
