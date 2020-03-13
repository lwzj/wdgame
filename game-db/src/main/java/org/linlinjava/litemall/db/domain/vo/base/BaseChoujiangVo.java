package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Choujiang;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseChoujiangVo {
	public Integer id;
public Integer no;
public String name;
public String desc;
public Integer level;

	
	public BaseChoujiangVo(){

	}
	
	public BaseChoujiangVo(Choujiang vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
no= vo.getNo();
name= vo.getName();
desc= vo.getDesc();
level= vo.getLevel();

	}
	
	public static final BaseChoujiangVo t(Choujiang vo){
		return new BaseChoujiangVo(vo);
	}
	
	public static final List<BaseChoujiangVo> t(List<Choujiang> list){
		List<BaseChoujiangVo> listVo = new ArrayList<>();
		for (Choujiang temp : list) {
			listVo.add(new BaseChoujiangVo(temp));
		}
		return listVo;
	}

}