package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.View.DestroyedAnimation;
import com.Tilldawn.model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

public class EnemyController {
    private TreeController treecontroller = new TreeController();
    private TenteacleController tenteacontroller = new TenteacleController();
    private EyeController eyecontroller = new EyeController();
    private ElderBossController elderbosscontroller = new ElderBossController();

    public ElderBossController getElderbosscontroller() {
        return elderbosscontroller;
    }

    public TreeController getTreecontroller() {
        return treecontroller;
    }

    public TenteacleController getTenteacontroller() {
        return tenteacontroller;
    }

    public EyeController getEyecontroller() {
        return eyecontroller;
    }

    public void Update(Enemy enemy , float delta)
    {
        enemy.setTimeDamaged(enemy.getTimeDamaged() + delta);
        idleAnimation(enemy , delta);
        if(enemy instanceof TREE)
        {
            TREE ourtree = (TREE) enemy;
            treecontroller.Update(ourtree);
        }
        if(enemy instanceof TentacleMonster)
        {
            TentacleMonster ourmonster = (TentacleMonster) enemy;
            tenteacontroller.Update(ourmonster , delta);
        }
        if(enemy instanceof EyeBat)
        {
            EyeBat ourmonster = (EyeBat) enemy;
            eyecontroller.Update(ourmonster , delta);
        }
        if(enemy instanceof ElderBoss)
        {
            elderbosscontroller.Update((ElderBoss) enemy , delta);
        }
    }

    public void idleAnimation(Enemy enemy , float Delta){
        if(enemy.getAnimation() != null) {
            enemy.getAnimation().setPlayMode(Animation.PlayMode.LOOP);
            enemy.getEnemySprite().setRegion(enemy.getAnimation().getKeyFrame(enemy.getAnimationTime()));
            if (!enemy.getAnimation().isAnimationFinished(enemy.getAnimationTime())) {
                enemy.setAnimationTime(enemy.getAnimationTime() + Delta);
            } else {
                enemy.setAnimationTime(0);
            }
        }
    }

}
