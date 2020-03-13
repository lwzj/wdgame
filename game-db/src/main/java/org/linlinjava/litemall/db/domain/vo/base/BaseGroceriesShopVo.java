package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.GroceriesShop;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseGroceriesShopVo {
	public Integer id;
public Integer goodsNo;
public Integer payType;
public String name;
public Integer value;
public Integer level;
public Integer type;
public Integer itemcount;

	
	public BaseGroceriesShopVo(){

	}
	
	public BaseGroceriesShopVo(GroceriesShop vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
goodsNo= vo.getGoodsNo();
payType= vo.getPayType();
name= vo.getName();
value= vo.getValue();
level= vo.getLevel();
type= vo.getType();
itemcount= vo.getItemcount();

	}
	
	public static final BaseGroceriesShopVo t(GroceriesShop vo){
		return new BaseGroceriesShopVo(vo);
	}
	
	public static final List<BaseGroceriesShopVo> t(List<GroceriesShop> list){
		List<BaseGroceriesShopVo> listVo = new ArrayList<>();
		for (GroceriesShop temp : list) {
			listVo.add(new BaseGroceriesShopVo(temp));
		}
		return listVo;
	}

}