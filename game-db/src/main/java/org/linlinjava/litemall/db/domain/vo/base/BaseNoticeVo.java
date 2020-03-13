package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Notice;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseNoticeVo {
	public Integer id;
public String message;
public Integer time;

	
	public BaseNoticeVo(){

	}
	
	public BaseNoticeVo(Notice vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
message= vo.getMessage();
time= vo.getTime();

	}
	
	public static final BaseNoticeVo t(Notice vo){
		return new BaseNoticeVo(vo);
	}
	
	public static final List<BaseNoticeVo> t(List<Notice> list){
		List<BaseNoticeVo> listVo = new ArrayList<>();
		for (Notice temp : list) {
			listVo.add(new BaseNoticeVo(temp));
		}
		return listVo;
	}

}