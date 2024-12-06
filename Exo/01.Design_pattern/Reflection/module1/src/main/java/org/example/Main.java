package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Class<?> personClass = Class.forName("org.example.Person");

            System.out.println(personClass.getName());
            System.out.println(personClass.getSimpleName());
            System.out.println(personClass.getPackage());

            for(Field field : personClass.getDeclaredFields()) {
                System.out.println(field.getName()  + " : " + field.getType());
            }

            for(Method method : personClass.getDeclaredMethods()) {
                System.out.println(method.getName()  + " : " + method.getReturnType());
            }

            Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            Object person = constructor.newInstance("John", 1);
            System.out.println(person);

            Method sayHello = personClass.getDeclaredMethod("sayHello");
            sayHello.setAccessible(true);
            sayHello.invoke(person);

            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true);
            nameField.set(person, "Toto");
            System.out.println(nameField.get(person));
            sayHello.invoke(person);



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}