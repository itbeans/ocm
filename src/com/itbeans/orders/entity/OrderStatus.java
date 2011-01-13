package com.itbeans.orders.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the order_status database table.
 * 
 */
@Entity
@Table(name="order_status")
public class OrderStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short statusid;

	private String createdby;

    @Temporal( TemporalType.DATE)
	private Date createddate;

	private String description;

	private String updatedby;

    @Temporal( TemporalType.DATE)
	private Date updateddate;

	//bi-directional many-to-one association to SalesOrder
	@OneToMany(mappedBy="orderStatus")
	private Set<SalesOrder> salesOrders;

	//bi-directional many-to-one association to SalesOrderDetail
	@OneToMany(mappedBy="orderStatus")
	private Set<SalesOrderDetail> salesOrderDetails;

    public OrderStatus() {
    }

	public short getStatusid() {
		return this.statusid;
	}

	public void setStatusid(short statusid) {
		this.statusid = statusid;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Set<SalesOrder> getSalesOrders() {
		return this.salesOrders;
	}

	public void setSalesOrders(Set<SalesOrder> salesOrders) {
		this.salesOrders = salesOrders;
	}
	
	public Set<SalesOrderDetail> getSalesOrderDetails() {
		return this.salesOrderDetails;
	}

	public void setSalesOrderDetails(Set<SalesOrderDetail> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}
	
}