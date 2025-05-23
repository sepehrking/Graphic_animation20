package com.Tilldawn.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class ElderBoss extends Enemy{
    private float DashTime = 0;

    public float getDashTime() {
        return DashTime;
    }

    public void setDashTime(float dashTime) {
        DashTime = dashTime;
    }

    public ElderBoss(float xPos, float yPos) {
        texture = new Texture(Gdx.files.internal("Monsters/ElderBrain.png"));
        EnemySprite = new Sprite(texture);
        EnemySprite.setSize(texture.getWidth() * 5 , texture.getHeight() * 5);
        Hp = 400;
        this.XPos = xPos;
        this.YPos = yPos;
        collisionREcatangle.setX(XPos);
        collisionREcatangle.setY(YPos);
        collisionREcatangle.setWidth(texture.getWidth() * 5);
        collisionREcatangle.setHeight(texture.getHeight() * 5);
    }
}
