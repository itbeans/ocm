package com.itbeans.orders.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the sales_order database table.
 * 
 */
@Entity
@Table(name="sales_order")
public class SalesOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;

    @Temporal( TemporalType.DATE)
	private Date actualdeldate;

	private String createdby;

    @Temporal( TemporalType.DATE)
	private Date createddate;

    @Temporal( TemporalType.DATE)
	private Date deliverydate;

    @Temporal( TemporalType.DATE)
	private Date payduedate;

	private String payterms;

	private String refpo;

	private String salesperson;

	private String shipmethodother;

	private String shipterms;

	private String updatedby;
	
	private String description;

	private String ponumber;

    @Temporal( TemporalType.DATE)
	private Date updateddate;

	//bi-directional many-to-one association to Customer
    @ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="customerid")
	private Customer customer;

	//bi-directional many-to-one association to ShippingMethod
    @ManyToOne
	@JoinColumn(name="shipmethod")
	private ShippingMethod shippingMethod;

	//bi-directional many-to-one association to OrderStatus
    @ManyToOne
	@JoinColumn(name="status")
	private OrderStatus orderStatus;

	//bi-directional many-to-one association to SalesOrderDetail
	@OneToMany(mappedBy="salesOrder", cascade=CascadeType.PERSIST)
	private Set<SalesOrderDetail> salesOrderDetails;

    public SalesOrder() {
    }

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Date getActualdeldate() {
		return this.actualdeldate;
	}

	public void setActualdeldate(Date actualdeldate) {
		this.actualdeldate = actualdeldate;
	}

	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return this.createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getDeliverydate() {
		return this.deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public Date getPayduedate() {
		return this.payduedate;
	}

	public void setPayduedate(Date payduedate) {
		this.payduedate = payduedate;
	}

	public String getPayterms() {
		return this.payterms;
	}

	public void setPayterms(String payterms) {
		this.payterms = payterms;
	}

	public String getRefpo() {
		return this.refpo;
	}

	public void setRefpo(String refpo) {
		this.refpo = refpo;
	}

	public String getSalesperson() {
		return this.salesperson;
	}

	public void setSalesperson(String salesperson) {
		this.salesperson = salesperson;
	}

	public String getShipmethodother() {
		return this.shipmethodother;
	}

	public void setShipmethodother(String shipmethodother) {
		this.shipmethodother = shipmethodother;
	}

	public String getShipterms() {
		return this.shipterms;
	}

	public void setShipterms(String shipterms) {
		this.shipterms = shipterms;
	}

	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public ShippingMethod getShippingMethod() {
		return this.shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}
	
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Set<SalesOrderDetail> getSalesOrderDetails() {
		return this.salesOrderDetails;
	}

	public void setSalesOrderDetails(Set<SalesOrderDetail> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}
	
	
	
}