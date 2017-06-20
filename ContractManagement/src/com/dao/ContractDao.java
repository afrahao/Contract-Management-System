package com.dao;

import java.util.List;

import com.model.Contract;
import com.utils.AppException;


public interface ContractDao {

	//add contract
	public boolean add(Contract contract) throws AppException;
	
	//get contract by contract id
	public Contract getById(int id) throws AppException;
	
	//get contract id by user id
	public List<Integer> getIdsByUserId(int userId) throws AppException;
	
	//update contract
	public boolean updateById(Contract contract) throws AppException;
}
