package com.example.manara.capstone_stage2;

import android.util.DisplayMetrics;

public class Users {

    String name;
    String password;

   public Users()
   {

   }
    public Users(String name,String password)
    {
        this.name=name;
        this.password=password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
