package org.linlinjava.litemall.gameserver.fight;

import org.json.JSONObject;
import org.linlinjava.litemall.db.domain.Pet;
import org.linlinjava.litemall.db.domain.SkillMonster;
import org.linlinjava.litemall.db.domain.ZhuangbeiInfo;
import org.linlinjava.litemall.gameserver.data.game.BasicAttributesUtils;
import org.linlinjava.litemall.gameserver.data.game.PetAndHelpSkillUtils;
import org.linlinjava.litemall.gameserver.data.game.SuitEffectUtils;
import org.linlinjava.litemall.gameserver.data.vo.*;
import org.linlinjava.litemall.gameserver.data.write.*;
import org.linlinjava.litemall.gameserver.domain.*;
import org.linlinjava.litemall.gameserver.game.GameData;
import org.linlinjava.litemall.gameserver.game.GameShuaGuai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightObject {

    public int id;
    public int cid;
    public int fid;
    public String str;
    public int leader;
    public int type;
    public int pos;

    public int weapon_icon;

    public int guaiwulevel;
    public int mofa;
    public int shengming;
    public int max_mofa;
    public int max_shengming;
    public int fangyu;
    public int accurate;
    public int fashang;
    public int parry;

    public int fangyu_ext;
    public int accurate_ext;
    public int fashang_ext;
    public int parry_ext;

    public int durability;
    public int org_icon;//外观
    public int suit_icon;
    public int suit_light_effect;
    public int special_icon;
    public int state = 1;
    private List<Integer> buffState = new ArrayList<>();
    public List<JiNeng> skillsList;
    public FightRequest fightRequest;

    private List<FightSkill> fightSkillList = new ArrayList<>();

    public int autofight_select = 0;
    public int autofight_skillaction;
    public int autofight_skillno;


    //道行
    public int friend;


    public int rank;
    public int godbook;
    public boolean run;//逃跑

    public FightObject(Chara chara) {
        id = chara.id;
        str = chara.name;
        weapon_icon = chara.weapon_icon;
        shengming = chara.max_life;
        mofa = chara.max_mana;
        max_shengming = chara.def + chara.zbAttribute.def;
        max_mofa = chara.dex + chara.zbAttribute.dex;
        fashang = chara.mana + chara.zbAttribute.mana;
        parry = chara.parry + chara.zbAttribute.parry;
        accurate = chara.accurate + chara.zbAttribute.accurate;
        fangyu = chara.wiz + chara.zbAttribute.wiz;
        suit_icon = chara.suit_icon;
        suit_light_effect = chara.suit_light_effect;
        org_icon = chara.waiguan;

        friend = chara.friend;


        skillsList = chara.jiNengList;


        this.type = 1;
        autofight_skillno = chara.autofight_skillno;
        autofight_select = chara.autofight_select;
        autofight_skillaction = chara.autofight_skillaction;
    }

    public boolean isDead() {
        return state == 2 || state == 3;
    }

    public boolean doDead() {
        if (state == 6) {
            state = 2;
        } else if (state == 7) {
            state = 3;
        } else {
            return false;
        }
        final List<FightRoundSkill> roundSkill = getRoundSkill();
        final FightContainer fightContainer = FightManager.getFightContainer(fid);
        for (FightRoundSkill fightRoundSkill : roundSkill) {
            if (fightRoundSkill.getStateType() != 528128) {
                removeBuffState(fightContainer, fightRoundSkill.getStateType());
                fightSkillList.remove(fightRoundSkill);
            }
        }
        return true;
    }

    public List<FightRoundSkill> getRoundSkill() {
        List<FightRoundSkill> list = new ArrayList<>();
        for (FightSkill fightSkill : fightSkillList) {
            if (fightSkill instanceof FightRoundSkill) {
                list.add((FightRoundSkill) fightSkill);
            }
        }
        return list;
    }

    public FightFabaoSkill getFabaoSkill() {
        for (FightSkill fightSkill : fightSkillList) {
            if (fightSkill instanceof FightFabaoSkill) {
                return (FightFabaoSkill) fightSkill;
            }
        }
        return null;
    }

    public boolean isActiveTianshu(FightContainer fc, int state) {
        for (FightSkill fightSkill : fightSkillList) {
            if (fightSkill instanceof FightTianshuSkill) {
//                return (FightFabaoSkill) fightSkill;
                FightTianshuSkill fts = (FightTianshuSkill) fightSkill;
                if (fts.getStateType() == state) {
                    fts.sendEffect(fc);
                    return fts.isActive();
                }
            }
        }
        return false;
    }

    public FightObject(Chara chara, String name) {
        String strname = name;
        Petbeibao petbeibao = new Petbeibao();
        if (name.contains("土匪")) {
            strname = "土匪";
        }
        if (name.contains("强盗")) {
            strname = "强盗";
        }
        if (name.contains("狐狸妖")) {
            strname = "狐狸妖";
        }
        if (name.contains("鱼妖")) {
            strname = "鱼妖";
        }
        if (name.contains("蓝精")) {
            strname = "蓝精";
        }
        if (name.contains("黄怪")) {
            strname = "黄怪";
        }
        if (name.contains("疯魑")) {
            strname = "疯魑";
        }
        if (name.contains("狂魍")) {
            strname = "狂魍";
        }
        if (name.contains("蟒怪")) {
            strname = "蟒怪";
        }
        if (name.contains("鸟精")) {
            strname = "鸟精";
        }
        if (name.contains("琵琶妖")) {
            strname = "琵琶妖";
        }
        if (name.contains("蟒妖")) {
            strname = "蟒妖";
        }
        if (name.contains("怪王狂狮")) {
            strname = "怪王狂狮";
        }
        if (name.contains("鬼王黑熊")) {
            strname = "鬼王黑熊";
        }
        if (name.contains("鬼王悍猪")) {
            strname = "鬼王悍猪";
        }
        if (name.contains("混天巨象")) {
            strname = "混天巨象";
        }
        if (name.contains("兑灵")) {
            strname = "兑灵";
        }
        if (name.contains("艮灵")) {
            strname = "艮灵";
        }
        if (name.contains("坎灵")) {
            strname = "坎灵";
        }
        if (name.contains("离灵")) {
            strname = "离灵";
        }
        if (name.contains("狂灵")) {
            strname = "狂灵";
        }
        if (name.contains("疯灵")) {
            strname = "疯灵";
        }
        if (name.contains("山神")) {
            strname = "山神";
        }
        if (name.contains("炎神")) {
            strname = "炎神";
        }
        if (name.contains("雷神")) {
            strname = "雷神";
        }
        if (name.contains("花神")) {
            strname = "花神";
        }
        if (name.contains("龙神")) {
            strname = "龙神";
        }
        if (name.contains("仙界叛逆")) {
            strname = chara.npcXuanShangName;
            friend = (int) (0.29 * chara.level * chara.level * chara.level * (0.29 * chara.level * chara.level * chara.level));
        }

        String names = "土匪#强盗#狐狸妖#鱼妖#蓝精#黄怪#疯魑#狂魍#蟒怪#鸟精#琵琶妖蟒妖#怪王狂狮#鬼王黑熊#鬼王悍猪#混天巨象#兑灵#艮灵#坎灵#离灵#狂灵#疯灵#山神#炎神#雷神#花神#龙神#刀斧手#火扇儒生#红衣剑客#试道元魔";
        if (name.equals("帮凶") || name.equals("喽啰") || strname.equals("土匪") || strname.equals("强盗") || names.contains(strname)) {
            petbeibao = petCreate(strname, chara.level);
        } else {
            petbeibao = petCreate(strname);
        }
        List<SkillMonster> monsters = GameData.that.baseSkillMonsterService.findByName(strname);
        String skills = "";
        if (monsters != null && monsters.size() > 0) {
            for (int i = 0; i < monsters.size(); i++) {
                if (monsters.get(i).getType() == 1) {
                    skills = monsters.get(i).getSkills();
                }
            }
        }
        str = name;
        guaiwulevel = petbeibao.petShuXing.get(0).skill;
        shengming = (int) (petbeibao.petShuXing.get(0).max_life * 0.8);
        mofa = (int) (petbeibao.petShuXing.get(0).max_mana * 0.8);
        max_mofa = (int) (petbeibao.petShuXing.get(0).dex * 0.8);
        max_shengming = (int) (petbeibao.petShuXing.get(0).def * 0.8);
        fashang = (int) (petbeibao.petShuXing.get(0).mana * 0.8);
        parry = (int) (petbeibao.petShuXing.get(0).parry * 0.8);
        accurate = (int) (petbeibao.petShuXing.get(0).accurate * 0.8);
        fangyu = (int) (petbeibao.petShuXing.get(0).wiz * 0.8);
        org_icon = petbeibao.petShuXing.get(0).type;
        boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
        skillsList = dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, 123456, skills);
        this.type = 4;
    }


    public boolean canAtta() {
        boolean canbe = true;
        if (state == 2 || state == 3) {
            canbe = false;
        }
        if (hasBuffState(3844) || hasBuffState(3856)) {
            canbe = false;
        }
        return canbe;
    }

    public boolean canbeVictim() {
        boolean canbe = true;
        if (state == 2
                || state == 3

        ) {
            canbe = false;
        }
        return canbe;
    }

    public FightObject(String name) {
        str = name;
        Petbeibao petbeibao = petCreate(name);
        shengming = petbeibao.petShuXing.get(0).max_life;
        mofa = petbeibao.petShuXing.get(0).max_mana;
        max_mofa = petbeibao.petShuXing.get(0).dex;
        max_shengming = petbeibao.petShuXing.get(0).def;
        fashang = petbeibao.petShuXing.get(0).mana;
        parry = petbeibao.petShuXing.get(0).parry;
        accurate = petbeibao.petShuXing.get(0).accurate;
        fangyu = petbeibao.petShuXing.get(0).wiz;
        org_icon = petbeibao.petShuXing.get(0).type;
        boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
        skillsList = dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, 123456, "");
        this.type = 4;
    }

    public FightObject(ShouHu shouHu) {
//        int[] ints = BasicAttributesUtils.calculationHelpAttributes(chara.level, attributes[0], attributes[1], attributes[2], attributes[3], polars[0], polars[1], polars[2], polars[3], polars[4],pos1);
        str = shouHu.listShouHuShuXing.get(0).str;
        shengming = shouHu.listShouHuShuXing.get(0).max_life;
        max_shengming = shouHu.listShouHuShuXing.get(0).def;
        fashang = shouHu.listShouHuShuXing.get(0).mana;
        parry = shouHu.listShouHuShuXing.get(0).parry;
        accurate = shouHu.listShouHuShuXing.get(0).accurate;
        fangyu = shouHu.listShouHuShuXing.get(0).wiz;
        org_icon = shouHu.listShouHuShuXing.get(0).type;
        List<SkillMonster> monsters = GameData.that.baseSkillMonsterService.findByName(str);
        String skills = "";
        if (monsters != null && monsters.size() > 0) {
            for (int i = 0; i < monsters.size(); i++) {
                if (monsters.get(i).getType() == 2) {
                    skills = monsters.get(i).getSkills();
                }
            }
        }
        String[] split = skills.split("##");
        if (shouHu.listShouHuShuXing.get(0).max_degree == 0) {
            skills = split[0];
        } else {
            skills = split[1];
        }

        skillsList = dujineng(2, shouHu.listShouHuShuXing.get(0).metal, shouHu.listShouHuShuXing.get(0).skill, true, shouHu.id, skills);
        this.type = 3;
        durability = 32;
        rank = 2;
    }

    public FightObject(Petbeibao pet) {
        int life = pet.petShuXing.get(0).def;
        if (pet.petShuXing.get(0).max_life > pet.petShuXing.get(0).def) {
            life = pet.petShuXing.get(0).max_life;
        }
        str = pet.petShuXing.get(0).str;
        shengming = life;
        mofa = pet.petShuXing.get(0).dex;
        max_mofa = pet.petShuXing.get(0).max_mana;
        max_shengming = life;
        fashang = pet.petShuXing.get(0).mana;
        parry = pet.petShuXing.get(0).parry;
        accurate = pet.petShuXing.get(0).accurate;
        fangyu = pet.petShuXing.get(0).wiz;
        org_icon = pet.petShuXing.get(0).type;
        boolean isfagong = pet.petShuXing.get(0).rank > pet.petShuXing.get(0).pet_mag_shape;
        skillsList = dujineng(1, pet.petShuXing.get(0).metal, pet.petShuXing.get(0).skill, isfagong, pet.id, "");
        this.type = 2;
        autofight_skillno = pet.autofight_skillno;
        autofight_select = pet.autofight_select;
        autofight_skillaction = pet.autofight_skillaction;


        friend = pet.petShuXing.get(0).intimacy / 2;
        durability = 32768;
        rank = 2;
    }


    public Petbeibao petCreate(String name) {
        Pet pet = GameData.that.basePetService.findOneByName(name);
        Petbeibao petbeibao = new Petbeibao();
        PetShuXing shuXing = new PetShuXing();
        shuXing.type = pet.getIcon();
        shuXing.passive_mode = pet.getIcon();
        shuXing.attrib = pet.getLevelReq();
        shuXing.str = pet.getName();
        shuXing.skill = 1;
        shuXing.pot = 0;
        shuXing.resist_poison = 258;
        shuXing.martial = 10000;
        shuXing.suit_polar = pet.getName();
        shuXing.auto_fight = shuXing.auto_fight + id;
        if (pet.getPolar().equals("金")) {
            shuXing.metal = 1;
        }
        if (pet.getPolar().equals("木")) {
            shuXing.metal = 2;
        }
        if (pet.getPolar().equals("水")) {
            shuXing.metal = 3;
        }
        if (pet.getPolar().equals("火")) {
            shuXing.metal = 4;
        }
        if (pet.getPolar().equals("土")) {
            shuXing.metal = 5;
        }
        shuXing.mana_effect = pet.getLife() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.attack_effect = pet.getMana() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.mag_effect = pet.getPhyAttack() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.phy_absorb = pet.getMagAttack() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.phy_effect = pet.getSpeed() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.pet_mana_shape = shuXing.mana_effect + 40;
        shuXing.pet_speed_shape = shuXing.attack_effect + 40;
        shuXing.pet_phy_shape = shuXing.phy_effect + 40;
        shuXing.pet_mag_shape = shuXing.mag_effect + 40;
        shuXing.rank = shuXing.phy_absorb + 40;
        shuXing.resist_point = shuXing.pet_mana_shape + shuXing.pet_speed_shape + shuXing.pet_phy_shape + shuXing.pet_mag_shape + shuXing.rank;
        //给随机属性
        shuXing.skill = pet.getLevelReq();
        shuXing.attrib = pet.getLevelReq();
        int polar_point = shuXing.skill * 4;
        int addpoint = FightManager.RANDOM.nextInt(polar_point - shuXing.skill * 3);
        polar_point = polar_point - addpoint;
        shuXing.life = shuXing.skill + addpoint;
        addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.mag_power = shuXing.skill + addpoint;
        addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.phy_power = shuXing.skill + addpoint;
        addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.speed = shuXing.skill + addpoint;
        petbeibao.petShuXing.add(shuXing);
        BasicAttributesUtils.petshuxing(shuXing);
        shuXing.max_life = shuXing.def;
        shuXing.max_mana = shuXing.dex;
        petbeibao.petShuXing.add(shuXing);

        return petbeibao;
    }


    public Petbeibao petCreate(String name, int level) {
        Pet pet = GameData.that.basePetService.findOneByName(name);
        Petbeibao petbeibao = new Petbeibao();
        PetShuXing shuXing = new PetShuXing();
        shuXing.type = pet.getIcon();
        shuXing.passive_mode = pet.getIcon();
        shuXing.attrib = pet.getLevelReq();
        shuXing.str = pet.getName();
        shuXing.skill = level;
        shuXing.pot = 0;
        shuXing.resist_poison = 258;
        shuXing.martial = 10000;
        shuXing.suit_polar = pet.getName();
        shuXing.auto_fight = shuXing.auto_fight + id;
        if (pet.getPolar().equals("金")) {
            shuXing.metal = 1;
        }
        if (pet.getPolar().equals("木")) {
            shuXing.metal = 2;
        }
        if (pet.getPolar().equals("水")) {
            shuXing.metal = 3;
        }
        if (pet.getPolar().equals("火")) {
            shuXing.metal = 4;
        }
        if (pet.getPolar().equals("土")) {
            shuXing.metal = 5;
        }
        shuXing.mana_effect = pet.getLife() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.attack_effect = pet.getMana() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.mag_effect = pet.getPhyAttack() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.phy_absorb = pet.getMagAttack() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.phy_effect = pet.getSpeed() - 40 - FightManager.RANDOM.nextInt(20) - 10;
        shuXing.pet_mana_shape = shuXing.mana_effect + 40;
        shuXing.pet_speed_shape = shuXing.attack_effect + 40;
        shuXing.pet_phy_shape = shuXing.phy_effect + 40;
        shuXing.pet_mag_shape = shuXing.mag_effect + 40;
        shuXing.rank = shuXing.phy_absorb + 40;
        shuXing.resist_point = shuXing.pet_mana_shape + shuXing.pet_speed_shape + shuXing.pet_phy_shape + shuXing.pet_mag_shape + shuXing.rank;
        //给随机属性
//        shuXing.skill = pet.getLevelReq();
////        shuXing.attrib = pet.getLevelReq();
        int polar_point = shuXing.skill * 4;
        int addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.life = shuXing.skill + addpoint;
        addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.mag_power = shuXing.skill + addpoint;
        addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.phy_power = shuXing.skill + addpoint;
        addpoint = FightManager.RANDOM.nextInt(polar_point);
        polar_point = polar_point - addpoint;
        shuXing.speed = shuXing.skill + addpoint;
        petbeibao.petShuXing.add(shuXing);
        BasicAttributesUtils.petshuxing(shuXing);
        shuXing.max_life = shuXing.def;
        shuXing.max_mana = shuXing.dex;
        petbeibao.petShuXing.add(shuXing);

        return petbeibao;
    }

    public static List<JiNeng> dujineng(int leixing, int pos, int level, boolean isMagic, int id, String skills) {
        List<JiNeng> jiNengList = new ArrayList<>();
        List<JSONObject> nomelSkills = PetAndHelpSkillUtils.getNomelSkills(leixing, pos, level, true, skills);
        for (int i = 0; i < nomelSkills.size(); i++) {
            JiNeng jiNeng = new JiNeng();
            JSONObject jsonObject = nomelSkills.get(i);
            jiNeng.id = id;
            jiNeng.skill_no = Integer.parseInt((String) jsonObject.get("skillNo"));
            jiNeng.skill_attrib = (int) jsonObject.get("skillLevel");
            jiNeng.skill_level = (int) jsonObject.get("skillLevel");
            jiNeng.skillRound = jsonObject.optInt("skillRound");
            jiNeng.level_improved = 0;
            jiNeng.skill_mana_cost = (int) jsonObject.get("skillBlue");
            jiNeng.skill_nimbus = 42949672;
            jiNeng.skill_disabled = 0;
            jiNeng.range = (int) jsonObject.get("skillNum");
            jiNeng.max_range = (int) jsonObject.get("skillNum");
            jiNengList.add(jiNeng);
        }
        return jiNengList;
    }

    public void updateState(FightContainer fightContainer, int state, int type) {
        final Vo_11757_0 vo_11757_0 = new Vo_11757_0();
        vo_11757_0.id = fid;
        vo_11757_0.list.add(state);
        vo_11757_0.list.add(type);
        FightManager.send(fightContainer, new M11757_0(), vo_11757_0);
    }
