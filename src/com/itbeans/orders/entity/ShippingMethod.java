package com.itbeans.orders.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the shipping_method database table.
 * 
 */
@Entity
@Table(name="shipping_method")
public class ShippingMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private short shipmethodid;

	private String createdby;

    @Temporal( TemporalType.DATE)
	private Date createddate;

	private String deliverytime;

	private String description;

	private String updatedby;

    @Temporal( TemporalType.DATE)
	private Date updateddate;

	//bi-directional many-to-one association to SalesOrder
	@OneToMany(mappedBy="shippingMethod")
	private Set<SalesOrder> salesOrders;

    public ShippingMethod() {
    }

	public short getShipmethodid() {
		return this.shipmethodid;
	}

	public void setShipmethodid(short shipmethodid) {
		this.shipmethodid = shipmethodid;
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

	public String getDeliverytime() {
		return this.deliverytime;
	}

	public void setDeliverytime(String deliverytime) {
		this.deliverytime = deliverytime;
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
	
}