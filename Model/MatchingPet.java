package com.mertcagliyan.pethox2.Model;

public class MatchingPet {
    public String downloadUrl;
    public String gender;
    public String petAge;
    public String petName;
    public String petSpecie;
    public String profilePhoto;
    public String userName;

    public MatchingPet(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.userName = str;
        this.petAge = str2;
        this.petName = str3;
        this.petSpecie = str4;
        this.gender = str5;
        this.profilePhoto = str6;
        this.downloadUrl = str7;
    }
}
