package com.itbeans.orders.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the job database table.
 * 
 */
@Entity
@Table(name="job")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int jobid;

	private String createdby;

    @Temporal( TemporalType.DATE)
	private Date createddate;

	private String description;

	private String updatedby;

    @Temporal( TemporalType.DATE)
	private Date updateddate;

	//bi-directional many-to-one association to SalesOrderDetail
	@OneToMany(mappedBy="job")
	private Set<SalesOrderDetail> salesOrderDetails;

    public Job() {
    }

	public int getJobid() {
		return this.jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
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

	public Set<SalesOrderDetail> getSalesOrderDetails() {
		return this.salesOrderDetails;
	}

	public void setSalesOrderDetails(Set<SalesOrderDetail> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}
	
}