package com.dao;

import com.exception.HodException;
import com.model.Hod;

public interface HodDao {
	public Hod loginHod(String username,String password) throws HodException;
}
