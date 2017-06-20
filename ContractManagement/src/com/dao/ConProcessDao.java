package com.dao;

import java.util.List;

import com.model.ConProcess;
import com.utils.AppException;


public interface ConProcessDao {

	//judge if there id the contract
	public boolean isExist(int conId) throws AppException;
	
	//add contract process
	public boolean add(ConProcess conProcess) throws AppException;
	
	//get contract ids by contract process
	public List<Integer> getConIds(ConProcess conProcess) throws AppException;
	
	//update the contract
	public boolean update(ConProcess conProcess) throws AppException;
	
	//get total count of contract
	public int getTotalCount(ConProcess conProcess) throws AppException;
	
	//get contract process ids
	public List<Integer> getIds(int conId, int type, int state) throws AppException;
	
	//get contract process by id
	public ConProcess getById(int id) throws AppException;
	
}
