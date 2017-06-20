package com.dao;

import java.util.List;

import com.model.Contract;
import com.utils.AppException;


public interface 	ContractDao {

	
	public boolean add(Contract contract) throws AppException;
	
	
	public Contract getById(int id) throws AppException;
	
	
	public List<Integer> getIdsByUserId(int userId) throws AppException;
	
	
	public boolean updateById(Contract contract) throws AppException;
}
