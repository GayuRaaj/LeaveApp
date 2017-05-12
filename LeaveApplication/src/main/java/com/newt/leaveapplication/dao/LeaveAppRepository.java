package com.newt.leaveapplication.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.newt.leaveapplication.model.LeaveApplication;

@Repository
public interface LeaveAppRepository extends CrudRepository<LeaveApplication, Integer> {
	
	 public long count() ;
	 public List< LeaveApplication> findAll() ;
	 public void delete(Integer leaveAppId);
	 public LeaveApplication findOne(Integer leaveAppId);
	 public <S extends  LeaveApplication> List<S> save(Iterable<S> leaveAppliacation) ;
	 public LeaveApplication findByEmpId(String empId) ;
	
	
	 
	
}
