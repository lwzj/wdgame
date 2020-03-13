package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.data.vo.Vo_12028_0;
import org.linlinjava.litemall.gameserver.data.write.M12028_0;
import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.List;

public abstract class FightFabaoSkill implements FightSkill {
    protected FightObject buffObject = null;
    protected FightContainer fightContainer;
    public int level;
    public int qinmi;
    /**
     * 番天印    法术连击
     * 定海珠   （法宝等级+3)/4  次数免疫伤害  木系障碍无法免疫
     * 混元金斗   物攻  A+力+2.5倍
     * 阴阳镜    如果自己是主目标收到伤害转到队友或者敌对方  （法宝等级+3)/4 次数
     * 金蛟剪    回合结束若佩戴者存活，清除对方3个目标的辅助。如果多把金蛟剪 只生效一次把  （不做）
     * 九龙神火罩 触发100%  只管效果不管作用
     * 卸甲金葫  打别人打时候触发了，别人法宝效果不能出现。（定海珠，阴阳镜）
     */

    /**
     * 法宝技能触发概率N
     * <p>
     * //     * @param attrib   1-24级
     * //     * @param intimacy 亲密度
     *
     * @return
     */
    public void active() {
//        times = 0;
//        /**
//         * 0~10000 加成比例为2%
//         * 10001~100000 加成比例为3%
//         * 100001~500000 加成比例为5%
//         * 500000以上 加成比例为8%
//         */
//        int append_intimacy = 0;
//        if (qinmi < 10000) {
//            append_intimacy = 2;
//        } else if (qinmi < 100000) {
//            append_intimacy = 3;
//        } else if (qinmi < 500000) {
//            append_intimacy = 5;
//        } else {
//            append_intimacy = 8;
//        }
//
//        int[] probabilitys = {0, 1, 2, 3, 5, 7, 10, 13, 16, 20, 24, 28, 33, 38, 43, 48, 54, 60, 66, 72, 79, 86, 93, 100};
//        double coefficient = 1.5;//触发系数
//        final int rd = (int) (probabilitys[level] / coefficient + append_intimacy);
//        if (rd == 0) {
//            return;
//        }
//        int rdValue = FightManager.RANDOM.nextInt(100);
//        if (rdValue < rd) {
//            times = getTimes();
//        }
        times = 1;
    }

    private int times = 0;

    public abstract int getTimes();
    public void resetTimes(){
        times = 0;
    }
    public boolean isActive() {
        if (times > 0) {
            times--;
            return true;
        }
        return false;
    }

    @Override
    public List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng) {
        return null;
    }

    public void sendEffect(FightContainer fightContainer) {
        final Vo_12028_0 vo_12028_0 = new Vo_12028_0();
        vo_12028_0.id = buffObject.fid;
        vo_12028_0.effect_no = getStateType();
        vo_12028_0.type = 0;
        FightManager.send(fightContainer, new M12028_0(), vo_12028_0);
    }
}
