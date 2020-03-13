package org.linlinjava.litemall.gameserver.data.game;

import org.linlinjava.litemall.gameserver.domain.Chara;
import org.linlinjava.litemall.gameserver.domain.PetShuXing;

/**
 * 人物基础属性
 * 气血	法力	物伤	法伤	速度	防御 计算
 */
public class BasicAttributesUtils {


    /**
     * 整体伤害
     *
     * @param attrib       人物等级
     * @param constitution 所有体质（人物拥有的，不含未加点）
     * @param mag_power    所有灵力
     * @param phy_power    所有力量
     * @param speed        所有敏捷
     * @param wood         金相性  （人物拥有的，不含未加点）
     * @param water        木相性
     * @param fire         水相性
     * @param earth        火相性
     * @param resist_metal 土相性
     * @return int[]  气血	 法力 物伤  法伤	速度	 防御
     */

    public static int[] calculationAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed
            , int wood, int water, int fire, int earth, int resist_metal) {
        //气血	法力	 物伤  法伤	速度	防御
        int[] attributes = {100, 80, 40, 40, 48, 20};


        /**物伤计算*******/
        //物伤  力量产生
        int accurate_phy_power = phy_power * 5 + 40;
        //物伤  土相产生
        int accurate_resist_metal = (int) (phy_power * 0.45 * resist_metal);
        //所有物伤
        int accurate_all = accurate_phy_power + accurate_resist_metal;
        /**end *******/


        /**法伤计算*******/
        //法伤  灵力产生
        int mana_mag_power = mag_power * 5 + 40;
        //物伤  土相产生
        int mana_wood = (int) (mag_power * 0.16 * wood);
        //所有物伤
        int mana_all = mana_mag_power + mana_wood;
        /**end *******/


        /**防御计算*******/
        //防御  体质产生
        int wiz_constitution = constitution * 5 + 20;
        //防御  水相产生
        int wiz_fire = (int) (constitution * 0.25 * fire);
        //所有防御
        int wiz_all = wiz_constitution + wiz_fire;
        /**end *******/


        /**速度计算*******/
        //速度  敏捷产生
        int parry_speed = speed * 2 + 48;
        //速度  火相产生
        int parry_earth = (int) (speed * 0.023 * earth);
        //所有速度
        int parry_all = parry_speed + parry_earth;
        /**end *******/


        /**法力计算*******/
        //不同等级每一点灵力对应的气血
        int dex_constitution_per = (int) ((attrib - 2) * 0.3 + 4);
        //法力   灵力产生
        int dex_constitution = dex_constitution_per * mag_power;
        //法力   等级产生  分别对应1 10 20  30  40 50  60  70  80  90 100 110 120  130 的血气
        int[] dex_attribs = {80, 239, 452, 699, 983, 1303, 1658, 2049, 2476, 2939, 3337, 3861, 4421, 5018};
        int dex_attrib = dex_attribs[0];
        if (attrib >= 130) {//如果大于130级
            dex_attrib = dex_attribs[13] + 60 * (attrib - 130);
        } else if (attrib <= 1) {
            //默认取80
        } else {
            int index = attrib / 10;
            dex_attrib = dex_attribs[index] + (dex_attribs[index + 1] - dex_attribs[index]) / 10 * (attrib % 10);
        }
        //法力  木相产生
        int dex_water = (int) (mag_power * 0.657 * water);
        //所有气血
        int dex_all = dex_constitution + dex_attrib + dex_water;
        /**end *******/


        /**气血计算*******/
        //不同等级每一点体质对应的气血
        int def_constitution_per = (int) ((attrib - 2) * 0.3 + 5);
        //气血   体质产生
        int def_constitution = def_constitution_per * constitution;
        //气血   等级产生  分别对应1 10 20  30  40 50  60  70  80  90 100 110 120  130 的血气
        int[] def_attribs = {100, 359, 727, 1177, 1712, 2281, 2971, 3746, 4604, 5546, 6571, 7569, 8751, 10016};
        int def_attrib = def_attribs[0];
        if (attrib >= 130) {//如果大于130级
            def_attrib = def_attribs[13] + 127 * (attrib - 130);
        } else if (attrib <= 1) {
            //默认取100
        } else {
            int index = attrib / 10;
            def_attrib = def_attribs[index] + (def_attribs[index + 1] - def_attribs[index]) / 10 * (attrib % 10);
        }
        //气血  木相产生
        int def_water = (int) (constitution * 1.4 * water);
        //所有气血
        int def_all = def_constitution + def_attrib + def_water;
        /**end *******/


        //气血	法力	 物伤  法伤	速度  	防御
        attributes[0] = def_all;
        attributes[1] = dex_all;
        attributes[2] = accurate_all;
        attributes[3] = mana_all;
        attributes[2] = accurate_all * 2;
        attributes[3] = mana_all * 2;
        attributes[4] = parry_all;
        attributes[5] = wiz_all*6/5;


        return attributes;


    }

    public static void petshuxing(PetShuXing petShuXing) {
        boolean fagong = petShuXing.rank > petShuXing.pet_mag_shape;
        int[] attributes = PetAttributesUtils.petAttributes(fagong, petShuXing.skill, petShuXing.life, petShuXing.mag_power, petShuXing.phy_power, petShuXing.speed, petShuXing.pet_mana_shape, petShuXing.pet_speed_shape, petShuXing.pet_phy_shape, petShuXing.pet_mag_shape, petShuXing.rank);
        petShuXing.def = attributes[0];
        petShuXing.dex = attributes[1];
        if (petShuXing.max_life >= petShuXing.def) {
            petShuXing.max_life = petShuXing.def;
        }
        if (petShuXing.max_mana >= petShuXing.dex) {
            petShuXing.max_mana = petShuXing.dex;
        }
        petShuXing.accurate = attributes[2];
        petShuXing.mana = attributes[3];
        petShuXing.parry = attributes[4];
        petShuXing.wiz = attributes[5];
    }

    public static void shuxing(Chara chara) {
        int[] attributes = calculationAttributes(chara.level, chara.life + chara.zbAttribute.life, chara.mag_power + chara.zbAttribute.mag_power, chara.phy_power + chara.zbAttribute.phy_power, chara.speed + chara.zbAttribute.speed
                , chara.wood + chara.zbAttribute.wood, chara.water + chara.zbAttribute.water, chara.fire + chara.zbAttribute.fire, chara.earth + chara.zbAttribute.earth, chara.resist_metal + chara.zbAttribute.resist_metal);
        chara.def = attributes[0];
        chara.dex = attributes[1];
        if (chara.max_life > chara.def) {
            chara.max_life = chara.def + chara.zbAttribute.def;
        }
        if (chara.max_mana > chara.dex) {
            chara.max_mana = chara.dex + chara.zbAttribute.dex;
        }
        chara.accurate = attributes[2];
        chara.mana = attributes[3];
        chara.parry = attributes[4];
        chara.wiz = attributes[5];
    }


    /**
     * 加属性点使用  属性变化
     *
     * @param attrib       人物等级
     * @param constitution 所有体质（人物拥有的，不含未加点）
     * @param mag_power    所有灵力
     * @param phy_power    所有力量
     * @param speed        所有敏捷
     * @return int[]  气血	 法力 物伤  法伤	速度	 防御
     */

    public static int[] changeCalculationAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed) {
        //气血	法力	 物伤  法伤	速度	防御


        /**物伤计算*******/
        //物伤  力量产生
        int accurate_all = phy_power * 5;
        /**end *******/


        /**法伤计算*******/
        //法伤  灵力产生
        int mana_all = mag_power * 5;
        /**end *******/


        /**防御计算*******/
        //防御  体质产生
        int wiz_all = constitution * 5;
        /**end *******/


        /**速度计算*******/
        //速度  敏捷产生
        int parry_all = speed * 2;
        /**end *******/


        /**法力计算*******/
        //不同等级每一点灵力对应的气血
        int dex_constitution_per = (int) ((attrib - 2) * 0.3 + 4);
        //法力   灵力产生
        int dex_all = dex_constitution_per * mag_power;
        /**end *******/


        /**气血计算*******/
        //不同等级每一点体质对应的气血
        int def_constitution_per = (int) ((attrib - 2) * 0.3 + 5);
        //气血   体质产生
        int def_all = def_constitution_per * constitution;
        /**end *******/


        int[] attributes = {0, 0, 0, 0, 0, 0};

        //气血	法力	 物伤  法伤	速度  	防御
        attributes[0] = def_all;
        attributes[1] = dex_all;
        attributes[2] = accurate_all;
        attributes[3] = mana_all;
        attributes[4] = parry_all;
        attributes[5] = wiz_all;


        return attributes;


    }


    /**
     * 加相性点使用  属性变化
     *
     * @param attrib       人物等级
     * @param constitution 所有体质（人物拥有的，不含未加点）
     * @param mag_power    所有灵力
     * @param phy_power    所有力量
     * @param speed        所有敏捷
     * @param wood         金相性  （人物拥有的，不含未加点）
     * @param water        木相性
     * @param fire         水相性
     * @param earth        火相性
     * @param resist_metal 土相性l
     * @return int[]  气血	 法力 物伤  法伤	速度	 防御
     */

    public static int[] changeRelAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed
            , int wood, int water, int fire, int earth, int resist_metal) {
        //气血	法力	 物伤  法伤	速度	防御


        /**物伤计算*******/
        //物伤  土相产生
        int accurate_all = (int) (phy_power * 0.45 * resist_metal);
        /**end *******/


        /**法伤计算*******/
        //物伤  土相产生
        int mana_all = (int) (mag_power * 0.16 * wood);
        /**end *******/


        /**防御计算*******/
        //防御  水相产生
        int wiz_all = (int) (constitution * 0.25 * fire);
        /**end *******/


        /**速度计算*******/
        //速度  火相产生
        int parry_all = (int) (speed * 0.023 * earth);
        /**end *******/


        /**法力计算*******/

        //法力  木相产生
        int dex_all = (int) (mag_power * 0.657 * water);
        /**end *******/


        /**气血计算*******/
        //气血  木相产生
        int def_all = (int) (constitution * 1.4 * water);
        /**end *******/

        int[] attributes = {0, 0, 0, 0, 0, 0};


        //气血	法力	 物伤  法伤	速度  	防御
        attributes[0] = def_all;
        attributes[1] = dex_all;
        attributes[2] = accurate_all;
        attributes[3] = mana_all;
        attributes[4] = parry_all;
        attributes[5] = wiz_all;


        return attributes;


    }


    public static int[] calculationHelpAttributes(int attrib, int constitution, int mag_power, int phy_power, int speed
            , int wood, int water, int fire, int earth, int resist_metal, int polar) {
        //气血	法力	 物伤  法伤	速度	防御
        int[] attributes = {100, 80, 40, 40, 48, 20};


        /**物伤计算*******/
        //物伤  力量产生
        int accurate_phy_power = phy_power * 5 + 40;
        //物伤  土相产生
        int accurate_resist_metal = (int) (phy_power * 0.45 * resist_metal);
        //所有物伤
        int accurate_all = accurate_phy_power + accurate_resist_metal;
        /**end *******/


        /**法伤计算*******/
        //法伤  灵力产生
        int mana_mag_power = mag_power * 5 + 40;
        //物伤  土相产生
        int mana_wood = (int) (mag_power * 0.16 * wood);
        //所有物伤
        int mana_all = mana_mag_power + mana_wood;
        /**end *******/


        /**防御计算*******/
        //防御  体质产生
        int wiz_constitution = constitution * 5 + 20;
        //防御  水相产生
        int wiz_fire = (int) (constitution * 0.25 * fire);
        //所有防御
        int wiz_all = wiz_constitution + wiz_fire;
        /**end *******/


        /**速度计算*******/
        //速度  敏捷产生
        int parry_speed = speed * 2 + 48;
        //速度  火相产生
        int parry_earth = (int) (speed * 0.023 * earth);
        //所有速度
        int parry_all = parry_speed + parry_earth;
        /**end *******/


        /**法力计算*******/
        //不同等级每一点灵力对应的气血
        int dex_constitution_per = (int) ((attrib - 2) * 0.3 + 4);
        //法力   灵力产生
        int dex_constitution = dex_constitution_per * mag_power;
        //法力   等级产生  分别对应1 10 20  30  40 50  60  70  80  90 100 110 120  130 的血气
        int[] dex_attribs = {80, 239, 452, 699, 983, 1303, 1658, 2049, 2476, 2939, 3337, 3861, 4421, 5018};
        int dex_attrib = dex_attribs[0];
        if (attrib >= 130) {//如果大于130级
            dex_attrib = dex_attribs[13] + 60 * (attrib - 130);
        } else if (attrib <= 1) {
            //默认取80
        } else {
            int index = attrib / 10;
            dex_attrib = dex_attribs[index] + (dex_attribs[index + 1] - dex_attribs[index]) / 10 * (attrib % 10);
        }
        //法力  木相产生
        int dex_water = (int) (mag_power * 0.657 * water);
        //所有气血
        int dex_all = dex_constitution + dex_attrib + dex_water;
        /**end *******/


        /**气血计算*******/
        //不同等级每一点体质对应的气血
        int def_constitution_per = (int) ((attrib - 2) * 0.3 + 5);
        //气血   体质产生
        int def_constitution = def_constitution_per * constitution;
        //气血   等级产生  分别对应1 10 20  30  40 50  60  70  80  90 100 110 120  130 的血气
        int[] def_attribs = {100, 359, 727, 1177, 1712, 2281, 2971, 3746, 4604, 5546, 6571, 7569, 8751, 10016};
        int def_attrib = def_attribs[0];
        if (attrib >= 130) {//如果大于130级
            def_attrib = def_attribs[13] + 127 * (attrib - 130);
        } else if (attrib <= 1) {
            //默认取100
        } else {
            int index = attrib / 10;
            def_attrib = def_attribs[index] + (def_attribs[index + 1] - def_attribs[index]) / 10 * (attrib % 10);
        }
        //气血  木相产生
        int def_water = (int) (constitution * 1.4 * water);
        //所有气血
        int def_all = def_constitution + def_attrib + def_water;
        /**end *******/


        double[][] hs = {{2, 8, 4, 2, 10}, {1.3, 8, 9, 2, 2.6}, {1.3, 6, 3, 2, 3}, {2, 1.7, 7, 2, 6.3}, {1.5, 2.1, 13, 2, 7}};


        //气血	法力	 物伤  法伤	速度  	防御
        attributes[0] = (int) (def_all * hs[polar - 1][0]);
        attributes[1] = (int) (dex_all * hs[polar - 1][0]);
        attributes[2] = (int) (accurate_all * hs[polar - 1][1]);
        attributes[3] = (int) (mana_all * hs[polar - 1][2]);
        attributes[4] = (int) (parry_all * hs[polar - 1][3]);
        attributes[5] = (int) (wiz_all * hs[polar - 1][4]);


        return attributes;


    }

    /**
     * 等级  气血   法力
     * 1    105    84
     * 10   433    303     7    5
     * 20   934    639
     * 30   1579   1071
     * 40   2368   1599
     * 50   3250   2222    18   13
     * 60   4315   2942
     * 70   5524   3757
     * 80   6876   4668
     * 90   8372   5675
     * 100  10011  6677    33  22
     * 110  11683  7865
     * 120  13599  9149
     * 130  15658  10530
     */
}
