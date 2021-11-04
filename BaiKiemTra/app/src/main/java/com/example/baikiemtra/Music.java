package com.example.baikiemtra;

import java.io.Serializable;

public class Music   {
    private String id;
    private String name;
    private int r;

    public Music() {
    }

    public Music(String id, String name, int r) {
        this.id = id;
        this.name = name;
        this.r = r;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
