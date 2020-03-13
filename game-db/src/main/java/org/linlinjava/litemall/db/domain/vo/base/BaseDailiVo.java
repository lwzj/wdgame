package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Daili;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseDailiVo {
	public Integer id;
public String account;
public String passwd;
public String code;
public String token;

	
	public BaseDailiVo(){

	}
	
	public BaseDailiVo(Daili vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
account= vo.getAccount();
passwd= vo.getPasswd();
code= vo.getCode();
token= vo.getToken();

	}
	
	public static final BaseDailiVo t(Daili vo){
		return new BaseDailiVo(vo);
	}
	
	public static final List<BaseDailiVo> t(List<Daili> list){
		List<BaseDailiVo> listVo = new ArrayList<>();
		for (Daili temp : list) {
			listVo.add(new BaseDailiVo(temp));
		}
		return listVo;
	}

}