package com.marcin.cardssql;

public class Card {
    private long id;
    private String name;
    private int color_resources;
    private int listPosition = 0;

    public Card() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor_resources() {
        return color_resources;
    }

    public void setColor_resources(int color_resources) {
        this.color_resources = color_resources;
    }

    public int getListPosition() {
        return listPosition;
    }

    public void setListPosition(int listPosition) {
        this.listPosition = listPosition;
    }
}
