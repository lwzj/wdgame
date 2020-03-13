package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Renwu;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseRenwuVo {
	public Integer id;
public String uncontent;
public String npcName;
public String currentTask;
public String showName;
public String taskPrompt;
public String reward;

	
	public BaseRenwuVo(){

	}
	
	public BaseRenwuVo(Renwu vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
uncontent= vo.getUncontent();
npcName= vo.getNpcName();
currentTask= vo.getCurrentTask();
showName= vo.getShowName();
taskPrompt= vo.getTaskPrompt();
reward= vo.getReward();

	}
	
	public static final BaseRenwuVo t(Renwu vo){
		return new BaseRenwuVo(vo);
	}
	
	public static final List<BaseRenwuVo> t(List<Renwu> list){
		List<BaseRenwuVo> listVo = new ArrayList<>();
		for (Renwu temp : list) {
			listVo.add(new BaseRenwuVo(temp));
		}
		return listVo;
	}

}