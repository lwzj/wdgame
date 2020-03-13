package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_41017_0;

@Service
public class M41017_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf, Object object) {

        GameWriteTool.writeByte(writeBuf, 4);

        GameWriteTool.writeString(writeBuf, "xiux");

        GameWriteTool.writeString(writeBuf, "xiuxjz");

        GameWriteTool.writeString(writeBuf, "xiuxjz");

        GameWriteTool.writeString(writeBuf, "xiuxjz");
    }

    @Override
    public int cmd() {
        return 41017;
    }
}






