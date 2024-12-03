package Projet;

public class User {
    
    String name;
    String tel;

    public User(String newName, String newTel){
        this.name = newName;
        this.tel = newTel;
    }


    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getTel(){
        return this.tel;
    }

    public void setTel(String newTel){
        this.tel = newTel;
    }



    public String toString(){
        return "Name : " + this.name + ", tel : " + this.tel;
    }
}

