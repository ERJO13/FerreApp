package com.example.ferreapp;

public class modelerApp {

    /*Step 1: Variables*/
    private String name;
    private  int thumbnail;

    /*Step 1: Constructors*/

    public modelerApp(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public modelerApp(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
