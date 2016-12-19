package com.le.dao;

import java.util.List;

import com.le.entity.LeType;

public interface ILeTypeDao {
    public int add(LeType leType);
    
    public int deleteById(int id);
    
    public int updateById(int id);
    
    public List<LeType> getAll();
}
