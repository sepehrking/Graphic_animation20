package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.Bullet;
import com.Tilldawn.model.EyeBat;
import com.Tilldawn.model.TentacleMonster;
import com.badlogic.gdx.Gdx;

public class EyeController {

    public void CreateEyeBatMonster()
    {
        EyeBat monster = new EyeBat();
        int RandX = App.rand.nextInt() % Gdx.graphics.getWidth() * 2;
        int Randy = App.rand.nextInt() % Gdx.graphics.getHeight() * 2;
        RandX -= Gdx.graphics.getWidth() / 2;
        Randy -= Gdx.graphics.getHeight() / 2;
        monster.setXPos(RandX);
        monster.setYPos(Randy);
        App.ReturnCurrentGame().getEnemies().add(monster);
    }

    public void Update(EyeBat monster , float Delta)
    {
        monster.getCollisionREcatangle().setX(monster.getXPos());
        monster.getCollisionREcatangle().setY(monster.getYPos());
        monster.getEnemySprite().setPosition(monster.getXPos() , monster.getYPos());
        monster.getEnemySprite().draw(Main.getBatch());
        HandleWalkNearCharacter(monster , Delta);
        HandleShooting(monster , Delta);
    }


    public void HandleWalkNearCharacter(EyeBat monster , float Delta)
    {
        int V = 0 , H = 0;
        float Min = App.Difreence(App.ReturnCurrentGame().getPlayer().getPosX() , App.ReturnCurrentGame().getPlayer().getPosY() , monster.getXPos() , monster.getYPos());
        for(int i = -1 ; i <= 1 ;i++) {
            for (int j = -1; j <= 1; j++) {
                if (App.Difreence(App.ReturnCurrentGame().getPlayer().getPosX(), App.ReturnCurrentGame().getPlayer().getPosY(), monster.getXPos() + i, monster.getYPos() + j) < Min) {
                    V = i;
                    H = j;
                    Min = App.Difreence(App.ReturnCurrentGame().getPlayer().getPosX(), App.ReturnCurrentGame().getPlayer().getPosY(), monster.getXPos() + i, monster.getYPos() + j);
                }
            }
        }
        monster.setXPos(monster.getXPos() + V * Delta * 100f);
        monster.setYPos(monster.getYPos() + H * Delta * 100f);
    }

    public void HandleShooting(EyeBat monster , float Delta)
    {
        monster.setShootingTime(monster.getShootingTime() + Delta);
        if(monster.getShootingTime() > 6)
        {
            Bullet newbullet = new Bullet(monster.getXPos() , monster.getYPos());
            float XD = App.ReturnCurrentGame().getPlayer().getPosX() - monster.getXPos();
            float YD = App.ReturnCurrentGame().getPlayer().getPosY() - monster.getYPos();
            float NORM = (XD * XD) + (YD * YD);
            newbullet.setXd(XD / NORM);
            newbullet.setYd(YD / NORM * -1);
            App.ReturnCurrentGame().getEnemyBullets().add(newbullet);
            monster.setShootingTime(0);
        }
    }
}
