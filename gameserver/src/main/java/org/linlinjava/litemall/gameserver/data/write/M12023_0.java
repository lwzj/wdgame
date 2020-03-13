package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_12023_0;

import java.util.List;

@Service
public class M12023_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        List<Vo_12023_0> object1 = (List<Vo_12023_0>) object;
        if (object1.size() > 0) {
            GameWriteTool.writeInt(writeBuf, object1.get(0).owner_id);

            GameWriteTool.writeInt(writeBuf, object1.get(0).id);

            GameWriteTool.writeShort(writeBuf, object1.size());
            for (int i = 0; i < object1.size(); i++) {
                Vo_12023_0 vo_12023_0 = object1.get(i);

                GameWriteTool.writeString(writeBuf, vo_12023_0.god_book_skill_name);

                GameWriteTool.writeShort(writeBuf, vo_12023_0.god_book_skill_level);

                GameWriteTool.writeShort(writeBuf, vo_12023_0.god_book_skill_power);

                GameWriteTool.writeByte(writeBuf, vo_12023_0.god_book_skill_disabled);
            }
        }

    }

    @Override
    public int cmd() {
        return 12023;
    }
}












