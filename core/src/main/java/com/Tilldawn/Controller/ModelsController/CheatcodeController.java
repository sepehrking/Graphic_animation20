package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.model.App;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class CheatcodeController {
    public void update(ElderBossController elderBoss)
    {
        RaiseTime();
        LevelUp();
        GetHp();
        GotoBossFight(elderBoss);
        AmmoCrease();
    }


    public void RaiseTime()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_1))
        {
            if(App.ReturnCurrentGame().getTimer().getCheat1Timer() > 1) {
                App.ReturnCurrentGame().getTimer().setTime(App.ReturnCurrentGame().getTimer().getTime() + 60);
                App.ReturnCurrentGame().getTimer().setCheat1Timer(0);
            }
        }
    }

    public void LevelUp()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_2))
        {
            if(App.ReturnCurrentGame().getTimer().getCheat2Timer() > 1) {
                int Level = App.ReturnCurrentGame().getPlayer().getLevel();
                App.ReturnCurrentGame().getPlayer().setXp(20 * (Level + 1) * (Level) / 2);
                App.ReturnCurrentGame().getTimer().setCheat2Timer(0);
            }
        }
    }

    public void GetHp()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_3))
        {
            if(App.ReturnCurrentGame().getTimer().getCheat3Timer() > 1) {
                if (App.ReturnCurrentGame().getPlayer().getHp() <= App.ReturnCurrentGame().getHero().Hp - 1) {
                    App.ReturnCurrentGame().getPlayer().setHp(App.ReturnCurrentGame().getPlayer().getHp() + 1);
                }
                App.ReturnCurrentGame().getTimer().setCheat3Timer(0);
            }
        }
    }

    public void GotoBossFight(ElderBossController elderBoss)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_4))
        {
            if(App.ReturnCurrentGame().getTimer().getCheat4Timer() > 1) {
                elderBoss.CreateElderBoss();
                App.ReturnCurrentGame().getTimer().setBossAppear(true);
                App.ReturnCurrentGame().getTimer().setCheat4Timer(0);
            }
        }
    }

    public void AmmoCrease()
    {
        if(Gdx.input.isKeyPressed(Input.Keys.NUM_5))
        {
            if(App.ReturnCurrentGame().getTimer().getCheat5Timer() > 1) {
                App.ReturnCurrentGame().getTimer().setCheat5Timer(0);
                App.ReturnCurrentGame().getPlayer().getWeopenC().setMAXAMO(App.ReturnCurrentGame().getPlayer().getWeopenC().getMAXAMO() + 5);
            }
        }
    }



}
