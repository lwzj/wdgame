package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Skills;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSkillsVo {
	public Integer id;
public String skillIdHex;
public String skillName;
public Integer skillReqMenpai;
public Integer skillType;
public Integer skillTypeLevel;
public Integer skillMagic;
public Integer skillReqLevel;
public String skillContext;

	
	public BaseSkillsVo(){

	}
	
	public BaseSkillsVo(Skills vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
skillIdHex= vo.getSkillIdHex();
skillName= vo.getSkillName();
skillReqMenpai= vo.getSkillReqMenpai();
skillType= vo.getSkillType();
skillTypeLevel= vo.getSkillTypeLevel();
skillMagic= vo.getSkillMagic();
skillReqLevel= vo.getSkillReqLevel();
skillContext= vo.getSkillContext();

	}
	
	public static final BaseSkillsVo t(Skills vo){
		return new BaseSkillsVo(vo);
	}
	
	public static final List<BaseSkillsVo> t(List<Skills> list){
		List<BaseSkillsVo> listVo = new ArrayList<>();
		for (Skills temp : list) {
			listVo.add(new BaseSkillsVo(temp));
		}
		return listVo;
	}

}