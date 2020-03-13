package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseZhuangbeiInfoVo {
	public Integer id;
public Integer attrib;
public Integer amount;
public Integer type;
public String str;
public String quality;
public Integer master;
public Integer metal;
public Integer mana;
public Integer accurate;
public Integer def;
public Integer dex;
public Integer wiz;
public Integer parry;

	
	public BaseZhuangbeiInfoVo(){

	}
	
	public BaseZhuangbeiInfoVo(ZhuangbeiInfo vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
attrib= vo.getAttrib();
amount= vo.getAmount();
type= vo.getType();
str= vo.getStr();
quality= vo.getQuality();
master= vo.getMaster();
metal= vo.getMetal();
mana= vo.getMana();
accurate= vo.getAccurate();
def= vo.getDef();
dex= vo.getDex();
wiz= vo.getWiz();
parry= vo.getParry();

	}
	
	public static final BaseZhuangbeiInfoVo t(ZhuangbeiInfo vo){
		return new BaseZhuangbeiInfoVo(vo);
	}
	
	public static final List<BaseZhuangbeiInfoVo> t(List<ZhuangbeiInfo> list){
		List<BaseZhuangbeiInfoVo> listVo = new ArrayList<>();
		for (ZhuangbeiInfo temp : list) {
			listVo.add(new BaseZhuangbeiInfoVo(temp));
		}
		return listVo;
	}

}