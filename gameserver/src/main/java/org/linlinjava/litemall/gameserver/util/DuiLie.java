package org.linlinjava.litemall.gameserver.util;
import org.linlinjava.litemall.gameserver.domain.Chara;

import java.util.LinkedList;
public class DuiLie {
    private int zs;
    private Chara chara;
    private LinkedList<Integer> list;
    public DuiLie(){
        list = new LinkedList();
    }
    public void add(Integer obj){
        list.add(obj);
        if(list.size()>=3){
            list.remove();
        }
    }
    public void get(){
        for(int i=0;i<list.size();i++){
          System.out.println(list.get(i));
        }
    }
    public LinkedList getList(){
        return list;
    }
    public boolean isNull(){
        return list.isEmpty();
    }
    public int getCmdNumber(int cmd){
        int count=0;
        for(int i=0;i<list.size();i++){
            if(cmd==list.get(i)){
                count++;
            }
        }
        return count;
    }

    public int getZs() {
        return zs;
    }

    public void setZs(int zs) {
        this.zs = zs;
    }

    public Chara getChara() {
        return chara;
    }

    public void setChara(Chara chara) {
        this.chara = chara;
    }
}