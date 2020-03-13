package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.PetHelpType;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BasePetHelpTypeVo {
	public Integer id;
public Integer type;
public String name;
public Integer quality;
public Integer money;
public Integer polar;

	
	public BasePetHelpTypeVo(){

	}
	
	public BasePetHelpTypeVo(PetHelpType vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
type= vo.getType();
name= vo.getName();
quality= vo.getQuality();
money= vo.getMoney();
polar= vo.getPolar();

	}
	
	public static final BasePetHelpTypeVo t(PetHelpType vo){
		return new BasePetHelpTypeVo(vo);
	}
	
	public static final List<BasePetHelpTypeVo> t(List<PetHelpType> list){
		List<BasePetHelpTypeVo> listVo = new ArrayList<>();
		for (PetHelpType temp : list) {
			listVo.add(new BasePetHelpTypeVo(temp));
		}
		return listVo;
	}

}