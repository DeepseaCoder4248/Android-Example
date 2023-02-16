package com.example.jsongson;

public class ItemData {

    String name;
    int num;


    public ItemData() {
    }

    public ItemData(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String setData() {
        String a = name;
        String b = String.valueOf(num);
        String result = "name:" + name + "\r"
                + "age:" + num;
        return result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
