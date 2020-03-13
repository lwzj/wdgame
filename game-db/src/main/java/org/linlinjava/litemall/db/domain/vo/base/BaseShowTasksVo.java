package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.ShowTasks;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseShowTasksVo {
	public Integer id;
public String taskType;
public String taskDesc;
public String taskPrompt;
public Integer refresh;
public Integer taskEndTime;
public Integer attrib;
public String reward;
public String showName;
public String tasktaskExtraPara;
public Integer tasktaskState;

	
	public BaseShowTasksVo(){

	}
	
	public BaseShowTasksVo(ShowTasks vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
taskType= vo.getTaskType();
taskDesc= vo.getTaskDesc();
taskPrompt= vo.getTaskPrompt();
refresh= vo.getRefresh();
taskEndTime= vo.getTaskEndTime();
attrib= vo.getAttrib();
reward= vo.getReward();
showName= vo.getShowName();
tasktaskExtraPara= vo.getTasktaskExtraPara();
tasktaskState= vo.getTasktaskState();

	}
	
	public static final BaseShowTasksVo t(ShowTasks vo){
		return new BaseShowTasksVo(vo);
	}
	
	public static final List<BaseShowTasksVo> t(List<ShowTasks> list){
		List<BaseShowTasksVo> listVo = new ArrayList<>();
		for (ShowTasks temp : list) {
			listVo.add(new BaseShowTasksVo(temp));
		}
		return listVo;
	}

}