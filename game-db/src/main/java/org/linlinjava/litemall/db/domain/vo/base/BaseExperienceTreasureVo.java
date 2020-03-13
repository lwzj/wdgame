package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.ExperienceTreasure;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseExperienceTreasureVo {
	public Integer attrib;
public Integer maxLevel;

	
	public BaseExperienceTreasureVo(){

	}
	
	public BaseExperienceTreasureVo(ExperienceTreasure vo){
		if(vo==null){
			return;
		}
		attrib= vo.getAttrib();
maxLevel= vo.getMaxLevel();

	}
	
	public static final BaseExperienceTreasureVo t(ExperienceTreasure vo){
		return new BaseExperienceTreasureVo(vo);
	}
	
	public static final List<BaseExperienceTreasureVo> t(List<ExperienceTreasure> list){
		List<BaseExperienceTreasureVo> listVo = new ArrayList<>();
		for (ExperienceTreasure temp : list) {
			listVo.add(new BaseExperienceTreasureVo(temp));
		}
		return listVo;
	}

}