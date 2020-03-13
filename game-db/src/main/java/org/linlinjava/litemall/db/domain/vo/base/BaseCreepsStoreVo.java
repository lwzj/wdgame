package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.CreepsStore;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseCreepsStoreVo {
	public Integer id;
public String name;
public Integer price;

	
	public BaseCreepsStoreVo(){

	}
	
	public BaseCreepsStoreVo(CreepsStore vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
price= vo.getPrice();

	}
	
	public static final BaseCreepsStoreVo t(CreepsStore vo){
		return new BaseCreepsStoreVo(vo);
	}
	
	public static final List<BaseCreepsStoreVo> t(List<CreepsStore> list){
		List<BaseCreepsStoreVo> listVo = new ArrayList<>();
		for (CreepsStore temp : list) {
			listVo.add(new BaseCreepsStoreVo(temp));
		}
		return listVo;
	}

}