package com.Tilldawn.model;

public class KeyboradController {
    private char up = 'W';
    private char rightl = 'D';
    private char leftl = 'A';
    private char down = 'S';
    private char reload =  'R';

    public char getUp() {
        return up;
    }

    public void setUp(char up) {
        this.up = up;
    }

    public char getReload() {
        return reload;
    }

    public void setReload(char reload) {
        this.reload = reload;
    }

    public char getDown() {
        return down;
    }

    public void setDown(char down) {
        this.down = down;
    }

    public char getLeftl() {
        return leftl;
    }

    public void setLeftl(char leftl) {
        this.leftl = leftl;
    }

    public char getRightl() {
        return rightl;
    }

    public void setRightl(char rightl) {
        this.rightl = rightl;
    }
}
