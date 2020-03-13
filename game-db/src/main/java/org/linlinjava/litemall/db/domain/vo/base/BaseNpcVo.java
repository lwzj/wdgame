package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Npc;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseNpcVo {
	public Integer id;
public Integer icon;
public Integer x;
public Integer y;
public String name;
public Integer mapId;

	
	public BaseNpcVo(){

	}
	
	public BaseNpcVo(Npc vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
icon= vo.getIcon();
x= vo.getX();
y= vo.getY();
name= vo.getName();
mapId= vo.getMapId();

	}
	
	public static final BaseNpcVo t(Npc vo){
		return new BaseNpcVo(vo);
	}
	
	public static final List<BaseNpcVo> t(List<Npc> list){
		List<BaseNpcVo> listVo = new ArrayList<>();
		for (Npc temp : list) {
			listVo.add(new BaseNpcVo(temp));
		}
		return listVo;
	}

}