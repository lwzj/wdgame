package org.linlinjava.litemall.db.domain.vo.base;

import org.linlinjava.litemall.db.domain.Pets;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class BasePetsVo {
	public Integer id;
public String ownerid;
public String petid;
public String nickname;
public String name;
public Integer horsetype;
public Integer type;
public Integer level;
public Integer liliang;
public Integer minjie;
public Integer lingli;
public Integer tili;
public Integer dianhualx;
public Integer dianhuazd;
public Integer dianhuazx;
public Integer yuhualx;
public Integer yuhuazd;
public Integer yuhuazx;
public Integer cwjyzx;
public Integer cwjyzd;
public Integer feisheng;
public Integer fsudu;
public Integer qhcwWg;
public Integer qhcwFg;
public Integer cwXiangxing;
public Integer cwWuxue;
public String cwIcon;
public Integer cwXinfa;
public Integer cwQinmi;

	
	public BasePetsVo(){

	}
	
	public BasePetsVo(Pets vo){
		if(vo==null){
			return;
		}
		id= vo.getId();
ownerid= vo.getOwnerid();
petid= vo.getPetid();
nickname= vo.getNickname();
name= vo.getName();
horsetype= vo.getHorsetype();
type= vo.getType();
level= vo.getLevel();
liliang= vo.getLiliang();
minjie= vo.getMinjie();
lingli= vo.getLingli();
tili= vo.getTili();
dianhualx= vo.getDianhualx();
dianhuazd= vo.getDianhuazd();
dianhuazx= vo.getDianhuazx();
yuhualx= vo.getYuhualx();
yuhuazd= vo.getYuhuazd();
yuhuazx= vo.getYuhuazx();
cwjyzx= vo.getCwjyzx();
cwjyzd= vo.getCwjyzd();
feisheng= vo.getFeisheng();
fsudu= vo.getFsudu();
qhcwWg= vo.getQhcwWg();
qhcwFg= vo.getQhcwFg();
cwXiangxing= vo.getCwXiangxing();
cwWuxue= vo.getCwWuxue();
cwIcon= vo.getCwIcon();
cwXinfa= vo.getCwXinfa();
cwQinmi= vo.getCwQinmi();

	}
	
	public static final BasePetsVo t(Pets vo){
		return new BasePetsVo(vo);
	}
	
	public static final List<BasePetsVo> t(List<Pets> list){
		List<BasePetsVo> listVo = new ArrayList<>();
		for (Pets temp : list) {
			listVo.add(new BasePetsVo(temp));
		}
		return listVo;
	}

}