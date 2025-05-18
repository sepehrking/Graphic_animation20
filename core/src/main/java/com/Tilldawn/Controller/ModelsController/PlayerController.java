package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Controller.GirdController;
import com.Tilldawn.Main;
import com.Tilldawn.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

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

    public void Update()
    {
        player.getPlayerSprite().setPosition(player.getPosX() ,player.getPosY());
        player.getPlayerSprite().draw(Main.getBatch());
        HandleWalking();
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

}
