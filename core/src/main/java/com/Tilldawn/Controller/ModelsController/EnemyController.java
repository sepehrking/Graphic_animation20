package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.View.DestroyedAnimation;
import com.Tilldawn.model.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;

public class EnemyController {
    private TreeController treecontroller = new TreeController();
    private TenteacleController tenteacontroller = new TenteacleController();
    private EyeController eyecontroller = new EyeController();
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
    }

}
