package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.View.DestroyedAnimation;
import com.Tilldawn.model.*;
import com.badlogic.gdx.Gdx;

public class BulletController {
    public void Update(Bullet bullet , float Delta , boolean Enemy)
    {
        bullet.getCollision().setX(bullet.getPosx());
        bullet.getCollision().setY(bullet.getPosy());
        bullet.getSprite().setPosition(bullet.getPosx(), bullet.getPosy());
        bullet.getSprite().draw(Main.getBatch());
        if(!Enemy) {
            HandlePosition(bullet, Delta);
        }
        else
        {
            HandleEnemyBullets(bullet, Delta);
        }
    }

    public void HandlePosition(Bullet bullet , Float Delta)
    {
        bullet.setPosx(bullet.getPosx() + bullet.getXd() * Delta * 100000f) ;
        bullet.setPosy(bullet.getPosy() - bullet.getYd() * Delta * 100000f) ;
        CollideEnemies();
    }

    public void HandleEnemyBullets(Bullet bullet , Float Delta)
    {
        bullet.setPosx(bullet.getPosx() + bullet.getXd() * Delta * 100000f) ;
        bullet.setPosy(bullet.getPosy() - bullet.getYd() * Delta * 100000f) ;
        if(bullet.getCollision().IsCollide(App.ReturnCurrentGame().getPlayer().getCol()))
        {
            App.ReturnCurrentGame().getPlayer().setHp(App.ReturnCurrentGame().getPlayer().getHp()  - 1);
            App.ReturnCurrentGame().getEnemyBullets().remove(bullet);
        }
    }


    public void CollideEnemies()
    {
        for(int i = App.ReturnCurrentGame().getBullets().size()-1;i>=0;i--) {
            for (int j = App.ReturnCurrentGame().getEnemies().size()-1;j>=0;j--) {
                if (!(App.ReturnCurrentGame().getEnemies().get(j) instanceof TREE)) {
                    if (App.ReturnCurrentGame().getBullets().get(i).getCollision().IsCollide(App.ReturnCurrentGame().getEnemies().get(j).getCollisionREcatangle()))
                    {
                        //Gdx.app.exit();
                        if(App.ReturnCurrentGame().getEnemies().get(j).getTimeDamaged() > 1) {
                            App.ReturnCurrentGame().getEnemies().get(j).setHp(App.ReturnCurrentGame().getEnemies().get(j).getHp() - App.ReturnCurrentGame().getPlayer().getWeopenC().getDamageDamage());
                            App.ReturnCurrentGame().getEnemies().get(j).setTimeDamaged(0);
                        }
                        if(App.ReturnCurrentGame().getEnemies().get(j).getHp() <= 0) {
                            Seed newSeed = new Seed();
                            newSeed.setXpos(App.ReturnCurrentGame().getEnemies().get(j).getXPos());
                            newSeed.setYpos(App.ReturnCurrentGame().getEnemies().get(j).getYPos());
                            newSeed.getCollision().setX(newSeed.getXpos());
                            newSeed.getCollision().setY(newSeed.getYpos());
                            App.ReturnCurrentGame().getSeeds().add(newSeed);
                            DestroyedAnimation newd = new DestroyedAnimation(App.ReturnCurrentGame().getEnemies().get(j).getXPos() , App.ReturnCurrentGame().getEnemies().get(j).getYPos());
                            App.ReturnCurrentGame().getDestroyedAnimations().add(newd);
                            App.ReturnCurrentGame().getEnemies().remove(j);
                            App.ReturnCurrentGame().getPlayer().setKills(App.ReturnCurrentGame().getPlayer().getKills() + 1);
                        }
                        //App.ReturnCurrentGame().getBullets().remove(i);
                        break;
                    }
                }
            }
        }
    }

}
