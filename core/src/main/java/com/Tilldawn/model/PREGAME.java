package com.Tilldawn.model;

public class PREGAME {
    private float Voulume = 50;
    Boolean SFX = false;
    boolean AutoReload = false;

    public float getVoulume() {
        return Voulume;
    }

    public void setVoulume(float voulume) {
        Voulume = voulume;
    }

    public Boolean getSFX() {
        return SFX;
    }

    public void setSFX(Boolean SFX) {
        this.SFX = SFX;
    }

    public boolean isAutoReload() {
        return AutoReload;
    }

    public void setAutoReload(boolean autoReload) {
        AutoReload = autoReload;
    }
}
