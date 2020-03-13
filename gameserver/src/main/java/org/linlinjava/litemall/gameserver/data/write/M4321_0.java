package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_4321_0;
@Service
public class M4321_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_4321_0 object1 = (Vo_4321_0)object;
 GameWriteTool.writeShort(writeBuf,object1.flag);

 GameWriteTool.writeString(writeBuf,object1.dist);

 GameWriteTool.writeString(writeBuf,object1.name);

 GameWriteTool.writeInt(writeBuf,object1.time);

 GameWriteTool.writeShort(writeBuf,object1.a);

 GameWriteTool.writeByte(writeBuf,object1.b);

 GameWriteTool.writeByte(writeBuf,object1.c);
}@Override
    public int cmd() {
        return 4321;
    }
}








