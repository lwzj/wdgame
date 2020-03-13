package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Charge;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseChargeVo {
	public Integer id;
public String accountname;
public Integer coin;
public Integer state;
public Integer money;
public String code;

	
	public BaseChargeVo(){

	}
	
	public BaseChargeVo(Charge vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
accountname= vo.getAccountname();
coin= vo.getCoin();
state= vo.getState();
money= vo.getMoney();
code= vo.getCode();

	}
	
	public static final BaseChargeVo t(Charge vo){
		return new BaseChargeVo(vo);
	}
	
	public static final List<BaseChargeVo> t(List<Charge> list){
		List<BaseChargeVo> listVo = new ArrayList<>();
		for (Charge temp : list) {
			listVo.add(new BaseChargeVo(temp));
		}
		return listVo;
	}

}