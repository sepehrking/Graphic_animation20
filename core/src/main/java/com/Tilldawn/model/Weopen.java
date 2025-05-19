package com.Tilldawn.model;

import com.Tilldawn.model.Enums.Weopens;

public class Weopen {
    private Weopens Weopen;
    private int Amoo;
    private float Timeinreload = 1;
    private float TimeinShotting = 1;
    private int DamageDamage;
    private int TileCovers;
    private int MAXAMO;

    public int getMAXAMO() {
        return MAXAMO;
    }

    public void setMAXAMO(int MAXAMO) {
        this.MAXAMO = MAXAMO;
    }

    public int getDamageDamage() {
        return DamageDamage;
    }

    public void setDamageDamage(int damageDamage) {
        DamageDamage = damageDamage;
    }

    public int getTileCovers() {
        return TileCovers;
    }

    public void setTileCovers(int tileCovers) {
        TileCovers = tileCovers;
    }

    public float getTimeinShotting() {
        return TimeinShotting;
    }

    public void setTimeinShotting(float timeinShotting) {
        TimeinShotting = timeinShotting;
    }

    public void updateWeopenTime(float Delta)
    {
        Timeinreload += Delta;
        TimeinShotting += Delta;
    }

    public Weopen() {
        Weopen = App.ReturnCurrentGame().getWeopen();
        Amoo = Weopen.AmmoMAx;
        TileCovers =Weopen.Projectile;
        DamageDamage = Weopen.Damage;
        MAXAMO = Weopen.AmmoMAx;
    }

    public Weopens getWeopen() {
        return Weopen;
    }

    public void setWeopen(Weopens weopen) {
        Weopen = weopen;
    }

    public int getAmoo() {
        return Amoo;
    }

    public void setAmoo(int amoo) {
        Amoo = amoo;
    }

    public float getTimeinreload() {
        return Timeinreload;
    }

    public void setTimeinreload(float timeinreload) {
        Timeinreload = timeinreload;
    }
}
