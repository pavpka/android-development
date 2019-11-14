package com.example.lab5.pojo;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private final String srcImg;
    private final String location;
    private final String date;

    public ItemList(String srcImg, String location, String date) {
        this.srcImg = srcImg;
        this.location = location;
        this.date = date;
    }

    public String getImageSrc() {
        return srcImg;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public static List<ItemList> initCards() {
        List<ItemList> cards = new ArrayList<>();
        cards.add(new ItemList("https://i.imgur.com/2KxoIsa.jpg", "Saint-Petersburg", "21.03.2017"));
        cards.add(new ItemList("https://i.imgur.com/EZHXbA0.jpg", "Prague", "03.05.2019"));
        cards.add(new ItemList("https://i.imgur.com/qb7Ev7A.jpg", "Moscow", "12.07.2018"));
        cards.add(new ItemList("https://i.imgur.com/ZtXXAwX.jpg", "Saint-Petersburg", "01.10.2015"));
        cards.add(new ItemList("https://i.imgur.com/lrE9vha.jpg", "Barcelona", "23.12.2017"));
        cards.add(new ItemList("https://i.imgur.com/S66rx9n.jpg", "Moscow", "15.04.2019"));
        cards.add(new ItemList("https://i.imgur.com/KaSkWef.jpg", "Saint-Petersburg", "31.01.2016"));
        cards.add(new ItemList("https://i.imgur.com/jp5z1s0.jpg", "Moscow", "16.06.2017"));
        cards.add(new ItemList("https://i.imgur.com/iLNrl9Z.jpg", "Paris", "28.04.2018"));
        cards.add(new ItemList("https://i.imgur.com/Z3ei74h.jpg", "Prague", "13.09.2019"));
        cards.add(new ItemList("https://i.imgur.com/uXbb81d.jpg", "Moscow", "22.03.2016"));
        cards.add(new ItemList("https://i.imgur.com/92mT0BB.jpg", "Saint-Petersburg", "17.11.2011"));

        return cards;
    }
}
