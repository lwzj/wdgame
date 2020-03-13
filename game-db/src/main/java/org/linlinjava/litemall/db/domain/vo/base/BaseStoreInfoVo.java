package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.StoreInfo;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseStoreInfoVo {
	public Integer id;
public String quality;
public Integer value;
public Integer type;
public String name;
public Integer totalScore;
public Integer recognizeRecognized;
public Integer rebuildLevel;
public Integer silverCoin;

	
	public BaseStoreInfoVo(){

	}
	
	public BaseStoreInfoVo(StoreInfo vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
quality= vo.getQuality();
value= vo.getValue();
type= vo.getType();
name= vo.getName();
totalScore= vo.getTotalScore();
recognizeRecognized= vo.getRecognizeRecognized();
rebuildLevel= vo.getRebuildLevel();
silverCoin= vo.getSilverCoin();

	}
	
	public static final BaseStoreInfoVo t(StoreInfo vo){
		return new BaseStoreInfoVo(vo);
	}
	
	public static final List<BaseStoreInfoVo> t(List<StoreInfo> list){
		List<BaseStoreInfoVo> listVo = new ArrayList<>();
		for (StoreInfo temp : list) {
			listVo.add(new BaseStoreInfoVo(temp));
		}
		return listVo;
	}

}