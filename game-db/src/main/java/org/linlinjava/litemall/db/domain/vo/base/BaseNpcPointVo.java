package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.NpcPoint;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseNpcPointVo {
	public Integer id;
public String mapname;
public String doorname;
public Integer x;
public Integer y;
public Integer z;
public Integer inx;
public Integer iny;

	
	public BaseNpcPointVo(){

	}
	
	public BaseNpcPointVo(NpcPoint vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
mapname= vo.getMapname();
doorname= vo.getDoorname();
x= vo.getX();
y= vo.getY();
z= vo.getZ();
inx= vo.getInx();
iny= vo.getIny();

	}
	
	public static final BaseNpcPointVo t(NpcPoint vo){
		return new BaseNpcPointVo(vo);
	}
	
	public static final List<BaseNpcPointVo> t(List<NpcPoint> list){
		List<BaseNpcPointVo> listVo = new ArrayList<>();
		for (NpcPoint temp : list) {
			listVo.add(new BaseNpcPointVo(temp));
		}
		return listVo;
	}

}