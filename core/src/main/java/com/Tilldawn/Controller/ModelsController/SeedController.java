package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.model.Seed;

public class SeedController {
    public void update(Seed seed , float DElta)
    {
        Droping(seed , DElta);
        seed.getSprite().setX(seed.getXpos());
        seed.getSprite().setY(seed.getYpos());
        seed.getSprite().draw(Main.getBatch());
    }


    public void Droping(Seed seed, float DElta)
    {
        //seed.setXpos(seed.getXpos() + DElta);
        seed.setYpos(seed.getYpos() - DElta * 40f);
        seed.getCollision().setY(seed.getYpos());
    }

}
