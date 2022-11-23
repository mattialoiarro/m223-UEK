package ch.zli.m223.model;

import io.smallrye.common.constraint.NotNull;

public class Auth {
    
    @NotNull
    String email;

    @NotNull
    String password;


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    

}
