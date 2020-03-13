package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.SaleClassifyGood;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSaleClassifyGoodVo {
	public Integer id;
public String pname;
public String cname;
public String attrib;
public Integer icon;
public String str;
public Integer price;
public String compose;

	
	public BaseSaleClassifyGoodVo(){

	}
	
	public BaseSaleClassifyGoodVo(SaleClassifyGood vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
pname= vo.getPname();
cname= vo.getCname();
attrib= vo.getAttrib();
icon= vo.getIcon();
str= vo.getStr();
price= vo.getPrice();
compose= vo.getCompose();

	}
	
	public static final BaseSaleClassifyGoodVo t(SaleClassifyGood vo){
		return new BaseSaleClassifyGoodVo(vo);
	}
	
	public static final List<BaseSaleClassifyGoodVo> t(List<SaleClassifyGood> list){
		List<BaseSaleClassifyGoodVo> listVo = new ArrayList<>();
		for (SaleClassifyGood temp : list) {
			listVo.add(new BaseSaleClassifyGoodVo(temp));
		}
		return listVo;
	}

}