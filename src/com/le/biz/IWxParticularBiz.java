package com.le.biz;

import java.util.List;

import com.le.entity.LeType;
import com.le.entity.WxParticular;

public interface IWxParticularBiz {
     public int add(WxParticular wp);
     
     public List<WxParticular> init(int page,int pageCount);
     
     public Long getSumPage(int pageCount);
     
     public void check(WxParticular wp);
     
     public boolean deleteWxParticularById(int id);
     
     public boolean setImageUrl(String imageUrl,int id);
     
     public boolean updateWxParticular(WxParticular wp);
     
     public WxParticular findWxParticularById(int id);
     
     public List<LeType> getAllType();
     
     public void test();
     
     public Long getCount(Integer eventKey,Integer date,Integer state);
     
     public List<Object[]> getAll();
}
