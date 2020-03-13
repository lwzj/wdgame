package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.DaySignPrize;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseDaySignPrizeVo {
	public Integer id;
public String name;
public Integer index;

	
	public BaseDaySignPrizeVo(){

	}
	
	public BaseDaySignPrizeVo(DaySignPrize vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
index= vo.getIndex();

	}
	
	public static final BaseDaySignPrizeVo t(DaySignPrize vo){
		return new BaseDaySignPrizeVo(vo);
	}
	
	public static final List<BaseDaySignPrizeVo> t(List<DaySignPrize> list){
		List<BaseDaySignPrizeVo> listVo = new ArrayList<>();
		for (DaySignPrize temp : list) {
			listVo.add(new BaseDaySignPrizeVo(temp));
		}
		return listVo;
	}

}