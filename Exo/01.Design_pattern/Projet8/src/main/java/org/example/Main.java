package org.example;

public class Main {
    public static void main(String[] args) {
        Employee employe1 = new Employe("Titi1");
        Employee employe2 = new Employe("Titi2");
        Employee employe3 = new Employe("Titi3");
        Employee employe4 = new Employe("Titi4");
        Employee employe5 = new Employe("Titi5");

        Employee manager1 = new Manager("Toto1");
        Employee manager2 = new Manager("Toto2");
        Employee manager3 = new Manager("Toto3");
        Employee manager4 = new Manager("Toto4");
        Employee manager5 = new Manager("Toto5");

        manager1.addSubordonne(manager2);
        manager1.addSubordonne(manager3);
        manager1.addSubordonne(manager4);

        manager2.addSubordonne(manager5);

        manager5.addSubordonne(employe1);
        employe1.addSubordonne(employe2);
        employe1.addSubordonne(employe3);
        employe1.addSubordonne(employe4);

        manager3.addSubordonne(employe5);
        manager4.addSubordonne(employe1);

        manager1.showDetails();

        employe1.showDetails();
    }
}