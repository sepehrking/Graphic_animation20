package com.Tilldawn.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class TREE extends Enemy{
    public TREE() {
        texture = new Texture("Monsters/T_TreeMonster_2.png");
        EnemySprite = new Sprite(texture);

    }
}
