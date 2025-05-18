package com.Tilldawn.Controller.ModelsController;

import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.TREE;
import com.badlogic.gdx.Gdx;

public class TreeController {
    public void CreateTree()
    {
        TREE tree = new TREE();
        int RandX = App.rand.nextInt() % (Gdx.graphics.getWidth() * 2);
        int Randy = App.rand.nextInt() % (Gdx.graphics.getHeight() * 2);
        RandX -= Gdx.graphics.getWidth() / 2;
        Randy -= Gdx.graphics.getHeight() / 2;
        if(RandX < 0)
        {
            RandX -= 100;
        }
        if(Randy < 0)
        {
            Randy -= 100;
        }
        tree.setXPos(RandX);
        tree.setYPos(Randy);
        App.Games.get(App.UserLoginId).getEnemies().add(tree);
    }

    public void Update(TREE tree)
    {
        tree.getEnemySprite().setPosition(tree.getXPos()  , tree.getYPos());
        tree.getEnemySprite().draw(Main.getBatch());
    }

}
