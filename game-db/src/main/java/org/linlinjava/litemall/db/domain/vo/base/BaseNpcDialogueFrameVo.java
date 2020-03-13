package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.NpcDialogueFrame;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseNpcDialogueFrameVo {
	public Integer id;
public Integer portrait;
public Integer picNo;
public String content;
public String secretKey;
public String name;
public Integer attrib;
public LocalDateTime updateTimes;
public Integer idname;
public String next;
public String currentTask;
public String uncontent;
public String zhuangbei;
public Integer jingyan;
public Integer money;

	
	public BaseNpcDialogueFrameVo(){

	}
	
	public BaseNpcDialogueFrameVo(NpcDialogueFrame vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
portrait= vo.getPortrait();
picNo= vo.getPicNo();
content= vo.getContent();
secretKey= vo.getSecretKey();
name= vo.getName();
attrib= vo.getAttrib();
updateTimes= vo.getUpdateTimes();
idname= vo.getIdname();
next= vo.getNext();
currentTask= vo.getCurrentTask();
uncontent= vo.getUncontent();
zhuangbei= vo.getZhuangbei();
jingyan= vo.getJingyan();
money= vo.getMoney();

	}
	
	public static final BaseNpcDialogueFrameVo t(NpcDialogueFrame vo){
		return new BaseNpcDialogueFrameVo(vo);
	}
	
	public static final List<BaseNpcDialogueFrameVo> t(List<NpcDialogueFrame> list){
		List<BaseNpcDialogueFrameVo> listVo = new ArrayList<>();
		for (NpcDialogueFrame temp : list) {
			listVo.add(new BaseNpcDialogueFrameVo(temp));
		}
		return listVo;
	}

}