package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.Goods;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_61677_0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class M61677_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_61677_0 object1 = (Vo_61677_0) object;
        GameWriteTool.writeString(writeBuf, object1.store_type);

        GameWriteTool.writeInt(writeBuf, object1.npcID);

        List<Goods> list = (List<Goods>) object1.list;

        GameWriteTool.writeShort(writeBuf, object1.count);


        for (int j = 0; j < list.size(); j++) {
            Goods goods = list.get(j);
            GameWriteTool.writeByte(writeBuf, object1.isGoon);
            GameWriteTool.writeShort(writeBuf, goods.pos);
            GameWriteTool.writeShort(writeBuf, 10);
            Map<Object, Object> map = new HashMap<>();
            if (goods.goodsInfo != null) {
                map = UtilObjMapshuxing.GoodsInfo(goods.goodsInfo);
                map.remove("groupNo");
                map.remove("groupType");
                GameWriteTool.writeByte(writeBuf, goods.goodsInfo.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsInfo.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0) && entry.getKey().equals("silver_coin")) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsBasics != null) {
                map = UtilObjMapshuxing.GoodsBasics(goods.goodsBasics);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsBasics.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsBasics.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsLanSe != null) {
                map = UtilObjMapshuxing.GoodsLanSe(goods.goodsLanSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsLanSe.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsLanSe.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsFenSe != null) {
                map = UtilObjMapshuxing.GoodsFenSe(goods.goodsFenSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsFenSe.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsFenSe.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsHuangSe != null) {
                map = UtilObjMapshuxing.GoodsHuangSe(goods.goodsHuangSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsHuangSe.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsHuangSe.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsLvSe != null) {
                map = UtilObjMapshuxing.GoodsLvSe(goods.goodsLvSe);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsLvSe.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsLvSe.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsGaiZao != null) {
                map = UtilObjMapshuxing.GoodsGaiZao(goods.goodsGaiZao);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsGaiZao.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsGaiZao.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsGaiZaoGongMing != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMing(goods.goodsGaiZaoGongMing);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsGaiZaoGongMing.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsGaiZaoGongMing.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsGaiZaoGongMingChengGong != null) {
                map = UtilObjMapshuxing.GoodsGaiZaoGongMingChengGong(goods.goodsGaiZaoGongMingChengGong);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsGaiZaoGongMingChengGong.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsGaiZaoGongMingChengGong.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
            if (goods.goodsLvSeGongMing != null) {
                map = UtilObjMapshuxing.GoodsLvSeGongMing(goods.goodsLvSeGongMing);
                map.remove("groupNo");
                map.remove("groupType");

                GameWriteTool.writeByte(writeBuf, goods.goodsLvSeGongMing.groupNo);
                GameWriteTool.writeByte(writeBuf, goods.goodsLvSeGongMing.groupType);
                Iterator<Map.Entry<Object, Object>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Object, Object> entry = it.next();
                    if (entry.getValue().equals(0)) {
                        it.remove();
                    }
                }
                GameWriteTool.writeShort(writeBuf, map.size());
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    if (BuildFields.data.get((String) entry.getKey()) != null) {
                        BuildFields.get((String) entry.getKey()).write(writeBuf, entry.getValue());
                    } else {
                        System.out.println(entry.getKey());
                    }
                }
            }
        }
        for (int i = 201; i < 335; i++) {
            if (weizhi(list, i)) {
                GameWriteTool.writeByte(writeBuf, object1.isGoon);
                GameWriteTool.writeShort(writeBuf, i);
                GameWriteTool.writeShort(writeBuf, 0);
            }
        }
    }

    @Override
    public int cmd() {
        return 61677;
    }

    public boolean weizhi(List<Goods> list, int j) {
        HashMap<Object, Object> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i).pos, list.get(i).pos);
        }
        if (map.get(j) == null) {
            return true;
        }
        return false;
    }

}
