package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Pet;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BasePetVo {
	public Integer id;
public Integer index;
public Integer levelReq;
public Integer life;
public Integer mana;
public Integer speed;
public Integer phyAttack;
public Integer magAttack;
public String polar;
public String skiils;
public String zoon;
public Integer icon;
public String name;

	
	public BasePetVo(){

	}
	
	public BasePetVo(Pet vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
index= vo.getIndex();
levelReq= vo.getLevelReq();
life= vo.getLife();
mana= vo.getMana();
speed= vo.getSpeed();
phyAttack= vo.getPhyAttack();
magAttack= vo.getMagAttack();
polar= vo.getPolar();
skiils= vo.getSkiils();
zoon= vo.getZoon();
icon= vo.getIcon();
name= vo.getName();

	}
	
	public static final BasePetVo t(Pet vo){
		return new BasePetVo(vo);
	}
	
	public static final List<BasePetVo> t(List<Pet> list){
		List<BasePetVo> listVo = new ArrayList<>();
		for (Pet temp : list) {
			listVo.add(new BasePetVo(temp));
		}
		return listVo;
	}

}