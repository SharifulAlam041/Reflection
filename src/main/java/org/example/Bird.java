package org.example;

public class Bird {
    public String breed;
    private boolean canSwim;
    public void fly() {
        System.out.println("Fly");
    }
    private void eat() {
        System.out.println("Eat");
    }

    public int swim(int intParam, boolean boolParam, String strParam){
        System.out.println("Swim intParam " + intParam + ", boolParam " + boolParam + ", strParam " + strParam +",");
        return 0;
    }
}
