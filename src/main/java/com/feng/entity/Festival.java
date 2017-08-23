package com.feng.entity;

public class Festival {
    private Integer festivalId;

    private String festivalName;

    private String festivalDateNew;

    private String festivalDateLunar;

    private String neckName;

    private String destivalStroy;

    public Festival(Integer festivalId, String festivalName, String festivalDateNew, String festivalDateLunar, String neckName, String destivalStroy) {
        this.festivalId = festivalId;
        this.festivalName = festivalName;
        this.festivalDateNew = festivalDateNew;
        this.festivalDateLunar = festivalDateLunar;
        this.neckName = neckName;
        this.destivalStroy = destivalStroy;
    }

    public Festival() {
        super();
    }

    public Integer getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(Integer festivalId) {
        this.festivalId = festivalId;
    }

    public String getFestivalName() {
        return festivalName;
    }

    public void setFestivalName(String festivalName) {
        this.festivalName = festivalName == null ? null : festivalName.trim();
    }

    public String getFestivalDateNew() {
        return festivalDateNew;
    }

    public void setFestivalDateNew(String festivalDateNew) {
        this.festivalDateNew = festivalDateNew == null ? null : festivalDateNew.trim();
    }

    public String getFestivalDateLunar() {
        return festivalDateLunar;
    }

    public void setFestivalDateLunar(String festivalDateLunar) {
        this.festivalDateLunar = festivalDateLunar == null ? null : festivalDateLunar.trim();
    }

    public String getNeckName() {
        return neckName;
    }

    public void setNeckName(String neckName) {
        this.neckName = neckName == null ? null : neckName.trim();
    }

    public String getDestivalStroy() {
        return destivalStroy;
    }

    public void setDestivalStroy(String destivalStroy) {
        this.destivalStroy = destivalStroy == null ? null : destivalStroy.trim();
    }
}