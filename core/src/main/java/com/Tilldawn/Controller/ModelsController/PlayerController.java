package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Controller.GirdController;
import com.Tilldawn.Main;
import com.Tilldawn.model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerController {
    private Player player;
    private GirdController girdController;
    public void setPlayer(Player player , GirdController girdController) {
        this.player = player;
        this.girdController = girdController;
    }

    public boolean CheckIfInsideGird()
    {
        if(player.getPosX() < -1 *  Gdx.graphics.getWidth() / 2f || player.getPosX() > 3 * Gdx.graphics.getWidth() / 2f - 50)
        {
            return false;
        }
        if(player.getPosY() < -1 * Gdx.graphics.getHeight() / 2f || player.getPosY() > 4 * Gdx.graphics.getHeight() / 2f)
        {
            return false;
        }
        return true;
    }

    public void Update(float Delta)
    {
        if(App.ReturnCurrentGame().getTimer().getLastTimeDamaged() > 1)
        {
            player.getPlayerSprite().setColor(1f , 1f , 1f , 1f);
        }
        else
        {
            player.getPlayerSprite().setColor(0.4f , 0.4f , 0.4f , 0.4f);
        }
        player.getCol().setX(player.getPosX());
        player.getCol().setY(player.getPosY());
        player.getPlayerSprite().setPosition(player.getPosX() ,player.getPosY());
        player.getPlayerSprite().draw(Main.getBatch());
        player.getWeopenC().updateWeopenTime(Delta);
        Texture weaopen = new Texture(Gdx.files.internal(App.ReturnCurrentGame().getWeopen().Addres));
        Sprite weaopenSprite = new Sprite(weaopen);
        weaopenSprite.setSize(weaopenSprite.getWidth() * 4  , weaopenSprite.getHeight() * 4);
        weaopenSprite.setPosition(player.getPosX() + 30 ,player.getPosY() + 10);
        weaopenSprite.draw(Main.getBatch());
        HandleWalking();
        HandleShooting();
        CheckCollision(Delta);
        HandleReload();
        HandleGettingSeed();
        player.getAbillityController().TIMEUPDATE(Delta);
    }


    public void HandleGettingSeed()
    {
        for(int i = App.ReturnCurrentGame().getSeeds().size() - 1 ; i >= 0 ; i--)
        {

            Seed ourseed = App.ReturnCurrentGame().getSeeds().get(i);
            Player player = App.ReturnCurrentGame().getPlayer();
            if(ourseed.getCollision().IsCollide(App.ReturnCurrentGame().getPlayer().getCol()))
            {
                boolean ISLeveLUP = player.setXp(player.getXp() + 10);
                App.ReturnCurrentGame().getSeeds().remove(i);
                if(ISLeveLUP)
                {
                    App.ReturnCurrentGame().setISLEVELUP(true);
                }
            }
        }
    }


    public void HandleReload()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.R)) {
            player.getWeopenC().setAmoo(player.getWeopenC().getMAXAMO());
            player.getWeopenC().setTimeinreload(0);
        }
    }


    public void HandleShooting()
    {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) || Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            if(player.getWeopenC().getTimeinreload() > App.ReturnCurrentGame().getWeopen().TimeREload) {
                if(player.getWeopenC().getAmoo() > 0 && player.getWeopenC().getTimeinShotting() > 0.5) {
                    Bullet newbullet = new Bullet(App.ReturnCurrentGame().getPlayer().getPosX(), App.ReturnCurrentGame().getPlayer().getPosY());
                    App.ReturnCurrentGame().getBullets().add(newbullet);
                    player.getWeopenC().setAmoo(player.getWeopenC().getAmoo() - 1);
                    player.getWeopenC().setTimeinShotting(0);
                }
            }
        }
    }


    public void HandleWalking()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.W))
        {
            player.setPosY(player.getPosY() + player.getSpeed());
            if(!CheckIfInsideGird())
            {
                player.setPosY(player.getPosY() - player.getSpeed());
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S))
        {
            player.setPosY(player.getPosY() - player.getSpeed());
            if(!CheckIfInsideGird())
            {
                player.setPosY(player.getPosY() + player.getSpeed());
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A))
        {
            player.setPosX(player.getPosX() - player.getSpeed());
            if(!CheckIfInsideGird())
            {
                player.setPosX(player.getPosX() + player.getSpeed());
            }
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D))
        {
            player.setPosX(player.getPosX() + player.getSpeed());
            if(!CheckIfInsideGird())
            {
                player.setPosX(player.getPosX() - player.getSpeed());
            }
        }
    }

    public void CheckCollision(float Delta)
    {
        if(App.ReturnCurrentGame().getTimer().getLastTimeDamaged() > 1) {
            boolean ok = false;
            for (Enemy enemy : App.ReturnCurrentGame().getEnemies()) {
                if (enemy.getCollisionREcatangle().IsCollide(App.ReturnCurrentGame().getPlayer().getCol())) {
                    ok = true;
                }
            }
            if (ok) {
                App.ReturnCurrentGame().getTimer().setLastTimeDamaged(0);
                App.ReturnCurrentGame().getPlayer().setHp(App.ReturnCurrentGame().getPlayer().getHp() - Delta * 5);
            }
        }
    }

}
