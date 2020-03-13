package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.SkillsChongw;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseSkillsChongwVo {
	public Integer id;
public String ownerid;
public String skllCwid;
public String skillIdHex;
public String skillName;
public Integer skillReqMenpai;
public Integer skillLevel;
public Integer skillMubiao;
public String tianshuId;
public String tianshuName;

	
	public BaseSkillsChongwVo(){

	}
	
	public BaseSkillsChongwVo(SkillsChongw vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
ownerid= vo.getOwnerid();
skllCwid= vo.getSkllCwid();
skillIdHex= vo.getSkillIdHex();
skillName= vo.getSkillName();
skillReqMenpai= vo.getSkillReqMenpai();
skillLevel= vo.getSkillLevel();
skillMubiao= vo.getSkillMubiao();
tianshuId= vo.getTianshuId();
tianshuName= vo.getTianshuName();

	}
	
	public static final BaseSkillsChongwVo t(SkillsChongw vo){
		return new BaseSkillsChongwVo(vo);
	}
	
	public static final List<BaseSkillsChongwVo> t(List<SkillsChongw> list){
		List<BaseSkillsChongwVo> listVo = new ArrayList<>();
		for (SkillsChongw temp : list) {
			listVo.add(new BaseSkillsChongwVo(temp));
		}
		return listVo;
	}

}