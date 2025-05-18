package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.model.Bullet;

public class BulletController {
    public void Update(Bullet bullet , float Delta)
    {
        bullet.getSprite().setPosition(bullet.getPosx(), bullet.getPosy());
        bullet.getSprite().draw(Main.getBatch());
        HandlePosition(bullet , Delta);
    }

    public void HandlePosition(Bullet bullet , Float Delta)
    {
        bullet.setPosx(bullet.getPosx() + bullet.getXd() * Delta * 100f) ;
        bullet.setPosy(bullet.getPosy() + bullet.getYd() * Delta * 100f) ;
    }

}
