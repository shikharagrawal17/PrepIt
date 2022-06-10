package com.example.rppoop.model1;

public class User {
    private String id;
    private String username;
    private String ProfilePic;


    public User(String ProfilePic, String id, String username) {
        this.id = id;
        this.username = username;
        this.ProfilePic = ProfilePic;
    }

    public User(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfilePic() {
        return ProfilePic;
    }

    public void setProfilePic(String ProfilePic) {
        this.ProfilePic = ProfilePic;
    }
}

