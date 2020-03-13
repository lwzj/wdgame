package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.MedicineShop;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseMedicineShopVo {
	public Integer id;
public Integer goodsNo;
public Integer payType;
public String name;
public Integer value;
public Integer level;
public Integer type;
public Integer itemcount;

	
	public BaseMedicineShopVo(){

	}
	
	public BaseMedicineShopVo(MedicineShop vo){
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
	
	public static final BaseMedicineShopVo t(MedicineShop vo){
		return new BaseMedicineShopVo(vo);
	}
	
	public static final List<BaseMedicineShopVo> t(List<MedicineShop> list){
		List<BaseMedicineShopVo> listVo = new ArrayList<>();
		for (MedicineShop temp : list) {
			listVo.add(new BaseMedicineShopVo(temp));
		}
		return listVo;
	}

}