package com.Tilldawn.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class EyeBat extends Enemy {
    private float ShootingTime = 0;

    public float getShootingTime() {
        return ShootingTime;
    }

    public void setShootingTime(float shootingTime) {
        ShootingTime = shootingTime;
    }

    public EyeBat() {
        Hp = 50;
        texture = new Texture("Monsters/T_EyeBat_0.png");
        EnemySprite = new Sprite(texture);
        collisionREcatangle.setX(XPos);
        collisionREcatangle.setY(YPos);
        collisionREcatangle.setWidth(texture.getWidth());
        collisionREcatangle.setHeight(texture.getHeight());
    }
}
