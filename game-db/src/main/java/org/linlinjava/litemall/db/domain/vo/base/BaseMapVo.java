package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Map;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseMapVo {
	public Integer id;
public String name;
public Integer mapId;
public Integer x;
public Integer y;
public String icon;
public Integer monsterLevel;

	
	public BaseMapVo(){

	}
	
	public BaseMapVo(Map vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
mapId= vo.getMapId();
x= vo.getX();
y= vo.getY();
icon= vo.getIcon();
monsterLevel= vo.getMonsterLevel();

	}
	
	public static final BaseMapVo t(Map vo){
		return new BaseMapVo(vo);
	}
	
	public static final List<BaseMapVo> t(List<Map> list){
		List<BaseMapVo> listVo = new ArrayList<>();
		for (Map temp : list) {
			listVo.add(new BaseMapVo(temp));
		}
		return listVo;
	}

}