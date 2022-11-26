package com.example.myapplication;

public class Reward {
    private String name;
    private String info;
    private int foto;

    public Reward(String name, String info, int foto) {
        this.name = name;
        this.info = info;
        this.foto = foto;
    }
    public Reward(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
