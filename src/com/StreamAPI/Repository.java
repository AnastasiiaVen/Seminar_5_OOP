package com.StreamAPI;

import java.util.ArrayList;
import java.util.List;

public class Repository<T extends Content> {

    List<T> ds;

    private String name;

    public Repository(String name) {
        this.ds = new ArrayList<>();
        this.name = name;
    }

    public void addContent(T content){
        ds.add(content);
    }

    public void showRep(){
        for (T it : this.ds){
            System.out.println(it);
        }
    }
}