//
//    public void updateState(FightContainer fightContainer, int... state) {
//        final Vo_11757_0 vo_11757_0 = new Vo_11757_0();
//        vo_11757_0.id = fid;
//        for (int i : state) {
//            vo_11757_0.SKILL_INDEX_LIST.add(i);
//            vo_11757_0.SKILL_INDEX_LIST.add(32);
//        }
//        FightManager.send(fightContainer, new MSG_C_UPDATE_STATUS_11757_0(), vo_11757_0);
//    }

    public void updateState(FightContainer fightContainer) {
        final Vo_11757_0 vo_11757_0 = new Vo_11757_0();
        vo_11757_0.id = fid;
        if (buffState.isEmpty()) {
            vo_11757_0.list.add(0);
            vo_11757_0.list.add(0);
        } else {
            Vo_19959_0 vo_19959_0 = new Vo_19959_0();
            vo_19959_0.round = fightContainer.round;
            vo_19959_0.aid = fid;
            vo_19959_0.action = 43;
            vo_19959_0.vid = fid;
            vo_19959_0.para = 0;
            FightManager.send(fightContainer, new M19959_0(), vo_19959_0);
            int value = 0;
            for (Integer integer : buffState) {
                value += integer;
            }
            vo_11757_0.list.add(value);
            vo_11757_0.list.add(32);
            Vo_7655_0 vo_7655_0 = new Vo_7655_0();
            vo_7655_0.id = fid;
            FightManager.send(fightContainer, new M7655_0(), vo_7655_0);
        }


        FightManager.send(fightContainer, new M11757_0(), vo_11757_0);
    }


    public void update(FightContainer fightContainer) {
        final ArrayList<Integer> objects = new ArrayList<>();
        objects.add(fid);
        objects.add(shengming);
        FightManager.send(fightContainer, new M64981_Fight_Blood(), objects);
    }

    public int reduceShengming(int reduce, boolean fabao) {
        if (!canbeHurt()) {
            return 0;
        }
        if (hasBuffState(3844)) {
            removeBuffSK(FightManager.getFightContainer(fid), 3844);
        }
        if (fabao) {
            final FightFabaoSkill fabaoSkill = getFabaoSkill();
            if (fabaoSkill != null && fabaoSkill.getStateType() == 8015 && fabaoSkill.isActive()) {
                fabaoSkill.sendEffect(FightManager.getFightContainer(fid));
                reduce = 0;
            }
        }
        if (shengming <= reduce) {
            reduce = shengming;
            shengming = 0;
            if (type == 1 || type == 3) {
                state = 6;
            } else {
                if (canbeRevive()) {
                    state = 6;
                } else {
                    state = 7;
                }
            }
        } else {
            shengming -= reduce;
        }
        return reduce;
    }

    public int addShengming(int reduce) {
        if (shengming + reduce <= max_shengming) {
            shengming += reduce;
        } else {
            reduce = max_shengming - shengming;
            shengming = max_shengming;
        }
        return reduce;
    }

    public void addBuffState(FightContainer fightContainer, Integer state) {
        if (isBingdong()) {
            return;
        }
        if (!buffState.contains(state)) {
            buffState.add(state);
            updateState(fightContainer);
        }
        switch (state) {
            case 20224:
                removeBuffSK(fightContainer, 12032);
                break;
            case 12032:
                removeBuffSK(fightContainer, 20224);
                break;
            case 134912:
                removeBuffSK(fightContainer, 265984);
                break;
            case 265984:
                removeBuffSK(fightContainer, 134912);
                break;
            case 3848:
                removeBuffSK(fightContainer, 3856);
                removeBuffSK(fightContainer, 3844);
                removeBuffSK(fightContainer, 3872);
                break;
            case 3842:
                removeBuffSK(fightContainer, 3856);
                removeBuffSK(fightContainer, 3844);
                removeBuffSK(fightContainer, 20224);
                removeBuffSK(fightContainer, 265984);
                removeBuffSK(fightContainer, 12032);
                removeBuffSK(fightContainer, 134912);
                break;
            case 3856:
                removeBuffSK(fightContainer, 3848);
                removeBuffSK(fightContainer, 3844);
                removeBuffSK(fightContainer, 3872);
                removeBuffSK(fightContainer, 3842);
                break;

            case 3844:
                removeBuffSK(fightContainer, 3848);
                removeBuffSK(fightContainer, 3856);
                removeBuffSK(fightContainer, 3872);
                removeBuffSK(fightContainer, 3842);
                break;

            case 3872:
                removeBuffSK(fightContainer, 3848);
                removeBuffSK(fightContainer, 3856);
                removeBuffSK(fightContainer, 3844);
                break;
            default:
                break;
        }
    }

    public void removeBuffSK(FightContainer fightContainer, Integer state) {
        removeBuffState(fightContainer, state);
        removeFightSkill(state);
    }

    public void removeBuffState(FightContainer fightContainer, Integer state) {
        if (buffState.remove(state)) {
            updateState(fightContainer);
        }
    }

    public void addSkill(FightSkill fightSkill) {
        final List<FightRoundSkill> roundSkill = getRoundSkill();
        for (FightRoundSkill skill : roundSkill) {
            if (skill.getStateType() == fightSkill.getStateType()) {
                removeSkill(skill);
            }
        }
        this.fightSkillList.add(fightSkill);
    }

    public void removeSkill(FightSkill fightSkill) {
        fightSkillList.remove(fightSkill);
    }

    public void removeFightSkill(int buffstate) {
        final List<FightRoundSkill> roundSkill = getRoundSkill();
        for (FightRoundSkill fightRoundSkill : roundSkill) {
            if (fightRoundSkill.getStateType() == buffstate) {
                fightSkillList.remove(fightRoundSkill);
            }
        }
    }

    public void revive(FightContainer fightContainer) {
        final Vo_7667_0 vo_7667_0 = new Vo_7667_0();
        vo_7667_0.id = fid;
        FightManager.send(fightContainer, new M7667_0(), vo_7667_0);
        update(fightContainer);
        final FightResult fightResult = new FightResult();
        fightResult.id = fid;
        fightResult.vid = fid;
        fightResult.point = shengming;
        fightResult.effect_no = 10005;
        fightResult.damage_type = 0;
        FightManager.send_LIFE_DELTA(fightContainer, fightResult);
        update(fightContainer);
    }

    public boolean canbeRevive() {
        return hasBuffState(528128);
    }

    public boolean canbeSkill() {
        return !hasBuffState(3848) && !hasBuffState(3872);
    }

    public boolean canbeHurt() {
        return !hasBuffState(3856);
    }

    public boolean isHunluan() {
        return hasBuffState(3872);
    }

    public boolean isZhongdu() {
        return hasBuffState(3842);
    }

    public boolean isYiwang() {
        return hasBuffState(3848);
    }

    public boolean isBingdong() {
        return hasBuffState(3856);
    }


    public boolean isRun() {
        return run;
    }


    public boolean hasBuffState(int buff) {
        for (Integer integer : buffState) {
            if (integer == buff) {
                return true;
            }
        }
        return false;
    }


    //杀星的
    public FightObject(Chara chara, String name, Vo_65529_0 vo_65529_0) {
        Random random = new Random();
        String strname = name;
        Petbeibao petbeibao = new Petbeibao();
        String replace = "";
        if (name.length() > 1) {
            String substring = name.substring(1, 2);
            replace = name.replace(substring, "");
        }
        int suit_iconlinshi = 0;
        int suit_light_effectlinshi = 0;
        int icon = 0;
        if (replace.equals("天星") || replace.equals("地星"))
            if (name.equals(vo_65529_0.name)) {
                suit_iconlinshi = vo_65529_0.suit_icon;
                suit_light_effectlinshi = vo_65529_0.suit_light_effect;
                icon = vo_65529_0.icon;
                if (vo_65529_0.leixing == 1) {
                    strname = "金星";
                }
                if (vo_65529_0.leixing == 2) {
                    strname = "木星";
                }
                if (vo_65529_0.leixing == 3) {
                    strname = "水星";
                }
                if (vo_65529_0.leixing == 4) {
                    strname = "火星";
                }
                if (vo_65529_0.leixing == 5) {
                    strname = "土星";
                }
            }
        if (name.equals("星")) {
            int leixing = random.nextInt(5) + 1;
            if (leixing == 1) {
                strname = "金星";
            }
            if (leixing == 2) {
                strname = "木星";
            }
            if (leixing == 3) {
                strname = "水星";
            }
            if (leixing == 4) {
                strname = "火星";
            }
            if (leixing == 5) {
                strname = "土星";
            }
            int sex = random.nextInt(1) + 1;
            icon = GameShuaGuai.waiguan(leixing, sex);
            int[] suit = SuitEffectUtils.suit(sex - 1, vo_65529_0.level, leixing, random.nextInt(5) + 1);
            vo_65529_0.org_icon = vo_65529_0.icon;
            suit_iconlinshi = suit[0];
            suit_light_effectlinshi = suit[1];
            name = vo_65529_0.name;
        }


        petbeibao = petCreate(strname, vo_65529_0.level);
        List<SkillMonster> monsters = GameData.that.baseSkillMonsterService.findByName(strname);
        String skills = "";
        if (monsters != null && monsters.size() > 0) {
            for (int i = 0; i < monsters.size(); i++) {
                if (monsters.get(i).getType() == 1) {
                    skills = monsters.get(i).getSkills();
                }
            }
        }
        int weapon_iconlingshi = 0;
        List<ZhuangbeiInfo> infoList = GameData.that.baseZhuangbeiInfoService.findByAttrib(vo_65529_0.level / 10 * 10);
        for (ZhuangbeiInfo zhuangbeiInfo : infoList) {
            if (zhuangbeiInfo.getAmount() == 1 && zhuangbeiInfo.getMetal() == petbeibao.petShuXing.get(0).metal) {
                weapon_iconlingshi = zhuangbeiInfo.getType();
            }
        }

        str = name;
        guaiwulevel = vo_65529_0.level;
        shengming = (int) (petbeibao.petShuXing.get(0).max_life * 0.8);
        mofa = (int) (petbeibao.petShuXing.get(0).max_mana * 0.8);
        max_mofa = (int) (petbeibao.petShuXing.get(0).dex * 0.8);
        max_shengming = (int) (petbeibao.petShuXing.get(0).def * 0.8);
        fashang = (int) (petbeibao.petShuXing.get(0).mana * 0.8);
        parry = (int) (petbeibao.petShuXing.get(0).parry * 0.8);
        accurate = (int) (petbeibao.petShuXing.get(0).accurate * 0.8);
        fangyu = (int) (petbeibao.petShuXing.get(0).wiz * 0.8);
        weapon_icon = weapon_iconlingshi;
        org_icon = icon;
        suit_icon = suit_iconlinshi;
        suit_light_effect = suit_light_effectlinshi;

        friend = (int) (0.29 * vo_65529_0.level * vo_65529_0.level * vo_65529_0.level * (0.29 * vo_65529_0.level * vo_65529_0.level * vo_65529_0.level));

        boolean isfagong = petbeibao.petShuXing.get(0).rank > petbeibao.petShuXing.get(0).pet_mag_shape;
        skillsList = dujineng(1, petbeibao.petShuXing.get(0).metal, petbeibao.petShuXing.get(0).skill, isfagong, 123456, skills);
        this.type = 4;
    }
}
