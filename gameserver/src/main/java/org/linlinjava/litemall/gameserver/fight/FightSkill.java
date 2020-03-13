package org.linlinjava.litemall.gameserver.fight;

import org.linlinjava.litemall.gameserver.domain.JiNeng;

import java.util.List;

public interface FightSkill {
    List<FightResult> doSkill(FightContainer fightContainer, FightRequest fightRequest, JiNeng jiNeng);

    int getStateType();

    static FightFabaoSkill getFabaoSkill(String name) {
        switch (name) {
            case "番天印":
                return new FantianyingSkill();
            case "定海珠":
                return new DinghaizhuSkill();
            case "混元金斗":
                return new HunyuanjindouSkill();
            case "阴阳镜":
                return new YinyangjingSkill();
            case "卸甲金葫":
                return new XiejiajinhuSkill();
        }
        return null;
    }

    static boolean isOpSkill(int para) {
        switch (para) {
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
                return false;
        }
        return true;
    }

    static FightSkill getFightSkill(int action, int para) {
        if (action == 2 && para == 0) {
            System.out.println("error getFightSkill");
        }
        switch (action) {
            case 1:
                return new DefenseSkill();
            case 2:
                return new NormalAttackSkill();
            case 3:
                switch (para) {
                    //金
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 110:
                    case 111:
                    case 112:
                    case 113:
                    case 114:
                    case 161:
                    case 162:
                    case 163:
                    case 164:
                    case 165:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                        return new CastMagic11Skill();
                    case 501:
                        return new CastMagic501Skill();
                    case 181:
                    case 182:
                    case 183:
                    case 184:
                    case 185:
                        return new FuzhuHuo181Skill();
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 85:
                        return new FuzhuMu81Skill();
                    case 131:
                    case 132:
                    case 133:
                    case 134:
                    case 135:
                        return new FuzhuShui131Skill();
                    case 231:
                    case 232:
                    case 233:
                    case 234:
                    case 235:
                        return new FuzhuTu231Skill();
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                        return new FuzhuJin31Skill();
                    case 171:
                    case 172:
                    case 173:
                    case 174:
                    case 175:
                        return new ZhangaiHuo171Skill();

                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        return new ZhangAiJin21Skill();
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                        return new ZhangaiMu71Skill();
                    case 121:
                    case 122:
                    case 123:
                    case 124:
                    case 125:
                        return new ZhangaiShui121Skill();
                    case 221:
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                        return new ZhangAiTu221Skill();

                }
            case 14:
                return new ZhaohuiSkill();
            case 9:
                return new CatchPetSkill();
            case 8:
                return new ZhaoChuSkill();
            case 7:
                return new FleeSkill();
            case 4:
                return new UseItemSkill();
        }
        return null;
    }
}
