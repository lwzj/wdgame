package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.SkillMonster;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSkillMonsterVo {
	public Integer id;
public String name;
public String skills;
public Integer type;

	
	public BaseSkillMonsterVo(){

	}
	
	public BaseSkillMonsterVo(SkillMonster vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
skills= vo.getSkills();
type= vo.getType();

	}
	
	public static final BaseSkillMonsterVo t(SkillMonster vo){
		return new BaseSkillMonsterVo(vo);
	}
	
	public static final List<BaseSkillMonsterVo> t(List<SkillMonster> list){
		List<BaseSkillMonsterVo> listVo = new ArrayList<>();
		for (SkillMonster temp : list) {
			listVo.add(new BaseSkillMonsterVo(temp));
		}
		return listVo;
	}

}