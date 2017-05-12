package com.newt.leaveapplication.service;

import java.util.List;
import com.newt.leaveapplication.model.LeaveApplication;

public interface LeaveAppService {
	 public List<LeaveApplication> getAllLeave() ;
	 public LeaveApplication addLeave(LeaveApplication leaveApp);
	 public LeaveApplication getLeaveById(int leaveAppId);
	 public LeaveApplication updateLeave(LeaveApplication leaveApp);
	 public void deleteleave(int leaveAppId);
	 public LeaveApplication getLeaveByEmpId(String empId);
	
	 
}
