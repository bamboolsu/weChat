package com.le.dao;

import com.le.entity.NumberOfSubscriptions;
import com.le.entity.WxUser;

public interface INumberOfSubscriptionsDao {
   public void save(NumberOfSubscriptions nos,WxUser wxUser);
   
   public NumberOfSubscriptions findById(String openId);
   
   public void delete(String openId);
   
   public void update(NumberOfSubscriptions nos);
   
   public int getWxEventCount(String date);
}
