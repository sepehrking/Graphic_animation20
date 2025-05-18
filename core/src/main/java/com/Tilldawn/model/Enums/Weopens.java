package com.Tilldawn.model.Enums;

public enum Weopens {
    SMG("Weopens/SMGStill.png" , 8 , 1 , 2 , 24),
    ShotGun("Weopens/T_Shotgun_SS_0.png" , 10 , 4 , 1 , 2),
    Revolver("Weopens/RevolverStill.png" , 20 , 1 , 1 , 5);
    public final String Addres;
    public final int Damage;
    public final int Projectile;
    public final int TimeREload;
    public final int AmmoMAx;
    Weopens(String addres, int damage, int projectile, int timeREload, int ammoMAx) {
        Addres = addres;
        Damage = damage;
        Projectile = projectile;
        TimeREload = timeREload;
        AmmoMAx = ammoMAx;
    }
}
