package com.newt.leaveapplication.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="TBL_LEAVE_APPLICATION")
public class LeaveApplication implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="LEAVE_APP_ID")
	private int leaveAppId;
	
	@NotNull
	@Column(name="EMP_ID")
	private String empId;
	@NotNull
	@Column(name="FROM_DATE")
	private Date fromDate;
	@NotNull
	@Column(name="TO_DATE")
	private Date toDate;
	@NotNull
	@Column(name="COMMENTS")
	private String comments;
	@NotNull
	@Column(name="LEAVE_TYPE_ID")
	private int leaveTypeId;
	@NotNull
	@Column(name="LEAVE_STATUS_ID",columnDefinition = "int(11) default '1'")
	private int leaveStatusId;
	
	@Column(name="NO_OF_DAYS")
	private int noOfDays;
	@Column(name="HALF_DAY")
	private int half_day;

	@NotNull
	@Column(name="CREATE_DATE")
	private Date createDate;
	@NotNull
	@Column(name="MODIFIED_DATE")
	private Date modifiedDate;
	@NotNull
	@Column(name="MODIFIED_BY")
	private String modifiedBy;
/*
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="LEAVE_STATUS_ID",insertable=false, updatable=false)
	private LeaveStatus leaveStatus;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="LEAVE_TYPE_ID",insertable=false, updatable=false)
	private LeaveType leaveType;

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="EMP_ID",referencedColumnName="ID",insertable=false, updatable=false)
	private Employee employee;*/
	public LeaveApplication(){

	}
	
	public LeaveApplication(int leaveAppId, String empId, Date fromDate, Date toDate, String comments, int leaveTypeId,
		int leaveStatusId, int noOfDays, int half_day, Date createDate, Date modifiedDate, String modifiedBy) {
	super();
	this.leaveAppId = leaveAppId;
	this.empId = empId;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.comments = comments;
	this.leaveTypeId = leaveTypeId;
	this.leaveStatusId = leaveStatusId;
	this.noOfDays = noOfDays;
	this.half_day = half_day;
	this.createDate = createDate;
	this.modifiedDate = modifiedDate;
	this.modifiedBy = modifiedBy;
}
	

	public int getHalf_day() {
		return half_day;
	}

	public void setHalf_day(int half_day) {
		this.half_day = half_day;
	}

	public int getLeaveAppId() {
		return leaveAppId;
	}
	public void setLeaveAppId(int leaveAppId) {
		this.leaveAppId = leaveAppId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getLeaveTypeId() {
		return leaveTypeId;
	}
	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}
	public int getLeaveStatusId() {
		return leaveStatusId;
	}
	public void setLeaveStatusId(int leaveStatusId) {
		this.leaveStatusId = leaveStatusId;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}