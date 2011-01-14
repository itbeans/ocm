package com.itbeans.orders.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

import com.itbeans.orders.entity.Customer;

@ManagedBean
public class CustomerService implements Serializable {
	
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
	
	public List<Customer> searchCustomers(String name) {
		
		List<Customer> customerList = new ArrayList<Customer>();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		Predicate p1 = criteriaBuilder.equal(root.get("firstname"), name);
		Predicate p2 = criteriaBuilder.equal(root.get("lastname"), name);
		Predicate p = criteriaBuilder.or(p1, p2);
		criteriaQuery.where( p );
		
		TypedQuery<Customer> query = em.createQuery(criteriaQuery);
		query.setMaxResults(100);
		customerList = query.getResultList();
		return customerList;
	}
}
