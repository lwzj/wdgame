package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_8247_0;

@Service
public class M8247_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {
        Vo_8247_0 object1 = (Vo_8247_0) object;
        GameWriteTool.writeInt(writeBuf, object1.id);

        GameWriteTool.writeInt(writeBuf, object1.portrait);

        GameWriteTool.writeShort(writeBuf, object1.pic_no);

        GameWriteTool.writeString2(writeBuf, object1.content);

        GameWriteTool.writeString(writeBuf, object1.secret_key);

        GameWriteTool.writeString(writeBuf, object1.name);

        GameWriteTool.writeByte(writeBuf, object1.attrib);
    }

    @Override
    public int cmd() {
        return 8247;
    }
}








