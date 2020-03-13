package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.StoreGoods;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BaseStoreGoodsVo {
	public Integer id;
public String name;
public String barcode;
public Integer forSale;
public Integer showPos;
public Integer rpos;
public Integer saleQuota;
public Integer recommend;
public Integer coin;
public Integer discount;
public Integer type;
public Integer quotaLimit;
public Integer mustVip;
public Integer isGift;
public Integer followPetType;

	
	public BaseStoreGoodsVo(){

	}
	
	public BaseStoreGoodsVo(StoreGoods vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
name= vo.getName();
barcode= vo.getBarcode();
forSale= vo.getForSale();
showPos= vo.getShowPos();
rpos= vo.getRpos();
saleQuota= vo.getSaleQuota();
recommend= vo.getRecommend();
coin= vo.getCoin();
discount= vo.getDiscount();
type= vo.getType();
quotaLimit= vo.getQuotaLimit();
mustVip= vo.getMustVip();
isGift= vo.getIsGift();
followPetType= vo.getFollowPetType();

	}
	
	public static final BaseStoreGoodsVo t(StoreGoods vo){
		return new BaseStoreGoodsVo(vo);
	}
	
	public static final List<BaseStoreGoodsVo> t(List<StoreGoods> list){
		List<BaseStoreGoodsVo> listVo = new ArrayList<>();
		for (StoreGoods temp : list) {
			listVo.add(new BaseStoreGoodsVo(temp));
		}
		return listVo;
	}

}