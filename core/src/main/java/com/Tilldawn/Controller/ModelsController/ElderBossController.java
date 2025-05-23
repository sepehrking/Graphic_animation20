package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.ElderBoss;
import com.badlogic.gdx.Gdx;

public class ElderBossController {

    public void CreateElderBoss() {
        int RandX = App.rand.nextInt() % Gdx.graphics.getWidth();
        int Randy = App.rand.nextInt() % Gdx.graphics.getHeight();
        ElderBoss elder = new ElderBoss(RandX , Randy);
        App.ReturnCurrentGame().getEnemies().add(elder);
    }

    public void Update(ElderBoss elderBoss , float delta)
    {
        elderBoss.getEnemySprite().setPosition(elderBoss.getXPos() , elderBoss.getYPos());
        elderBoss.getEnemySprite().draw(Main.getBatch());
        elderBoss.setDashTime(elderBoss.getDashTime() + delta);
        Dashing(elderBoss);
    }

    public void Dashing(ElderBoss elderBoss)
    {
        if(elderBoss.getDashTime() > 7)
        {
            float XD = App.ReturnCurrentGame().getPlayer().getPosX();
            float YD = App.ReturnCurrentGame().getPlayer().getPosY();
            elderBoss.setXPos(XD);
            elderBoss.setYPos(YD);
            elderBoss.getCollisionREcatangle().setX(XD);
            elderBoss.getCollisionREcatangle().setY(YD);
            elderBoss.setDashTime(0);
        }
    }

}
