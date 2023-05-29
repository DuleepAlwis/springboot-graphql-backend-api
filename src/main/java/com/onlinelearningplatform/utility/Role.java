package com.onlinelearningplatform.utility;

public enum Role {


        ADMIN("ADMIN"), STUDENT("STUDENT"), TUTOR("TUTOR");
        String role;

     Role(String role){
        this.role = role;
    }

    public String getRole(){
         return this.role;
    }

}
