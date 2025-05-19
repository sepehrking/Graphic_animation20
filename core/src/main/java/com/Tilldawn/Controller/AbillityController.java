package com.Tilldawn.Controller;

import com.Tilldawn.model.App;
import com.Tilldawn.model.Player;

import java.util.PriorityQueue;

public class AbillityController {
    private Player player;

    private float DAMAGERTIME = 10;
    private float SPEEDTIME = 10;


    public void TIMEUPDATE(float DELTA)
    {
        DAMAGERTIME += DELTA;
        SPEEDTIME += DELTA;
        if(DAMAGERTIME > 10)
        {
            player.getWeopenC().setDamageDamage(App.ReturnCurrentGame().getWeopen().Damage);
        }
        if(SPEEDTIME > 10)
        {
            player.setSpeed(App.ReturnCurrentGame().getHero().Speed);
        }
    }


    public float getDAMAGERTIME() {
        return DAMAGERTIME;
    }

    public void setDAMAGERTIME(float DAMAGERTIME) {
        this.DAMAGERTIME = DAMAGERTIME;
    }

    public float getSPEEDTIME() {
        return SPEEDTIME;
    }

    public void setSPEEDTIME(float SPEEDTIME) {
        this.SPEEDTIME = SPEEDTIME;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void VITALITY()
    {
        player.setHp(player.getHp() + 1);
    }

    public void DAMAGER()
    {
        player.getWeopenC().setDamageDamage(App.ReturnCurrentGame().getWeopen().Damage * 5 / 4);
    }

    public void SPEEDY()
    {
        player.setSpeed(App.ReturnCurrentGame().getHero().Speed * 2);
    }

    public void AMOCREASE()
    {
        player.getWeopenC().setMAXAMO(player.getWeopenC().getMAXAMO() + 5);
    }

    public void PRECREASE()
    {
        player.getWeopenC().setTileCovers(player.getWeopenC().getTileCovers() + 1);
    }


}
