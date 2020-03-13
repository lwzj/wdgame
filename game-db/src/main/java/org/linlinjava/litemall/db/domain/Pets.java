package org.linlinjava.litemall.db.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.format.annotation.DateTimeFormat;

public class Pets implements Cloneable, Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pets
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean IS_DELETED = Deleted.IS_DELETED.value();

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pets
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public static final Boolean NOT_DELETED = Deleted.NOT_DELETED.value();

    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String ownerid;

    /**
     * 
     */
    private String petid;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer horsetype;

    /**
     * 
     */
    private Integer type;

    /**
     * 
     */
    private Integer level;

    /**
     * 
     */
    private Integer liliang;

    /**
     * 
     */
    private Integer minjie;

    /**
     * 
     */
    private Integer lingli;

    /**
     * 
     */
    private Integer tili;

    /**
     * 
     */
    private Integer dianhualx;

    /**
     * 
     */
    private Integer dianhuazd;

    /**
     * 
     */
    private Integer dianhuazx;

    /**
     * 
     */
    private Integer yuhualx;

    /**
     * 
     */
    private Integer yuhuazd;

    /**
     * 
     */
    private Integer yuhuazx;

    /**
     * 
     */
    private Integer cwjyzx;

    /**
     * 
     */
    private Integer cwjyzd;

    /**
     * 
     */
    private Integer feisheng;

    /**
     * 
     */
    private Integer fsudu;

    /**
     * 
     */
    private Integer qhcwWg;

    /**
     * 
     */
    private Integer qhcwFg;

    /**
     * 
     */
    private Integer cwXiangxing;

    /**
     * 
     */
    private Integer cwWuxue;

    /**
     * 
     */
    private String cwIcon;

    /**
     * 
     */
    private Integer cwXinfa;

    /**
     * 
     */
    private Integer cwQinmi;

    /**
     * 创建时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime addTime;

    /**
     * 更新时间
     */
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(String ownerid) {
        this.ownerid = ownerid;
    }

    /**
     * 
     */
    public String getPetid() {
        return petid;
    }

    public void setPetid(String petid) {
        this.petid = petid;
    }

    /**
     * 
     */
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     */
    public Integer getHorsetype() {
        return horsetype;
    }

    public void setHorsetype(Integer horsetype) {
        this.horsetype = horsetype;
    }

    /**
     * 
     */
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 
     */
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 
     */
    public Integer getLiliang() {
        return liliang;
    }

    public void setLiliang(Integer liliang) {
        this.liliang = liliang;
    }

    /**
     * 
     */
    public Integer getMinjie() {
        return minjie;
    }

    public void setMinjie(Integer minjie) {
        this.minjie = minjie;
    }

    /**
     * 
     */
    public Integer getLingli() {
        return lingli;
    }

    public void setLingli(Integer lingli) {
        this.lingli = lingli;
    }

    /**
     * 
     */
    public Integer getTili() {
        return tili;
    }

    public void setTili(Integer tili) {
        this.tili = tili;
    }

    /**
     * 
     */
    public Integer getDianhualx() {
        return dianhualx;
    }

    public void setDianhualx(Integer dianhualx) {
        this.dianhualx = dianhualx;
    }

    /**
     * 
     */
    public Integer getDianhuazd() {
        return dianhuazd;
    }

    public void setDianhuazd(Integer dianhuazd) {
        this.dianhuazd = dianhuazd;
    }

    /**
     * 
     */
    public Integer getDianhuazx() {
        return dianhuazx;
    }

    public void setDianhuazx(Integer dianhuazx) {
        this.dianhuazx = dianhuazx;
    }

    /**
     * 
     */
    public Integer getYuhualx() {
        return yuhualx;
    }

    public void setYuhualx(Integer yuhualx) {
        this.yuhualx = yuhualx;
    }

    /**
     * 
     */
    public Integer getYuhuazd() {
        return yuhuazd;
    }

    public void setYuhuazd(Integer yuhuazd) {
        this.yuhuazd = yuhuazd;
    }

    /**
     * 
     */
    public Integer getYuhuazx() {
        return yuhuazx;
    }

    public void setYuhuazx(Integer yuhuazx) {
        this.yuhuazx = yuhuazx;
    }

    /**
     * 
     */
    public Integer getCwjyzx() {
        return cwjyzx;
    }

    public void setCwjyzx(Integer cwjyzx) {
        this.cwjyzx = cwjyzx;
    }

    /**
     * 
     */
    public Integer getCwjyzd() {
        return cwjyzd;
    }

    public void setCwjyzd(Integer cwjyzd) {
        this.cwjyzd = cwjyzd;
    }

    /**
     * 
     */
    public Integer getFeisheng() {
        return feisheng;
    }

    public void setFeisheng(Integer feisheng) {
        this.feisheng = feisheng;
    }

    /**
     * 
     */
    public Integer getFsudu() {
        return fsudu;
    }

    public void setFsudu(Integer fsudu) {
        this.fsudu = fsudu;
    }

    /**
     * 
     */
    public Integer getQhcwWg() {
        return qhcwWg;
    }

    public void setQhcwWg(Integer qhcwWg) {
        this.qhcwWg = qhcwWg;
    }

    /**
     * 
     */
    public Integer getQhcwFg() {
        return qhcwFg;
    }

    public void setQhcwFg(Integer qhcwFg) {
        this.qhcwFg = qhcwFg;
    }

    /**
     * 
     */
    public Integer getCwXiangxing() {
        return cwXiangxing;
    }

    public void setCwXiangxing(Integer cwXiangxing) {
        this.cwXiangxing = cwXiangxing;
    }

    /**
     * 
     */
    public Integer getCwWuxue() {
        return cwWuxue;
    }

    public void setCwWuxue(Integer cwWuxue) {
        this.cwWuxue = cwWuxue;
    }

    /**
     * 
     */
    public String getCwIcon() {
        return cwIcon;
    }

    public void setCwIcon(String cwIcon) {
        this.cwIcon = cwIcon;
    }

    /**
     * 
     */
    public Integer getCwXinfa() {
        return cwXinfa;
    }

    public void setCwXinfa(Integer cwXinfa) {
        this.cwXinfa = cwXinfa;
    }

    /**
     * 
     */
    public Integer getCwQinmi() {
        return cwQinmi;
    }

    public void setCwQinmi(Integer cwQinmi) {
        this.cwQinmi = cwQinmi;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    /**
     * 更新时间
     */
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public void andLogicalDeleted(boolean deleted) {
        setDeleted(deleted ? Deleted.IS_DELETED.value() : Deleted.NOT_DELETED.value());
    }

    /**
     * 逻辑删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", IS_DELETED=").append(IS_DELETED);
        sb.append(", NOT_DELETED=").append(NOT_DELETED);
        sb.append(", id=").append(id);
        sb.append(", ownerid=").append(ownerid);
        sb.append(", petid=").append(petid);
        sb.append(", nickname=").append(nickname);
        sb.append(", name=").append(name);
        sb.append(", horsetype=").append(horsetype);
        sb.append(", type=").append(type);
        sb.append(", level=").append(level);
        sb.append(", liliang=").append(liliang);
        sb.append(", minjie=").append(minjie);
        sb.append(", lingli=").append(lingli);
        sb.append(", tili=").append(tili);
        sb.append(", dianhualx=").append(dianhualx);
        sb.append(", dianhuazd=").append(dianhuazd);
        sb.append(", dianhuazx=").append(dianhuazx);
        sb.append(", yuhualx=").append(yuhualx);
        sb.append(", yuhuazd=").append(yuhuazd);
        sb.append(", yuhuazx=").append(yuhuazx);
        sb.append(", cwjyzx=").append(cwjyzx);
        sb.append(", cwjyzd=").append(cwjyzd);
        sb.append(", feisheng=").append(feisheng);
        sb.append(", fsudu=").append(fsudu);
        sb.append(", qhcwWg=").append(qhcwWg);
        sb.append(", qhcwFg=").append(qhcwFg);
        sb.append(", cwXiangxing=").append(cwXiangxing);
        sb.append(", cwWuxue=").append(cwWuxue);
        sb.append(", cwIcon=").append(cwIcon);
        sb.append(", cwXinfa=").append(cwXinfa);
        sb.append(", cwQinmi=").append(cwQinmi);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleted=").append(deleted);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Pets other = (Pets) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOwnerid() == null ? other.getOwnerid() == null : this.getOwnerid().equals(other.getOwnerid()))
            && (this.getPetid() == null ? other.getPetid() == null : this.getPetid().equals(other.getPetid()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getHorsetype() == null ? other.getHorsetype() == null : this.getHorsetype().equals(other.getHorsetype()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getLiliang() == null ? other.getLiliang() == null : this.getLiliang().equals(other.getLiliang()))
            && (this.getMinjie() == null ? other.getMinjie() == null : this.getMinjie().equals(other.getMinjie()))
            && (this.getLingli() == null ? other.getLingli() == null : this.getLingli().equals(other.getLingli()))
            && (this.getTili() == null ? other.getTili() == null : this.getTili().equals(other.getTili()))
            && (this.getDianhualx() == null ? other.getDianhualx() == null : this.getDianhualx().equals(other.getDianhualx()))
            && (this.getDianhuazd() == null ? other.getDianhuazd() == null : this.getDianhuazd().equals(other.getDianhuazd()))
            && (this.getDianhuazx() == null ? other.getDianhuazx() == null : this.getDianhuazx().equals(other.getDianhuazx()))
            && (this.getYuhualx() == null ? other.getYuhualx() == null : this.getYuhualx().equals(other.getYuhualx()))
            && (this.getYuhuazd() == null ? other.getYuhuazd() == null : this.getYuhuazd().equals(other.getYuhuazd()))
            && (this.getYuhuazx() == null ? other.getYuhuazx() == null : this.getYuhuazx().equals(other.getYuhuazx()))
            && (this.getCwjyzx() == null ? other.getCwjyzx() == null : this.getCwjyzx().equals(other.getCwjyzx()))
            && (this.getCwjyzd() == null ? other.getCwjyzd() == null : this.getCwjyzd().equals(other.getCwjyzd()))
            && (this.getFeisheng() == null ? other.getFeisheng() == null : this.getFeisheng().equals(other.getFeisheng()))
            && (this.getFsudu() == null ? other.getFsudu() == null : this.getFsudu().equals(other.getFsudu()))
            && (this.getQhcwWg() == null ? other.getQhcwWg() == null : this.getQhcwWg().equals(other.getQhcwWg()))
            && (this.getQhcwFg() == null ? other.getQhcwFg() == null : this.getQhcwFg().equals(other.getQhcwFg()))
            && (this.getCwXiangxing() == null ? other.getCwXiangxing() == null : this.getCwXiangxing().equals(other.getCwXiangxing()))
            && (this.getCwWuxue() == null ? other.getCwWuxue() == null : this.getCwWuxue().equals(other.getCwWuxue()))
            && (this.getCwIcon() == null ? other.getCwIcon() == null : this.getCwIcon().equals(other.getCwIcon()))
            && (this.getCwXinfa() == null ? other.getCwXinfa() == null : this.getCwXinfa().equals(other.getCwXinfa()))
            && (this.getCwQinmi() == null ? other.getCwQinmi() == null : this.getCwQinmi().equals(other.getCwQinmi()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOwnerid() == null) ? 0 : getOwnerid().hashCode());
        result = prime * result + ((getPetid() == null) ? 0 : getPetid().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getHorsetype() == null) ? 0 : getHorsetype().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getLiliang() == null) ? 0 : getLiliang().hashCode());
        result = prime * result + ((getMinjie() == null) ? 0 : getMinjie().hashCode());
        result = prime * result + ((getLingli() == null) ? 0 : getLingli().hashCode());
        result = prime * result + ((getTili() == null) ? 0 : getTili().hashCode());
        result = prime * result + ((getDianhualx() == null) ? 0 : getDianhualx().hashCode());
        result = prime * result + ((getDianhuazd() == null) ? 0 : getDianhuazd().hashCode());
        result = prime * result + ((getDianhuazx() == null) ? 0 : getDianhuazx().hashCode());
        result = prime * result + ((getYuhualx() == null) ? 0 : getYuhualx().hashCode());
        result = prime * result + ((getYuhuazd() == null) ? 0 : getYuhuazd().hashCode());
        result = prime * result + ((getYuhuazx() == null) ? 0 : getYuhuazx().hashCode());
        result = prime * result + ((getCwjyzx() == null) ? 0 : getCwjyzx().hashCode());
        result = prime * result + ((getCwjyzd() == null) ? 0 : getCwjyzd().hashCode());
        result = prime * result + ((getFeisheng() == null) ? 0 : getFeisheng().hashCode());
        result = prime * result + ((getFsudu() == null) ? 0 : getFsudu().hashCode());
        result = prime * result + ((getQhcwWg() == null) ? 0 : getQhcwWg().hashCode());
        result = prime * result + ((getQhcwFg() == null) ? 0 : getQhcwFg().hashCode());
        result = prime * result + ((getCwXiangxing() == null) ? 0 : getCwXiangxing().hashCode());
        result = prime * result + ((getCwWuxue() == null) ? 0 : getCwWuxue().hashCode());
        result = prime * result + ((getCwIcon() == null) ? 0 : getCwIcon().hashCode());
        result = prime * result + ((getCwXinfa() == null) ? 0 : getCwXinfa().hashCode());
        result = prime * result + ((getCwQinmi() == null) ? 0 : getCwQinmi().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pets
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    @Override
    public Pets clone() throws CloneNotSupportedException {
        return (Pets) super.clone();
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table pets
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Deleted {
        NOT_DELETED(new Boolean("0"), "未删除"),
        IS_DELETED(new Boolean("1"), "已删除");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final Boolean value;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String name;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Deleted(Boolean value, String name) {
            this.value = value;
            this.name = name;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Boolean getValue() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public Boolean value() {
            return this.value;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getName() {
            return this.name;
        }
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table pets
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        ownerid("ownerid", "ownerid", "VARCHAR", false),
        petid("petid", "petid", "VARCHAR", false),
        nickname("nickname", "nickname", "VARCHAR", false),
        name("name", "name", "VARCHAR", true),
        horsetype("horsetype", "horsetype", "INTEGER", false),
        type("type", "type", "INTEGER", true),
        level("level", "level", "INTEGER", true),
        liliang("liliang", "liliang", "INTEGER", false),
        minjie("minjie", "minjie", "INTEGER", false),
        lingli("lingli", "lingli", "INTEGER", false),
        tili("tili", "tili", "INTEGER", false),
        dianhualx("dianhualx", "dianhualx", "INTEGER", false),
        dianhuazd("dianhuazd", "dianhuazd", "INTEGER", false),
        dianhuazx("dianhuazx", "dianhuazx", "INTEGER", false),
        yuhualx("yuhualx", "yuhualx", "INTEGER", false),
        yuhuazd("yuhuazd", "yuhuazd", "INTEGER", false),
        yuhuazx("yuhuazx", "yuhuazx", "INTEGER", false),
        cwjyzx("cwjyzx", "cwjyzx", "INTEGER", false),
        cwjyzd("cwjyzd", "cwjyzd", "INTEGER", false),
        feisheng("feisheng", "feisheng", "INTEGER", false),
        fsudu("fsudu", "fsudu", "INTEGER", false),
        qhcwWg("qhcw_wg", "qhcwWg", "INTEGER", false),
        qhcwFg("qhcw_fg", "qhcwFg", "INTEGER", false),
        cwXiangxing("cw_xiangxing", "cwXiangxing", "INTEGER", false),
        cwWuxue("cw_wuxue", "cwWuxue", "INTEGER", false),
        cwIcon("cw_icon", "cwIcon", "VARCHAR", false),
        cwXinfa("cw_xinfa", "cwXinfa", "INTEGER", false),
        cwQinmi("cw_qinmi", "cwQinmi", "INTEGER", false),
        addTime("add_time", "addTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false),
        deleted("deleted", "deleted", "BIT", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table pets
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}