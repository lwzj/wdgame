package org.linlinjava.litemall.gameserver.domain;

import org.linlinjava.litemall.db.domain.StoreInfo;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class Goods {
    public int pos = 45;
    public GoodsInfo goodsInfo = new GoodsInfo();
    public GoodsBasics goodsBasics = new GoodsBasics();
    public GoodsLanSe goodsLanSe = new GoodsLanSe();
    public GoodsFenSe goodsFenSe = new GoodsFenSe();
    public GoodsHuangSe goodsHuangSe = new GoodsHuangSe();
    public GoodsLvSe goodsLvSe = new GoodsLvSe();
    public GoodsGaiZao goodsGaiZao = new GoodsGaiZao();
    public GoodsGaiZaoGongMing goodsGaiZaoGongMing = new GoodsGaiZaoGongMing();
    public GoodsGaiZaoGongMingChengGong goodsGaiZaoGongMingChengGong = new GoodsGaiZaoGongMingChengGong();
    public GoodsLvSeGongMing goodsLvSeGongMing = new GoodsLvSeGongMing();


    public void goodsDaoju(StoreInfo info) {
        if (info.getQuality() != null) {
            goodsInfo.quality = info.getQuality();
        }
        if (info.getSilverCoin() != null) {
            goodsInfo.silver_coin = info.getSilverCoin();
        }
        if (info.getName().equals("血玲珑")) {
            goodsBasics.max_life = 4000000;
            goodsInfo.phy_rebuild_level = "剩余血量：4,000,000";
        }
        if (info.getName().equals("法玲珑")) {
            goodsBasics.max_mana = 4000000;
            goodsInfo.phy_rebuild_level = "剩余法力：4,000,000";
        }
        if (info.getName().equals("中级血玲珑")) {
            goodsBasics.max_life = 10000000;
            goodsInfo.phy_rebuild_level = "剩余血量：10,000,000";
        }
        if (info.getName().equals("中级法玲珑")) {
            goodsBasics.max_mana = 10000000;
            goodsInfo.phy_rebuild_level = "剩余法力：10,000,000";
        }
        if (info.getName().equals("火眼金睛")) {
            goodsInfo.max_durability = 10;
        }
        goodsInfo.type = info.getType();
        goodsInfo.str = info.getName();
//        goodsInfo.recognize_recognized = info.getRecognizeRecognized();
        goodsInfo.recognize_recognized = 0;
        goodsInfo.auto_fight = UUID.randomUUID().toString();
        goodsInfo.total_score = info.getTotalScore();
        goodsInfo.rebuild_level = info.getRebuildLevel();
        goodsInfo.value = info.getValue();
        goodsInfo.degree_32 = 1;
    }

    public void goodsCreate(ZhuangbeiInfo info) {
        goodsInfo.amount = info.getAmount();
        goodsInfo.auto_fight = UUID.randomUUID().toString();
        goodsInfo.master = info.getMaster();
        goodsInfo.type = info.getType();
        goodsInfo.str = info.getStr();
        goodsInfo.metal = info.getMetal();
        goodsInfo.quality = info.getQuality();
        goodsInfo.attrib = info.getAttrib();
        goodsInfo.total_score = 1;

        //装备出售的价格
        goodsInfo.rebuild_level = 1500;
        goodsInfo.recognize_recognized = 1;
        goodsInfo.damage_sel_rate = 1000;
        goodsInfo.owner_id = 1;
        goodsInfo.dunwu_times = 0;

        //套装属性激活0没有 1有
        goodsInfo.gift = 0;

        goodsInfo.nick = 0;
        goodsInfo.power = 0;
        goodsInfo.wrestlescore = 0;
        goodsInfo.skill = 0;
        goodsInfo.store_exp = 0;
        goodsInfo.suit_degree = 0;
        goodsInfo.party_stage_party_name = 0;

        goodsInfo.mailing_item_times = 0;
        goodsInfo.suit_enabled = 0;
        goodsInfo.degree_32 = 0;
        goodsInfo.value = 8388608;
        goodsInfo.color = 0;
        goodsBasics.accurate = info.getAccurate();
        goodsBasics.def = info.getDef();
        goodsBasics.dex = info.getDex();
        goodsBasics.mana = info.getMana();
        goodsBasics.parry = info.getParry();
        goodsBasics.wiz = info.getWiz();
    }





}
