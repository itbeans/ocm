package com.itbeans.orders.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import com.itbeans.orders.entity.Customer;

@Singleton
public class CustomerDAO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@PersistenceContext(unitName="orders")
	private EntityManager em;
	
	@Resource
	UserTransaction utx;
	
	public void insertCustomer(Customer c) {

		try {
			utx.begin();
			em.persist(c);
			utx.commit();
			System.out.println("Insert customer: " + c.getCustomerid() + 
							":" + c.getFirstname() + " " + c.getLastname());
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception er) {
				er.printStackTrace();
			} 
			e.printStackTrace();
		}

	}
	
	public Customer findCustomer(int customerId) {

		Customer customer = null;
		try {
			customer = em.find(Customer.class, customerId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;

	}
	
	public List<Customer> findAllCustomer() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		TypedQuery<Customer> query = em.createQuery("SELECT c from Customer c", Customer.class);
		
		customerList = query.getResultList();
		return customerList;
	}
	
	public List<Customer> searchCustomers(Customer customer) {
		
		List<Customer> customerList = new ArrayList<Customer>();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		criteriaQuery.where( criteriaBuilder.equal(root.get("firstName"), customer.getFirstname()) );
		
		TypedQuery<Customer> query = em.createQuery(criteriaQuery);
		query.setMaxResults(100);
		customerList = query.getResultList();
		return customerList;
	}

}
