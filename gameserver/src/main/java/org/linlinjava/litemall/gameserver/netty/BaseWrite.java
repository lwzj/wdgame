package org.linlinjava.litemall.gameserver.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import org.linlinjava.litemall.db.util.JSONUtils;
import org.linlinjava.litemall.gameserver.data.GameWriteTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseWrite {
    Logger log = LoggerFactory.getLogger(BaseWrite.class);

    private int beforeWrite(ByteBuf writeBuf){
        GameWriteTool.writeShort(writeBuf,19802);
        GameWriteTool.writeShort(writeBuf,0);
        GameWriteTool.writeInt(writeBuf, (int)System.currentTimeMillis()/1000);
        int writerIndex = writeBuf.writerIndex();
        GameWriteTool.writeShort(writeBuf,0);
        GameWriteTool.writeShort(writeBuf,cmd());
        return writerIndex;
    }
    private void afterWrite(ByteBuf writeBuf,int writerIndex){
        int len = writeBuf.writerIndex() - writerIndex - 2;
        writeBuf.markWriterIndex();
        writeBuf.writerIndex(writerIndex).writeShort(len);
        writeBuf.resetWriterIndex();
    }
    public ByteBuf write(Object object){
        int writerIndex = 0;
        ByteBuf writeBuf = Unpooled.buffer();
        writerIndex = beforeWrite(writeBuf);
        writeO(writeBuf,object);
        afterWrite(writeBuf,writerIndex);
        return writeBuf;
    }
    protected abstract void writeO(ByteBuf writeBuf,Object object);
    public abstract int cmd();
}
