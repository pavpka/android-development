package com.example.myapplication.pojo;

import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private final String src;

    public ItemList(String src) {
        this.src = src;
    }

    public String getImageSrc() {
        return src;
    }

    public static List<ItemList> generateImages() {
        List<ItemList> images = new ArrayList<>();
        System.out.println("generate");
        images.add(new ItemList("https://i.imgur.com/2KxoIsa.jpg"));
        images.add(new ItemList("https://i.imgur.com/EZHXbA0.jpg"));
        images.add(new ItemList("https://i.imgur.com/qb7Ev7A.jpg"));
        images.add(new ItemList("https://i.imgur.com/ZtXXAwX.jpg"));
        images.add(new ItemList("https://i.imgur.com/lrE9vha.jpg"));
        images.add(new ItemList("https://i.imgur.com/S66rx9n.jpg"));
        images.add(new ItemList("https://i.imgur.com/KaSkWef.jpg"));
        images.add(new ItemList("https://i.imgur.com/jp5z1s0.jpg"));
        images.add(new ItemList("https://i.imgur.com/iLNrl9Z.jpg"));
        images.add(new ItemList("https://i.imgur.com/Z3ei74h.jpg"));
        images.add(new ItemList("https://i.imgur.com/uXbb81d.jpg"));
        images.add(new ItemList("https://i.imgur.com/92mT0BB.jpg"));

        return images;
    }
}
