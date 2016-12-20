package com.le.dao;

import java.util.List;

import com.le.entity.WxParticular;


public interface IWxParticularDao {
   public int add(WxParticular wxPar);
   
   public int deleteById(int id);
   
   public int updateById(WxParticular wxPar);
   
   public List<WxParticular> getAll(int startLine,int pageCount);
   
   public long getCount();
   
   public int getEventKey(int id);
   
   public int setImageUrl(String imageUrl,int id);
   
   public WxParticular findWxParticularById(int id);
   
   public void test();
   
   public Long countByEventKey(String hql,Object[] values);
   
   
}
