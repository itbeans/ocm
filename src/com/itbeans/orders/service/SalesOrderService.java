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

@Singleton
public class SalesOrderService implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="orders")
	private EntityManager em;
	
	@Resource
	UserTransaction utx;
	
	public void insertSalesOrder(SalesOrder so, Collection<SalesOrderDetail> sodList) throws Exception {

		try {
			utx.begin();
			em.persist(so);
			
	/*		for (SalesOrderDetail sod: sodList) {
				sod.setSalesOrder(so);
				em.persist(sod);
			}*/
			utx.commit();
			System.out.println("Insert customer: " + so.getOrderid());
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception er) {
				er.printStackTrace();
			} 
			e.printStackTrace();
			throw new Exception("Error saving the sales order.");
		}

	}
	
	public SalesOrder findOrder(int orderId) {

		SalesOrder order = null;
		try {
			order = em.find(SalesOrder.class, orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return order;

	}
	
	public List<SalesOrder> findAllOrders() {
		
		List<SalesOrder> orderList = new ArrayList<SalesOrder>();
		TypedQuery<SalesOrder> query = em.createQuery("SELECT so from SalesOrder so", SalesOrder.class);
		
		orderList = query.getResultList();
		return orderList;
	}
	
	public List<SalesOrder> searchCustomers(String name) {
		
		List<SalesOrder> orderList = new ArrayList<SalesOrder>();

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<SalesOrder> criteriaQuery = criteriaBuilder.createQuery(SalesOrder.class);
		Root<SalesOrder> root = criteriaQuery.from(SalesOrder.class);
		Predicate p1 = criteriaBuilder.equal(root.get("firstName"), name);
		Predicate p2 = criteriaBuilder.equal(root.get("lastName"), name);
		Predicate p = criteriaBuilder.or(p1, p2);
		criteriaQuery.where( p );
		
		TypedQuery<SalesOrder> query = em.createQuery(criteriaQuery);
		query.setMaxResults(100);
		orderList = query.getResultList();
		return orderList;
	}
}
