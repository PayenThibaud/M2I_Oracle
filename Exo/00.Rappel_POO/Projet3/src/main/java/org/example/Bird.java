package org.example;

public final class Bird extends Animal{

    private boolean isFlying;

    public Bird(int id, String name, String species, boolean isFlying) {
        super(id, name, species);
        this.isFlying = isFlying;
    }

    @Override
    public String getDetails() {
        return "Bird " + id + " { name : " + name + ", species : " + species + ", isFlying : " + isFlying + " }";
    }

    @Override
    public void eat() {
        System.out.println(name + " mange des graines");
    }
}
