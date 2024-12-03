package Projet;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    
    List<User> users = new ArrayList<>();


    public void addUser(User newUser){
        users.add(newUser);
    }

    public String getAllUser(){
        String allUser = "";

        for (User user : users) {
            allUser += user.toString() + "\n";
        }
        return allUser;
    }

    public String GetUserByName(String name){
        String userWithSameName =  "";

        for (User user : users) {
            if (user.getName().equals(name)){
                userWithSameName += user.toString() + "\n";
            }
        }
        return userWithSameName;
    }
}

