package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Srenwu;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSrenwuVo {
	public Integer id;
public String pid;
public Integer rid;
public String skillName;
public String skillJieshao;
public String skillDqti;
public String skillXck;

	
	public BaseSrenwuVo(){

	}
	
	public BaseSrenwuVo(Srenwu vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
pid= vo.getPid();
rid= vo.getRid();
skillName= vo.getSkillName();
skillJieshao= vo.getSkillJieshao();
skillDqti= vo.getSkillDqti();
skillXck= vo.getSkillXck();

	}
	
	public static final BaseSrenwuVo t(Srenwu vo){
		return new BaseSrenwuVo(vo);
	}
	
	public static final List<BaseSrenwuVo> t(List<Srenwu> list){
		List<BaseSrenwuVo> listVo = new ArrayList<>();
		for (Srenwu temp : list) {
			listVo.add(new BaseSrenwuVo(temp));
		}
		return listVo;
	}

}