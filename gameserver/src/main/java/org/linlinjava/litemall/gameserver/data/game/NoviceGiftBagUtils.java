package org.linlinjava.litemall.gameserver.data.game;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

/**
 * 新手礼包
 */
public class NoviceGiftBagUtils {

    /**
     * @param sex   1男 2女
     * @param metal 12345 金木水火土
     * @return
     */
    public static List<String[]> giftBag(int sex, int metal) {

        List<String[]> list = new LinkedList<>();
        list.add(giftBags(10, sex, metal));
        list.add(giftBags(20, sex, metal));
        list.add(giftBags(30, sex, metal));
        list.add(giftBags(40, sex, metal));
        list.add(giftBags(50, sex, metal));
        list.add(giftBags(60, sex, metal));
        list.add(giftBags(70, sex, metal));
        list.add(giftBags(80, sex, metal));
        return list;
    }


    /**
     * @param attrib
     * @param sex
     * @param metal
     * @return
     */
    public static String[] giftBags(int attrib, int sex, int metal) {

        if (attrib == 10) {
            String[] arms = {"铁枪", "虎爪", "青锋剑", "精铁扇", "流星锤"};
            String[] nv = {"飞凤钗", "绛紫裙"};//帽子 衣服
            String[] bag = {"虎爪#装备", "皮帽#装备", "布鞋#装备", "虎皮衣#装备", "驯兽诀#物品"};
            bag[0] = arms[metal - 1] + "#装备";

            if (sex == 2) {
                bag[1] = nv[0] + "#装备";
                bag[3] = nv[1] + "#装备";
            }
            return bag;
        }
        //赤炼爪
        if (attrib == 20) {
            String[] arms = {"点钢枪", "赤炼爪", "沉香剑", "逍遥扇", "八棱锤"};
            String[] nv = {"碧玉钗", "虹羽衣"};//帽子 衣服
            String[] bag = {"赤炼爪#装备", "青铜盔#装备", "马靴#装备", "青铜铠#装备", "纹龙佩#首饰", "青珑挂珠#首饰", "金刚手镯#首饰", "金刚手镯#首饰", "血玲珑#物品", "法玲珑#物品", "代金券#100000"};
            bag[0] = arms[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = nv[0] + "#装备";
                bag[3] = nv[1] + "#装备";
            }
            return bag;
        }
        if (attrib == 30) {
            String[] arms = {"乌金枪", "残青爪", "飞虹剑", "玉骨扇", "亮银锤"};
            String[] nv = {"蝴蝶钗", "凤暖袍"};//帽子 衣服
            String[] bag = {"残青爪#装备", "冲天盔#装备", "牛皮靴#装备", "皂罗袍#装备", "天神护佑#物品", "血池#物品", "灵池#物品", "火眼金睛#物品", "代金券#150000"};
            bag[0] = arms[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = nv[0] + "#装备";
                bag[3] = nv[1] + "#装备";
            }
            return bag;
        }
        if (attrib == 40) {
            String[] arms = {"火焰枪", "阴风爪", "乾元剑", "阴阳扇", "乌金锤"};
            String[] nv = {"金钗", "锦月袄"};//帽子 衣服
            String[] bag = {"阴风爪#装备", "虎头盔#装备", "长筒靴#装备", "金锁甲#装备", "天神护佑#物品", "代金券#200000"};
            bag[0] = arms[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = nv[0] + "#装备";
                bag[3] = nv[1] + "#装备";
            }
            return bag;
        }

        if (attrib == 50) {
            String[] arms = {"双头枪", "寒冰刺", "斩妖剑", "凤羽扇", "混元锤"};
            String[] nv = {"珍珠钗", "凝霜衣"};//帽子 衣服
            String[] bag = {"寒冰刺#装备", "神龙盔#装备", "追云履#装备", "莽龙袍#装备", "天神护佑#物品", "代金券#250000"};
            bag[0] = arms[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = nv[0] + "#装备";
                bag[3] = nv[1] + "#装备";
            }
            return bag;
        }

        if (attrib == 60) {
            String[] arms = {"寒风枪", "骷髅爪", "昆吾剑", "百花扇", "霹雳锤"};
            String[] nv = {"凤尾钗", "水合袍"};//帽子 衣服
            String[] bag = {"骷髅爪#装备", "白玉冠#装备", "亮银靴#装备", "金丝甲#装备", "天神护佑#物品", "代金券#300000"};
            bag[0] = arms[metal - 1] + "#装备";
            if (sex == 2) {
                bag[1] = nv[0] + "#装备";
                bag[3] = nv[1] + "#装备";
            }
            return bag;
        }

        if (attrib == 70) {
            String[] nv = {"鱼尾冠", "狐皮袄"};//帽子 衣服
            String[] bag = {"乾坤冠#装备", "疾风履#装备", "八卦衣#装备", "天神护佑#物品", "代金券#400000"};
            if (sex == 2) {
                bag[0] = nv[0] + "#装备";
                bag[2] = nv[1] + "#装备";
            }
            return bag;
        }

        if (attrib == 80) {
            String[] bag = {"超级绿水晶#物品", "超级女娲石#物品", "血池#物品", "灵池#物品", "代金券#600000"};
            return bag;
        }


        return null;
    }


