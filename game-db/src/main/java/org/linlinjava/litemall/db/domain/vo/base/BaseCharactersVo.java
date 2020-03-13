package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Characters;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseCharactersVo {
	public Integer id;
public Integer menpai;
public String name;
public Integer accountId;
public String gid;
public String data;

	
	public BaseCharactersVo(){

	}
	
	public BaseCharactersVo(Characters vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
menpai= vo.getMenpai();
name= vo.getName();
accountId= vo.getAccountId();
gid= vo.getGid();
data= vo.getData();

	}
	
	public static final BaseCharactersVo t(Characters vo){
		return new BaseCharactersVo(vo);
	}
	
	public static final List<BaseCharactersVo> t(List<Characters> list){
		List<BaseCharactersVo> listVo = new ArrayList<>();
		for (Characters temp : list) {
			listVo.add(new BaseCharactersVo(temp));
		}
		return listVo;
	}

}