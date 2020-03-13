package org.linlinjava.litemall.gameserver.data.write;

import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.linlinjava.litemall.gameserver.netty.BaseWrite;
import org.springframework.stereotype.Service;
import io.netty.buffer.ByteBuf;
import org.linlinjava.litemall.gameserver.data.vo.Vo_7659_0;
@Service
public class M7659_0 extends BaseWrite {
    @Override
    protected void writeO(ByteBuf writeBuf,Object object) {
Vo_7659_0 object1 = (Vo_7659_0)object;
 GameWriteTool.writeShort(writeBuf,object1.a);

 GameWriteTool.writeInt(writeBuf,object1.id);

 GameWriteTool.writeShort(writeBuf,object1.time);

 GameWriteTool.writeInt(writeBuf,object1.question);

 GameWriteTool.writeShort(writeBuf,object1.round);

 GameWriteTool.writeInt(writeBuf,object1.curTime);
}@Override
    public int cmd() {
        return 7659;
    }
}







