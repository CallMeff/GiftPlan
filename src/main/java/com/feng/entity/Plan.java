package com.feng.entity;

public class Plan {
    private Long planId;

    private Long festivalId;

    private String name;

    private String description;

    private String pictureUrl;

    public Plan(Long planId, Long festivalId, String name, String description, String pictureUrl) {
        this.planId = planId;
        this.festivalId = festivalId;
        this.name = name;
        this.description = description;
        this.pictureUrl = pictureUrl;
    }

    public Plan() {
        super();
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(Long festivalId) {
        this.festivalId = festivalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }
}