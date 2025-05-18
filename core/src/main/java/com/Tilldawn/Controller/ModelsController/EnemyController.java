package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.model.Enemy;
import com.Tilldawn.model.TREE;
import com.Tilldawn.model.TentacleMonster;
import com.badlogic.gdx.Gdx;

public class EnemyController {
    private TreeController treecontroller = new TreeController();
    private TenteacleController tenteacontroller = new TenteacleController();
    public TreeController getTreecontroller() {
        return treecontroller;
    }

    public TenteacleController getTenteacontroller() {
        return tenteacontroller;
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
    }
}
