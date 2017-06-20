package com.dao;

import java.util.List;

import com.model.ConState;
import com.utils.AppException;


public interface ConStateDao {

	//add contract state
	public boolean add(ConState conState) throws AppException;
	
	//get contract ids by type
	public List<Integer> getConIdsByType(int type) throws AppException;
	
	//get contract state
	public ConState getConState(int conId, int type) throws AppException;
	
	//jusge if there is the contract state
	public boolean isExist(int con_id, int type) throws AppException;
	
}
