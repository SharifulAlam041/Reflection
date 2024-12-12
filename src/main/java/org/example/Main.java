package org.example;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class birdClass = Bird.class;//accessing class with reflection type 1
        Bird bird = new Bird();
        Class birdClass2 = bird.getClass();//accessing class with reflection type 1
        Class birdClass3 = Class.forName("org.example.Bird");//accessing class with reflection type 1
        System.out.println(birdClass.getName());
        System.out.println(Modifier.toString(birdClass.getModifiers()));
        System.out.println("--------------------------------------");

        System.out.println(birdClass2.getName());
        System.out.println(Modifier.toString(birdClass2.getModifiers()));
        System.out.println("--------------------------------------");

        System.out.println(birdClass3.getName());
        System.out.println(Modifier.toString(birdClass3.getModifiers()));
        System.out.println("--------------------------------------");

        Method[] methods = birdClass.getMethods();
        for (Method method: methods) {
            System.out.println(method.getName());
            System.out.println(method.getModifiers());
            System.out.println(method.getReturnType());
            System.out.println(method.getDeclaringClass());
            System.out.println("------------------***--------------------");
        }
        Method[] methodss = birdClass.getDeclaredMethods();
        for (Method method: methodss) {
            System.out.println(method.getName());
            System.out.println(method.getModifiers());
            System.out.println(method.getReturnType());
            System.out.println(method.getDeclaringClass());
            System.out.println("------------------***--------------------");
        }

        Object birdObj = birdClass.newInstance();
        Method swimMethod = birdClass.getMethod("swim",int.class,boolean.class,String.class);
        swimMethod.invoke(birdObj,100,true,"swim");

        Field[] fields = birdClass.getFields();
        for (Field field: fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println("------------------***--------------------");
        }

        Field[] fieldss = birdClass.getDeclaredFields();
        for (Field field: fieldss) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println(Modifier.toString(field.getModifiers()));
            System.out.println("------------------***--------------------");
        }
        Field field = birdClass.getField("breed");
        field.set(bird,"brownBirdBreed");
        System.out.println(bird.breed);
        Field field2 = birdClass.getDeclaredField("canSwim");
        field2.setAccessible(true);
        field2.set(bird,true);
        if(field2.getBoolean(bird)) {
            System.out.println("value is set true");
        }

        Class eagleClass = Eagle.class;
        Constructor[] constructors = eagleClass.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.println(constructor.getName());
            System.out.println(Modifier.toString(constructor.getModifiers()));
            constructor.setAccessible(true);
            Eagle eagleObject = (Eagle)constructor.newInstance();
            eagleObject.fly();
        }


    }
}