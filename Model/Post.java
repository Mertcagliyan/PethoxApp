package com.mertcagliyan.pethox2.Model;

public class Post {
    public String comment;
    public String downloadUrl;
    public String profilePhoto;
    public String userName;

    public Post(String str, String str2, String str3, String str4) {
        this.comment = str;
        this.downloadUrl = str2;
        this.userName = str3;
        this.profilePhoto = str4;
    }
}
