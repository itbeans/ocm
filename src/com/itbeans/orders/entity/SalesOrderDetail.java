package com.itbeans.orders.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the sales_order_detail database table.
 * 
 */
@Entity
@Table(name="sales_order_detail")
public class SalesOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemid;

    @Temporal( TemporalType.TIMESTAMP)
	private Date actcompletion;

	private String assignedto;

	private String createdby;

    @Temporal( TemporalType.DATE)
	private Date createddate;

	private BigDecimal discount;

	private String jobdesc;

	private int qty;

    @Temporal( TemporalType.TIMESTAMP)
	private Date schcompletion;

	private BigDecimal unitprice;

	private String updatedby;

    @Temporal( TemporalType.DATE)
	private Date updateddate;

	private String wiptrail;

	//bi-directional many-to-one association to Job
    @ManyToOne
	@JoinColumn(name="stdjobid")
	private Job job;

	//bi-directional many-to-one association to SalesOrder
    @ManyToOne
	@JoinColumn(name="orderid")
	private SalesOrder salesOrder;

	//bi-directional many-to-one association to OrderStatus
    @ManyToOne
	@JoinColumn(name="status")
	private OrderStatus orderStatus;

    public SalesOrderDetail() {
    }

	public int getItemid() {
		return this.itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public Date getActcompletion() {
		return this.actcompletion;
	}

	public void setActcompletion(Date actcompletion) {
		this.actcompletion = actcompletion;
	}

	public String getAssignedto() {
		return this.assignedto;
	}

	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
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

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getJobdesc() {
		return this.jobdesc;
	}

	public void setJobdesc(String jobdesc) {
		this.jobdesc = jobdesc;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getSchcompletion() {
		return this.schcompletion;
	}

	public void setSchcompletion(Date schcompletion) {
		this.schcompletion = schcompletion;
	}

	public BigDecimal getUnitprice() {
		return this.unitprice;
	}

	public void setUnitprice(BigDecimal unitprice) {
		this.unitprice = unitprice;
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

	public String getWiptrail() {
		return this.wiptrail;
	}

	public void setWiptrail(String wiptrail) {
		this.wiptrail = wiptrail;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	public SalesOrder getSalesOrder() {
		return this.salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}
	
	public OrderStatus getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}