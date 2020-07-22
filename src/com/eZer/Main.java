package com.eZer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        MobilePhone m1 = new MobilePhone(12000,"SAMSUNG","touch");
        MobilePhone m2 = new MobilePhone(15000,"SAMSUNG A6","keypad");

        Laptop l1  = new Laptop(500000,"Helios 300");

        Camera camera = new Camera(250000,"Canon-G7","x100000/2");

        ArrayList<Element> elements = new ArrayList<>();
        elements.add(m1);
        elements.add(m2);
        elements.add(l1);
        elements.add(camera);

        Shop s =new Shop();

        double total=0;


        for (Element  e :elements ) {
            total+= e.accept(s);
        }

        System.out.println(total);

    }
}

interface Element{
    public double accept(Visitor visitor);
}

interface Visitor{
   public double visit(Laptop laptop);
   public double visit(MobilePhone mobilePhone);
   public double visit(Camera camera);
}

class Laptop implements Element{

    private double price;
    private String model;

    public Laptop(double price, String model) {
        this.price = price;
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class MobilePhone implements Element{

    private double price;
    private String model;
    private String type;

    public MobilePhone(double price, String model, String type) {
        this.price = price;
        this.model = model;
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class Camera implements Element{

    private double price;
    private String model;
    private String lense;

    public Camera(double price, String model, String lense) {
        this.price = price;
        this.model = model;
        this.lense = lense;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLense() {
        return lense;
    }

    public void setLense(String lense) {
        this.lense = lense;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

class Shop implements Visitor{

    @Override
    public double visit(Laptop laptop) {
        return laptop.getPrice();
    }

    @Override
    public double visit(MobilePhone mobilePhone) {
        double price =mobilePhone.getPrice();
        if(mobilePhone.getType().equals("touch")){
            price +=10000;
        }
        return price;
    }

    @Override
    public double visit(Camera camera) {
        double price = camera.getPrice();
        if(price>5000){
            price-=500;
        }
        return price;
    }
}
