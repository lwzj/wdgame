package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.NpcDialogue;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseNpcDialogueVo {
	public Integer id;
public String name;
public Integer portranit;
public Integer picNo;
public String content;
public Integer isconmlete;
public Integer isincombat;
public Integer palytime;
public String taskType;
public String idname;

	
	public BaseNpcDialogueVo(){

	}
	
	public BaseNpcDialogueVo(NpcDialogue vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
portranit= vo.getPortranit();
picNo= vo.getPicNo();
content= vo.getContent();
isconmlete= vo.getIsconmlete();
isincombat= vo.getIsincombat();
palytime= vo.getPalytime();
taskType= vo.getTaskType();
idname= vo.getIdname();

	}
	
	public static final BaseNpcDialogueVo t(NpcDialogue vo){
		return new BaseNpcDialogueVo(vo);
	}
	
	public static final List<BaseNpcDialogueVo> t(List<NpcDialogue> list){
		List<BaseNpcDialogueVo> listVo = new ArrayList<>();
		for (NpcDialogue temp : list) {
			listVo.add(new BaseNpcDialogueVo(temp));
		}
		return listVo;
	}

}