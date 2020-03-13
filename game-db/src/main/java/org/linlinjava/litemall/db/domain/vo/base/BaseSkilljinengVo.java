package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Skilljineng;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSkilljinengVo {
	public Integer id;
public Integer rid;
public String pid;
public String skillName;
public Integer skillLevel;
public Integer skillMubiao;
public Integer skillMp;

	
	public BaseSkilljinengVo(){

	}
	
	public BaseSkilljinengVo(Skilljineng vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
rid= vo.getRid();
pid= vo.getPid();
skillName= vo.getSkillName();
skillLevel= vo.getSkillLevel();
skillMubiao= vo.getSkillMubiao();
skillMp= vo.getSkillMp();

	}
	
	public static final BaseSkilljinengVo t(Skilljineng vo){
		return new BaseSkilljinengVo(vo);
	}
	
	public static final List<BaseSkilljinengVo> t(List<Skilljineng> list){
		List<BaseSkilljinengVo> listVo = new ArrayList<>();
		for (Skilljineng temp : list) {
			listVo.add(new BaseSkilljinengVo(temp));
		}
		return listVo;
	}

}