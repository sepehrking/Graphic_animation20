package com.Tilldawn.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Enemy {
    protected float XPos;
    protected float YPos;
    protected Texture texture;
    protected Sprite EnemySprite;
    protected int Hp;
    protected CollsionREcatangle collisionREcatangle  = new CollsionREcatangle();

    public CollsionREcatangle getCollisionREcatangle() {
        return collisionREcatangle;
    }

    public void setCollisionREcatangle(CollsionREcatangle collisionREcatangle) {
        this.collisionREcatangle = collisionREcatangle;
    }

    public float getXPos() {
        return XPos;
    }

    public void setXPos(float XPos) {
        this.XPos = XPos;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public Sprite getEnemySprite() {
        return EnemySprite;
    }

    public void setEnemySprite(Sprite enemySprite) {
        EnemySprite = enemySprite;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public float getYPos() {
        return YPos;
    }

    public void setYPos(float YPos) {
        this.YPos = YPos;
    }
}
