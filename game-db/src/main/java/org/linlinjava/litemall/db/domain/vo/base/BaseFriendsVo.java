package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Friends;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseFriendsVo {
	public Integer id;
public String pid;
public String hy1;

	
	public BaseFriendsVo(){

	}
	
	public BaseFriendsVo(Friends vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
pid= vo.getPid();
hy1= vo.getHy1();

	}
	
	public static final BaseFriendsVo t(Friends vo){
		return new BaseFriendsVo(vo);
	}
	
	public static final List<BaseFriendsVo> t(List<Friends> list){
		List<BaseFriendsVo> listVo = new ArrayList<>();
		for (Friends temp : list) {
			listVo.add(new BaseFriendsVo(temp));
		}
		return listVo;
	}

}