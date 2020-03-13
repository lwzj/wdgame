package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Reports;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseReportsVo {
	public Integer id;
public String zhanghao;
public Integer yuanbaoshu;
public String shifouchongzhi;

	
	public BaseReportsVo(){

	}
	
	public BaseReportsVo(Reports vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
zhanghao= vo.getZhanghao();
yuanbaoshu= vo.getYuanbaoshu();
shifouchongzhi= vo.getShifouchongzhi();

	}
	
	public static final BaseReportsVo t(Reports vo){
		return new BaseReportsVo(vo);
	}
	
	public static final List<BaseReportsVo> t(List<Reports> list){
		List<BaseReportsVo> listVo = new ArrayList<>();
		for (Reports temp : list) {
			listVo.add(new BaseReportsVo(temp));
		}
		return listVo;
	}

}