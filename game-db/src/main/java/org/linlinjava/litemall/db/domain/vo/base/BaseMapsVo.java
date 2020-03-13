package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Maps;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseMapsVo {
	public Integer id;
public String name;
public Integer type;
public Integer map;
public Float dir;
public Float x;
public Float y;

	
	public BaseMapsVo(){

	}
	
	public BaseMapsVo(Maps vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
type= vo.getType();
map= vo.getMap();
dir= vo.getDir();
x= vo.getX();
y= vo.getY();

	}
	
	public static final BaseMapsVo t(Maps vo){
		return new BaseMapsVo(vo);
	}
	
	public static final List<BaseMapsVo> t(List<Maps> list){
		List<BaseMapsVo> listVo = new ArrayList<>();
		for (Maps temp : list) {
			listVo.add(new BaseMapsVo(temp));
		}
		return listVo;
	}

}