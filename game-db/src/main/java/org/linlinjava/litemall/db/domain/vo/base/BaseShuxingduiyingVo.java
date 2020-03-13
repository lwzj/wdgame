package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Shuxingduiying;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseShuxingduiyingVo {
	public Integer id;
public String name;
public String yingwen;

	
	public BaseShuxingduiyingVo(){

	}
	
	public BaseShuxingduiyingVo(Shuxingduiying vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
yingwen= vo.getYingwen();

	}
	
	public static final BaseShuxingduiyingVo t(Shuxingduiying vo){
		return new BaseShuxingduiyingVo(vo);
	}
	
	public static final List<BaseShuxingduiyingVo> t(List<Shuxingduiying> list){
		List<BaseShuxingduiyingVo> listVo = new ArrayList<>();
		for (Shuxingduiying temp : list) {
			listVo.add(new BaseShuxingduiyingVo(temp));
		}
		return listVo;
	}

}