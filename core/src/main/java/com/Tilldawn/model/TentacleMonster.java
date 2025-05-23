package com.Tilldawn.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TentacleMonster extends Enemy{
    public TentacleMonster() {
        Hp = 25;
        texture = new Texture("Monsters/TentacleIdle0.png");
        EnemySprite = new Sprite(texture);
        collisionREcatangle.setX(XPos);
        collisionREcatangle.setY(YPos);
        collisionREcatangle.setWidth(texture.getWidth());
        collisionREcatangle.setHeight(texture.getHeight());
        animation = GameAssets.getInstance().getTentacleMonsterAnimation();
    }
}
