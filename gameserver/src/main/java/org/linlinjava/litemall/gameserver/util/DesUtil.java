package org.linlinjava.litemall.gameserver.util;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil
{
    public static String byteArr2HexStr(byte[] paramArrayOfByte)
            throws Exception
    {
        int i = 0;
        int k = paramArrayOfByte.length;
        StringBuffer localStringBuffer = new StringBuffer(k * 2);
        while (i < k)
        {
            int j = paramArrayOfByte[i];
            while (j < 0) {
                j += 256;
            }
            if (j < 16) {
                localStringBuffer.append("0");
            }
            localStringBuffer.append(Integer.toString(j, 16));
            i += 1;
        }
        return localStringBuffer.toString();
    }

    public static String decrypt(String paramString1, String paramString2)
    {
        Key key = getKey(paramString2.getBytes());
        try
        {
            paramString1 = new String(decrypt(hexStr2ByteArr(paramString1), key));
            return paramString1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] decrypt(byte[] paramArrayOfByte, Key paramKey)
            throws Exception
    {
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(2, paramKey);
        return localCipher.doFinal(paramArrayOfByte);
    }

    public static String encrypt(String paramString1, String paramString2)
    {
        Key key = getKey(paramString2.getBytes());
        try
        {
            paramString1 = byteArr2HexStr(encrypt(paramString1.getBytes(), key));
            return paramString1;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] encrypt(byte[] paramArrayOfByte, Key paramKey)
            throws Exception
    {
        Cipher localCipher = Cipher.getInstance("DES");
        localCipher.init(1, paramKey);
        return localCipher.doFinal(paramArrayOfByte);
    }

    private static Key getKey(byte[] paramArrayOfByte)
    {
        byte[] arrayOfByte = new byte[8];
        int i = 0;
        while ((i < paramArrayOfByte.length) && (i < arrayOfByte.length))
        {
            arrayOfByte[i] = paramArrayOfByte[i];
            i += 1;
        }
        return new SecretKeySpec(arrayOfByte, "DES");
    }

    public static byte[] hexStr2ByteArr(String paramString)
            throws Exception
    {
        final byte[] bytes = paramString.getBytes();
        int i = 0;
        int j = bytes.length;
        byte[] arrayOfByte = new byte[j / 2];
        while (i < j)
        {
            String str = new String(bytes, i, 2);
            arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(str, 16));
            i += 2;
        }
        return arrayOfByte;
    }
}
