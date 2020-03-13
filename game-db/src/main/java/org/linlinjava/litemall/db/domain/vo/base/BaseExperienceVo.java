package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Experience;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseExperienceVo {
	public Integer attrib;
public Integer maxLevel;

	
	public BaseExperienceVo(){

	}
	
	public BaseExperienceVo(Experience vo){
		if(vo==null){
			return;
		}
		attrib= vo.getAttrib();
maxLevel= vo.getMaxLevel();

	}
	
	public static final BaseExperienceVo t(Experience vo){
		return new BaseExperienceVo(vo);
	}
	
	public static final List<BaseExperienceVo> t(List<Experience> list){
		List<BaseExperienceVo> listVo = new ArrayList<>();
		for (Experience temp : list) {
			listVo.add(new BaseExperienceVo(temp));
		}
		return listVo;
	}

}