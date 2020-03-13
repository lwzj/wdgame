package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.data.UtilObjMap;
import org.linlinjava.litemall.gameserver.data.UtilObjMapshuxing;
import org.linlinjava.litemall.gameserver.domain.BuildFields;
import org.linlinjava.litemall.gameserver.domain.ShouHu;
import org.linlinjava.litemall.gameserver.domain.ShouHuShuXing;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.linlinjava.litemall.gameserver.process.GameUtil;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12016_0;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class M12016_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<ShouHu> object1 = (List<ShouHu>) object;

        GameWriteTool.writeInt(writeBuf, object1.size());
        for (int i = 0; i < object1.size(); i++) {

            GameWriteTool.writeInt(writeBuf, object1.get(i).id);
            GameWriteTool.writeShort(writeBuf, object1.get(i).listShouHuShuXing.size());
            for (int j = 0; j < object1.get(i).listShouHuShuXing.size(); j++) {
                ShouHuShuXing shouHuShuXing = object1.get(i).listShouHuShuXing.get(j);

                Map<Object, Object> map = new HashMap<>();
                if (shouHuShuXing != null) {
                    map = UtilObjMapshuxing.ShouHuShuXing(shouHuShuXing);
                    map.remove("no");
                    map.remove("type1");

                    GameWriteTool.writeByte(writeBuf, shouHuShuXing.no);
                    GameWriteTool.writeByte(writeBuf, shouHuShuXing.type1);
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
        }
    }

    @Override
    public int cmd() {
        return 12016;
    }


}


