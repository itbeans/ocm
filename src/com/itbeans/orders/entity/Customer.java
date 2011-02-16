package com.itbeans.orders.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerid = -1;

	private String city;

	private String companyname;

	private String createdby;

    @Temporal( TemporalType.DATE)
	private Date createddate;

	private String email;

	private String firstname;

	private String lastname;

	private String middlename;

	private String relationship;

	private String shipcity;

	private String shipstate;

	private String shipstraddress1;

	private String shipstraddress2;

	private String shipto;

	private String shipzip;

	private String state;

	private String straddress1;

	private String straddress2;

	private String updatedby;

    @Temporal( TemporalType.DATE)
	private Date updateddate;

	private String web;

	private String zip;

	//bi-directional many-to-one association to SalesOrder
	@OneToMany(mappedBy="customer")
	private Set<SalesOrder> salesOrders;

    public Customer() {
    }

	public int getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getShipcity() {
		return this.shipcity;
	}

	public void setShipcity(String shipcity) {
		this.shipcity = shipcity;
	}

	public String getShipstate() {
		return this.shipstate;
	}

	public void setShipstate(String shipstate) {
		this.shipstate = shipstate;
	}

	public String getShipstraddress1() {
		return this.shipstraddress1;
	}

	public void setShipstraddress1(String shipstraddress1) {
		this.shipstraddress1 = shipstraddress1;
	}

	public String getShipstraddress2() {
		return this.shipstraddress2;
	}

	public void setShipstraddress2(String shipstraddress2) {
		this.shipstraddress2 = shipstraddress2;
	}

	public String getShipto() {
		return this.shipto;
	}

	public void setShipto(String shipto) {
		this.shipto = shipto;
	}

	public String getShipzip() {
		return this.shipzip;
	}

	public void setShipzip(String shipzip) {
		this.shipzip = shipzip;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStraddress1() {
		return this.straddress1;
	}

	public void setStraddress1(String straddress1) {
		this.straddress1 = straddress1;
	}

	public String getStraddress2() {
		return this.straddress2;
	}

	public void setStraddress2(String straddress2) {
		this.straddress2 = straddress2;
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

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<SalesOrder> getSalesOrders() {
		return this.salesOrders;
	}

	public void setSalesOrders(Set<SalesOrder> salesOrders) {
		this.salesOrders = salesOrders;
	}
	
}