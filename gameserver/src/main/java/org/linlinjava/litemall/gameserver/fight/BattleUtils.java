package org.linlinjava.litemall.gameserver.fight;


import org.linlinjava.litemall.gameserver.fight.FightManager;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BattleUtils {


    /**
     * 战斗站位   和怪物对战
     *
     * @param list     我方人物 hs.put("person","人物id")   hs.put("pet","宠物id") 一组
     * @param monsters 怪物的id
     * @return [2]Tab     [0]我方  [1]敌方
     */
    public static Hashtable<String, Integer>[] battlePosition(List<Hashtable<String, String>> list, List<String> monsters) {
        //我方位置
        //前排 从上到下  6 7 8 9 10
        //后排 从上到下  1 2 3 4 5   队列
        ConcurrentLinkedQueue<Integer> mineQueueFront = new ConcurrentLinkedQueue<>();//前
        mineQueueFront.offer(3);
        mineQueueFront.offer(2);
        mineQueueFront.offer(4);
        mineQueueFront.offer(1);
        mineQueueFront.offer(5);
        ConcurrentLinkedQueue<Integer> mineQueueBehind = new ConcurrentLinkedQueue<>();//后
        mineQueueBehind.offer(8);
        mineQueueBehind.offer(7);
        mineQueueBehind.offer(9);
        mineQueueBehind.offer(6);
        mineQueueBehind.offer(10);
        //敌放位置
        //前排 从上到下 10 9  8  7  6
        //后排 从上到下 5  4  3  2  1

        ConcurrentLinkedQueue<Integer> monsterQueueFront = new ConcurrentLinkedQueue<>();//前
        monsterQueueFront.offer(8);
        monsterQueueFront.offer(7);
        monsterQueueFront.offer(9);
        monsterQueueFront.offer(6);
        monsterQueueFront.offer(10);
        ConcurrentLinkedQueue<Integer> monsterQueueBehind = new ConcurrentLinkedQueue<>();//后
        monsterQueueBehind.offer(3);
        monsterQueueBehind.offer(2);
        monsterQueueBehind.offer(4);
        monsterQueueBehind.offer(1);
        monsterQueueBehind.offer(5);


        Hashtable<String, Integer> minePositionTab = new Hashtable<>();

        if (!list.isEmpty()) {
            for (Hashtable<String, String> hs : list) {
                String personValue = hs.get("person");
                String petValue = hs.get("pet");
                minePositionTab.put(personValue, mineQueueBehind.poll());
                int petPosition = mineQueueFront.poll();
                if (null != petValue && !petValue.isEmpty()) {
                    minePositionTab.put(petValue, petPosition);
                }
            }
        }


        Hashtable<String, Integer> monsterPositionTab = new Hashtable<>();

        if (!monsters.isEmpty()) {
            for (String monster : monsters) {
                if (monsterQueueBehind.isEmpty()) {
                    monsterPositionTab.put(monster, monsterQueueFront.poll());
                } else {
                    monsterPositionTab.put(monster, monsterQueueBehind.poll());
                }
            }
        }


        Hashtable<String, Integer>[] hashtables = new Hashtable[2];
        hashtables[0] = minePositionTab;
        hashtables[1] = monsterPositionTab;


        return hashtables;

    }


    /**
     * 战斗站位   和人物pk
     *
     * @param list        我方人物 hs.put("person","人物id")   hs.put("pet","宠物id") 一组
     * @param monsterList 敌方
     * @return [2]Tab     [0]我方  [1]敌方
     */
    public static Hashtable<String, Integer>[] battlePkPosition(List<Hashtable<String, String>> list, List<Hashtable<String, String>> monsterList) {
        //我方位置
        //前排 从上到下  6 7 8 9 10
        //后排 从上到下  1 2 3 4 5   队列
        ConcurrentLinkedQueue<Integer> mineQueueFront = new ConcurrentLinkedQueue<>();//前
        mineQueueFront.offer(3);
        mineQueueFront.offer(2);
        mineQueueFront.offer(4);
        mineQueueFront.offer(1);
        mineQueueFront.offer(5);
        ConcurrentLinkedQueue<Integer> mineQueueBehind = new ConcurrentLinkedQueue<>();//后
        mineQueueBehind.offer(8);
        mineQueueBehind.offer(7);
        mineQueueBehind.offer(9);
        mineQueueBehind.offer(6);
        mineQueueBehind.offer(10);
        //敌放位置
        //前排 从上到下 10 9  8  7  6
        //后排 从上到下 5  4  3  2  1

        ConcurrentLinkedQueue<Integer> monsterQueueFront = new ConcurrentLinkedQueue<>();//前
        monsterQueueFront.offer(8);
        monsterQueueFront.offer(7);
        monsterQueueFront.offer(9);
        monsterQueueFront.offer(6);
        monsterQueueFront.offer(10);
        ConcurrentLinkedQueue<Integer> monsterQueueBehind = new ConcurrentLinkedQueue<>();//后
        monsterQueueBehind.offer(3);
        monsterQueueBehind.offer(2);
        monsterQueueBehind.offer(4);
        monsterQueueBehind.offer(1);
        monsterQueueBehind.offer(5);


        Hashtable<String, Integer> minePositionTab = new Hashtable<>();

        if (!list.isEmpty()) {
            for (Hashtable<String, String> hs : list) {
                String personValue = hs.get("person");
                String petValue = hs.get("pet");
                minePositionTab.put(personValue, mineQueueBehind.poll());
                int petPosition = mineQueueFront.poll();
                if (null != petValue && !petValue.isEmpty()) {
                    minePositionTab.put(petValue, petPosition);
                }
            }
        }


        Hashtable<String, Integer> monsterPositionTab = new Hashtable<>();

        if (!monsterList.isEmpty()) {
            for (Hashtable<String, String> hs : monsterList) {
                String personValue = hs.get("person");
                String petValue = hs.get("pet");
                monsterPositionTab.put(personValue, monsterQueueBehind.poll());
                int petPosition = monsterQueueFront.poll();
                if (null != petValue && !petValue.isEmpty()) {
                    monsterPositionTab.put(petValue, petPosition);
                }
            }
        }


        Hashtable<String, Integer>[] hashtables = new Hashtable[2];
        hashtables[0] = minePositionTab;
        hashtables[1] = monsterPositionTab;


        return hashtables;

    }


    public static void main(String[] args) {

        //第一个是队长或者 没有队伍的时候自己
        Hashtable<String, String> mineTab1 = new Hashtable<>();
        mineTab1.put("person", "我");
        mineTab1.put("pet", "我对宠物");


        //人物放一起
        Hashtable<String, String> mineTab5 = new Hashtable<>();
        mineTab5.put("person", "队友5");
        mineTab5.put("pet", "队友5的宠物");


        Hashtable<String, String> mineTab2 = new Hashtable<>();
        mineTab2.put("person", "守护1");


        Hashtable<String, String> mineTab3 = new Hashtable<>();
        mineTab3.put("person", "守护2");


        Hashtable<String, String> mineTab4 = new Hashtable<>();
        mineTab4.put("person", "守护4");

        List<Hashtable<String, String>> list = new ArrayList<>();
        list.add(mineTab1);
        list.add(mineTab5);
        list.add(mineTab2);
        list.add(mineTab3);
        list.add(mineTab4);


        List<String> mlist = new ArrayList<>();
        mlist.add("怪物1");
        mlist.add("怪物2");
        mlist.add("怪物3");
        mlist.add("怪物4");
        mlist.add("怪物5");
        mlist.add("怪物6");
        mlist.add("怪物7");
        mlist.add("怪物8");
        mlist.add("怪物9");
        mlist.add("怪物10");
        Hashtable<String, Integer>[] hashtables = battlePosition(list, mlist);
//        System.out.println(hashtables[0]);
//        System.out.println(hashtables[1]);


//        System.out.println(battle(295, 1595));
//        System.out.println(battle(616, 1595));

    }


    public static int produceRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min; //[min,max]
    }

    /**
     * 野怪跑图 巡逻 挂物个数
     *
     * @param attrib        队长等级或者是无队伍我的等级
     * @param teamMember    我方参战个数
     * @param monsterAttrib 怪物最高等级
     * @return
     */
    public static int monsterCount(int attrib, int teamMember, int monsterAttrib) {

        if (monsterAttrib <= 15 || attrib < 10) {
            return produceRandomNumber(1, 2);
        }
        if (monsterAttrib <= 35 || attrib < 25) {
            return produceRandomNumber(2, 3);
        }
        if (monsterAttrib <= 50 || attrib < 35) {
            return produceRandomNumber(3, 5);
        }
        return produceRandomNumber(teamMember, teamMember + 3 < 10 ? teamMember + 3 : 10);
    }

    /**
     * @param baseAttack     基础伤害  物伤 法伤
     * @param monsterDefense 怪物的防御
     */
    public static int battle(int baseAttack, int skillAttack, int monsterDefense) {
        //A  物伤120  防御125  A->B  120   119
        //B  物伤141  防御45   B->A  102   98

        //A  物伤5845  防御476  A->B  8160   7922  76级空号
        //B  物伤500  防御440   B->A  361   380    84级空号
        //C  物伤616  防御70    C->A  468          10级带武器

        //D  物伤295  防御70    D->A  71          10级空号
        //295  1595 3
        //616  1595 4
        //1-10级
        //AB 物伤45   防御52   22  24
        //AB 物伤102  防御57   91 95 96
        //AB 物伤126  防御62   118 122
        //AB 物伤148  防御67   150 144
        //AB 物伤178  防御72   170 172
        //AB 物伤202  防御77   206
        //AB 物伤237  防御82   252 255
        //AB 物伤263  防御87   266
        //AB 物伤304  防御92   313
        //AB 物伤332  防御97   351


        double y = 1.483748645720477;
        double x = 1.880943782352233;

        double jp = monsterDefense * 1.0 / (baseAttack + skillAttack + monsterDefense);
        int hurt = (int) ((baseAttack + skillAttack) * (1 - jp * jp) * 0.8785);
        int fudong = hurt / 10;
        if (fudong != 0) {
            int rfudong = FightManager.RANDOM.nextInt(fudong);
            hurt = hurt + rfudong - fudong / 2;
        }
        return hurt;

    }

    /**
     * 主技能伤害
     *
     * @param baseAttack 基础伤害  物伤 法伤
     * @param skillLeave
     * @param skillType  "skillType": "WS",
     * @return
     */
    public static int skillAttack(int baseAttack, int skillLeave, String skillType, int skillPara) {
        if (skillType.contentEquals("WS")) {
            return (int) (0.001138120610055 * skillLeave * baseAttack);
        }
        int skillIndex = getSkillIndex(skillPara);
        double[] fs = {0, 0.000798084596967, 0.002394253790902, 0.010375099760575, 0.004788507581804};
        if (skillType.contentEquals("FS")) {
            return (int) (fs[skillIndex] * skillLeave * baseAttack * 0.8);
        }
        return 0;
    }

    //辅助技能添加的数值
    public static double extAdd(int skillLeave, int skillPara) {
        int skillIndex = getSkillIndex(skillPara);
        int[] base_pro = {10, 17, 25, 50, 40};
        double append = skillLeave / 208 * 0.3;
        return base_pro[skillIndex] * (1 + append);

    }

    public static final List<Integer> SKILL_INDEX_LIST = new ArrayList<>();
    public static final List<Integer> SKILL_PERCENT_POINT_LIST = new ArrayList<>();

    public static void init() {
        SKILL_INDEX_LIST.add(11);
        SKILL_INDEX_LIST.add(21);
        SKILL_INDEX_LIST.add(31);
        SKILL_INDEX_LIST.add(61);
        SKILL_INDEX_LIST.add(71);
        SKILL_INDEX_LIST.add(81);
        SKILL_INDEX_LIST.add(110);
        SKILL_INDEX_LIST.add(121);
        SKILL_INDEX_LIST.add(131);
        SKILL_INDEX_LIST.add(161);
        SKILL_INDEX_LIST.add(171);
        SKILL_INDEX_LIST.add(181);
        SKILL_INDEX_LIST.add(210);
        SKILL_INDEX_LIST.add(221);
        SKILL_INDEX_LIST.add(231);
        Collections.reverse(SKILL_INDEX_LIST);

        SKILL_PERCENT_POINT_LIST.add(15);
        SKILL_PERCENT_POINT_LIST.add(20);
        SKILL_PERCENT_POINT_LIST.add(30);
        SKILL_PERCENT_POINT_LIST.add(65);
        SKILL_PERCENT_POINT_LIST.add(50);

    }

    public static int getSkillIndex(int para) {
        for (Integer index : SKILL_INDEX_LIST) {
            if (index <= para) {
                return para - index;
            }
        }
        return 0;
    }
}
