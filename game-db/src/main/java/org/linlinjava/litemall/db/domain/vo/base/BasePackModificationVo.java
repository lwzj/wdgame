package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.PackModification;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BasePackModificationVo {
	public Integer id;
public String alias;
public String fasionType;
public String str;
public String type;
public Integer foodNum;
public Integer goodsPrice;
public Integer sex;
public Integer position;
public Integer category;

	
	public BasePackModificationVo(){

	}
	
	public BasePackModificationVo(PackModification vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
alias= vo.getAlias();
fasionType= vo.getFasionType();
str= vo.getStr();
type= vo.getType();
foodNum= vo.getFoodNum();
goodsPrice= vo.getGoodsPrice();
sex= vo.getSex();
position= vo.getPosition();
category= vo.getCategory();

	}
	
	public static final BasePackModificationVo t(PackModification vo){
		return new BasePackModificationVo(vo);
	}
	
	public static final List<BasePackModificationVo> t(List<PackModification> list){
		List<BasePackModificationVo> listVo = new ArrayList<>();
		for (PackModification temp : list) {
			listVo.add(new BasePackModificationVo(temp));
		}
		return listVo;
	}

}