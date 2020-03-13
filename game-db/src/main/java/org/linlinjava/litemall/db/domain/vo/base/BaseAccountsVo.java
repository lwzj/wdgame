package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Accounts;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseAccountsVo {
	public Integer id;
public String name;
public String keyword;
public String password;
public String token;
public Integer chongzhijifen;
public Integer chongzhiyuanbao;
public String yaoqingma;
public Integer block;
public String code;

	
	public BaseAccountsVo(){

	}
	
	public BaseAccountsVo(Accounts vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
keyword= vo.getKeyword();
password= vo.getPassword();
token= vo.getToken();
chongzhijifen= vo.getChongzhijifen();
chongzhiyuanbao= vo.getChongzhiyuanbao();
yaoqingma= vo.getYaoqingma();
block= vo.getBlock();
code= vo.getCode();

	}
	
	public static final BaseAccountsVo t(Accounts vo){
		return new BaseAccountsVo(vo);
	}
	
	public static final List<BaseAccountsVo> t(List<Accounts> list){
		List<BaseAccountsVo> listVo = new ArrayList<>();
		for (Accounts temp : list) {
			listVo.add(new BaseAccountsVo(temp));
		}
		return listVo;
	}

}