package com.newt.leaveapplication.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newt.leaveapplication.dao.LeaveAppRepository;
import com.newt.leaveapplication.model.LeaveApplication;

@Service("LeaveAppImpl")
public class LeaveAppServiceImpl implements LeaveAppService {
	@Autowired
	LeaveAppRepository leaveAppRepo;

	public List<LeaveApplication> getAllLeave() {
		return leaveAppRepo.findAll();
	}

	public LeaveApplication addLeave(LeaveApplication leaveApp) {
		LeaveApplication leave=leaveAppRepo.save(leaveApp);
		Date fromDate =leave.getFromDate();
		Date toDate=leave.getToDate();
		long diff = toDate.getTime()-fromDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		Integer i = (int) (long) diffDays;
		leave.setNoOfDays(i);
		return leave;
		
	}

	public List<LeaveApplication> getLeave(long empId) {
		
		return leaveAppRepo.findAll();
	}

	public LeaveApplication updateLeave(LeaveApplication leaveApp) {
		LeaveApplication leave=leaveAppRepo.save(leaveApp);
		/*Date fromDate =leave.getFromDate();
		Date toDate=leave.getToDate();
		long diff = toDate.getTime()-fromDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		Integer i = (int) (long) diffDays;
		leave.setNoOfDays(i);*/
		return leave;
	
	}

	

	public void deleteleave(int leaveAppId) {
		leaveAppRepo.delete(leaveAppId);
		
	}

	public LeaveApplication getLeaveById(int leaveAppId) {
		return leaveAppRepo.findOne(leaveAppId);
	}

	public LeaveApplication getLeaveByEmpId(String empId) {
		LeaveApplication leave1= leaveAppRepo.findByEmpId(empId);
		Date fromDate =leave1.getFromDate();
		Date toDate=leave1.getToDate();
		long diff = toDate.getTime()-fromDate.getTime();
		long diffDays = diff / (24 * 60 * 60 * 1000);
		Integer i = (int) (long) diffDays;
		leave1.setNoOfDays(i);
		return leave1;
	}

	

	

	


}
