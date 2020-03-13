package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.SaleGood;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSaleGoodVo {
	public Integer id;
public String goodsId;
public String name;
public Integer startTime;
public Integer endTime;
public Integer price;
public Integer reqLevel;
public String ownerUuid;
public String str;
public String pet;
public Integer pos;
public Integer ispet;
public Integer level;
public String goods;

	
	public BaseSaleGoodVo(){

	}
	
	public BaseSaleGoodVo(SaleGood vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
goodsId= vo.getGoodsId();
name= vo.getName();
startTime= vo.getStartTime();
endTime= vo.getEndTime();
price= vo.getPrice();
reqLevel= vo.getReqLevel();
ownerUuid= vo.getOwnerUuid();
str= vo.getStr();
pet= vo.getPet();
pos= vo.getPos();
ispet= vo.getIspet();
level= vo.getLevel();
goods= vo.getGoods();

	}
	
	public static final BaseSaleGoodVo t(SaleGood vo){
		return new BaseSaleGoodVo(vo);
	}
	
	public static final List<BaseSaleGoodVo> t(List<SaleGood> list){
		List<BaseSaleGoodVo> listVo = new ArrayList<>();
		for (SaleGood temp : list) {
			listVo.add(new BaseSaleGoodVo(temp));
		}
		return listVo;
	}

}