package com.newt.leaveapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newt.leaveapplication.model.LeaveApplication;
import com.newt.leaveapplication.service.LeaveAppService;

@RestController
@RequestMapping("/LeaveAppController")
@CrossOrigin(maxAge=3600)
public class LeaveAppController {
	@Autowired
	LeaveAppService leaveAppService;
	@RequestMapping(method= RequestMethod.GET,value="/get", produces = "application/json")
	public List<LeaveApplication> getAllLeaveApplication(){
		List<LeaveApplication> leaveList=leaveAppService.getAllLeave();
		return leaveList;
		
	}

	@RequestMapping(method=RequestMethod.POST,value="/add", produces = "application/json")
	public LeaveApplication addLeaveApplication(@RequestBody LeaveApplication leaveApp){
		System.out.println("Adding :"+leaveApp);
		return leaveAppService.addLeave(leaveApp);
		
	}

	@RequestMapping(method=RequestMethod.GET,value="/{empId}", produces = "application/json")
	public LeaveApplication getLeaveApplicationByEmpId(@PathVariable("empId") String empId){
		return leaveAppService.getLeaveByEmpId(empId);
		
	}
	@RequestMapping(method=RequestMethod.PUT,produces = "application/json")
	public LeaveApplication updateLeave(LeaveApplication leaveApp){
        
		String serviceName = "localhost:8768";
		String url = "http://" + serviceName;
		int noofleave=leaveApp.getNoOfDays();
		if(leaveApp.getLeaveStatusId()==2){
			LeaveBalance balanceList[] = null;
			balanceList = restTemplate.getForObject(url + "/leavebalance/get/byempId/{empId}", LeaveBalance[].class,leaveApp.getEmpId());
			for (int i = 0; i < balanceList.length; i++) {
				System.out.println(balanceList[i]);
				LeaveBalance bal=balanceList[i];
				int oldleavecount=bal.getLeaveCount();
				int newLeaveCount=oldleavecount-noofleave;
				if(leaveApp.getLeaveTypeId()==bal.getLeaveTypeId()){
					bal.setLeaveCount(newLeaveCount);
					restTemplate.put(url + "/leavebalance/update", bal);}

			}



		}
		LeaveApplication leave= leaveAppService.updateLeave(leaveApp);
		return leave;
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/{leaveAppId}",produces = "application/json")
	public void deleteLeaveApplication(@PathVariable("leaveAppId")int leaveAppId){
		leaveAppService.deleteleave(leaveAppId);
		
	}
	
	
}


