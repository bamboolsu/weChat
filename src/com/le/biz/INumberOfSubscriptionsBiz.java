package com.le.biz;

import com.le.entity.NumberOfSubscriptions;
/**
 * biz
 * @author admin
 *
 */
public interface INumberOfSubscriptionsBiz {
   public void add(NumberOfSubscriptions nos);
   
   public void delete(String openId);
}
