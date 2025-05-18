package com.Tilldawn.model;

import com.Tilldawn.model.Enums.Avatars;

public class User {
    private String Useranme;
    private String Password;
    private String SequrityQuestion;
    private Avatars avatar;
    private int point = 0;
    private int Kill = 0;
    private int MostTimeAlive;
    public User(String useranme, String password , String sequrityQuestion) {
        Useranme = useranme;
        Password = password;
        SequrityQuestion = sequrityQuestion;
    }

    public String getUseranme() {
        return Useranme;
    }

    public void setUseranme(String useranme) {
        Useranme = useranme;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getSequrityQuestion() {
        return SequrityQuestion;
    }

    public void setSequrityQuestion(String sequrityQuestion) {
        SequrityQuestion = sequrityQuestion;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Avatars getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatars avatar) {
        this.avatar = avatar;
    }
}
