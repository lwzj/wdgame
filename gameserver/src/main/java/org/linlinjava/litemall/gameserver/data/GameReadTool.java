package org.linlinjava.litemall.gameserver.data;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

public class GameReadTool {
	public static final Charset DEFAULT_CHARSET = Charset.forName("GBK");

	public static String readString(ByteBuf cb) throws IndexOutOfBoundsException {
		int lenght = readUnsignedByte(cb);
		if(lenght==0){
			return "";
		}
		if (lenght > 0 && lenght <= cb.readableBytes()) {
			byte[] strByte = new byte[lenght];
			cb.readBytes(strByte);
			return readString(strByte);
		}else{
			throw new IndexOutOfBoundsException("字符串长度不够 ! ");
		}
	}
	public static String readString2(ByteBuf cb) throws IndexOutOfBoundsException {
		int lenght = cb.readUnsignedShort();
		if(lenght==0){
			return "";
		}
		if (lenght > 0 && lenght <= cb.readableBytes()) {
			byte[] strByte = new byte[lenght];
			cb.readBytes(strByte);
			return readString(strByte);
		}else{
			throw new IndexOutOfBoundsException("字符串长度不够 ! ");
		}
	}
	public static String readString(byte[] bytes){
		return new String(bytes, GameReadTool.DEFAULT_CHARSET);
	}
	public static String readString(byte[] bytes,int length){
		return new String(bytes, 0, length, GameReadTool.DEFAULT_CHARSET);
	}
	public static int readUnsignedByte(ByteBuf cb) {
		return cb.readUnsignedByte();
	}
	public static int readInt(ByteBuf cb){
		return cb.readInt();
	}
	public static int readByte(ByteBuf cb){
		return cb.readUnsignedByte();
	}
	public static int readShort(ByteBuf cb){
		return cb.readUnsignedShort();
	}
	public static ByteBuf readLenBuffer2(ByteBuf cb){
		final int len = cb.readUnsignedShort();
		ByteBuf byteBuf = Unpooled.buffer(len);
		cb.readBytes(byteBuf);
		return byteBuf;
	}

}