    /**
     * 新手礼包里面的装备
     *
     * @param eqType    装备类型  武器1,头盔2,鞋子10,衣服3
     * @param eq_attrib
     * @return
     */
    public  static List<Hashtable<String, Integer>> equipmentGiftBags(int eqType, int eq_attrib) {

        List<Hashtable<String, Integer>> appraisalList = new ArrayList<>();
        int[] skill_low_cost = {60, 140, 240, 360, 500, 660, 660};
        int[] phy_power = {2, 3, 4, 6, 7, 9, 10};

        String[] arms = {"skill_low_cost", "phy_power", "mag_power"};
        String[] replaceAttributes = {"phy_power", "mag_power", "life"};
        if (eqType == 1) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 2);
            key_vlaue_tab.put("skill_low_cost", skill_low_cost[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("phy_power", phy_power[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("mag_power", phy_power[eq_attrib / 10 - 1]);
            appraisalList.add(key_vlaue_tab);
        } else {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 2);
            key_vlaue_tab.put("phy_power", phy_power[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("mag_power", phy_power[eq_attrib / 10 - 1]);
            key_vlaue_tab.put("life", phy_power[eq_attrib / 10 - 1]);
            appraisalList.add(key_vlaue_tab);
        }

        //改造
        String keyName1 = "wiz";
        String keyName2 = "wiz";
        if (eqType == 1) {
            keyName1 = "accurate";
            keyName2 = "mana";
        }

        if (eq_attrib == 10) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 141 : 48);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 141 : 48);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }

        if (eq_attrib == 20) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 267 : 93);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 267 : 93);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }


        if (eq_attrib == 30) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 417 : 147);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 417 : 147);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }


        if (eq_attrib == 40) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 396 : 140);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 396 : 140);
            key_vlaue_tab.put("changeNum", 2);
            appraisalList.add(key_vlaue_tab);
        }


        if (eq_attrib == 50 && eqType != 1) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, 282);
            key_vlaue_tab.put(keyName2, 282);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }


        if (eq_attrib == 60) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, eqType == 1 ? 1023 : 363);
            key_vlaue_tab.put(keyName2, eqType == 1 ? 1023 : 363);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }


        if (eq_attrib == 70 && eqType != 1) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 10);
            key_vlaue_tab.put(keyName1, 453);
            key_vlaue_tab.put(keyName2, 453);
            key_vlaue_tab.put("changeNum", 3);
            appraisalList.add(key_vlaue_tab);
        }


        //粉
        if (eq_attrib == 70 && eqType != 1) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 3);
            key_vlaue_tab.put("phy_power", 10);
            appraisalList.add(key_vlaue_tab);

        }

        // 黄
        if (eq_attrib == 70 && eqType != 1) {
            Hashtable<String, Integer> key_vlaue_tab = new Hashtable<>();
            key_vlaue_tab.put("groupNo", 4);
            key_vlaue_tab.put("mag_power", 10);
            appraisalList.add(key_vlaue_tab);

        }


        return appraisalList;


    }


}
