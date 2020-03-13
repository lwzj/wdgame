package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.RenwuMonster;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseRenwuMonsterVo {
	public Integer id;
public String mapName;
public Integer x;
public Integer y;
public String name;
public Integer icon;
public String skills;
public Integer type;

	
	public BaseRenwuMonsterVo(){

	}
	
	public BaseRenwuMonsterVo(RenwuMonster vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
mapName= vo.getMapName();
x= vo.getX();
y= vo.getY();
name= vo.getName();
icon= vo.getIcon();
skills= vo.getSkills();
type= vo.getType();

	}
	
	public static final BaseRenwuMonsterVo t(RenwuMonster vo){
		return new BaseRenwuMonsterVo(vo);
	}
	
	public static final List<BaseRenwuMonsterVo> t(List<RenwuMonster> list){
		List<BaseRenwuMonsterVo> listVo = new ArrayList<>();
		for (RenwuMonster temp : list) {
			listVo.add(new BaseRenwuMonsterVo(temp));
		}
		return listVo;
	}

}