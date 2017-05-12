package com.newt.leaveapplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_LEAVE_STATUS")
public class LeaveStatus {
	@Id
	@Column(name="LEAVE_STATUS_ID")
	private int leaveStatusId;
	@Column(name="STATUS")
	private String status;
	
	
	public LeaveStatus(){
		
	}
	public LeaveStatus(int leaveStatusId, String status) {
		super();
		this.leaveStatusId = leaveStatusId;
		this.status = status;
	}
	public int getLeaveStatusId() {
		return leaveStatusId;
	}
	public void setLeaveStatusId(int leaveStatusId) {
		this.leaveStatusId = leaveStatusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LeaveStatus [leaveStatusId=" + leaveStatusId + ", status=" + status + "]";
	}

}
