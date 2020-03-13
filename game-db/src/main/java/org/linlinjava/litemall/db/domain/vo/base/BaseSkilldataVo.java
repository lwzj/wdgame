package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Skilldata;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSkilldataVo {
	public Integer id;
public String pid;
public String skillName;
public Integer skillLevel;
public Integer skillMubiao;

	
	public BaseSkilldataVo(){

	}
	
	public BaseSkilldataVo(Skilldata vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
pid= vo.getPid();
skillName= vo.getSkillName();
skillLevel= vo.getSkillLevel();
skillMubiao= vo.getSkillMubiao();

	}
	
	public static final BaseSkilldataVo t(Skilldata vo){
		return new BaseSkilldataVo(vo);
	}
	
	public static final List<BaseSkilldataVo> t(List<Skilldata> list){
		List<BaseSkilldataVo> listVo = new ArrayList<>();
		for (Skilldata temp : list) {
			listVo.add(new BaseSkilldataVo(temp));
		}
		return listVo;
	}

}