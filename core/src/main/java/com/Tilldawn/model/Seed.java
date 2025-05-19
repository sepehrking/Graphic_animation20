package com.Tilldawn.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.PrimitiveIterator;

public class Seed {
    private float Xpos;
    private float Ypos;
    private CollsionREcatangle collision = new CollsionREcatangle();
    private Texture texture;
    private Sprite sprite;

    public float getXpos() {
        return Xpos;
    }

    public void setXpos(float xpos) {
        Xpos = xpos;
    }

    public float getYpos() {
        return Ypos;
    }

    public void setYpos(float ypos) {
        Ypos = ypos;
    }

    public CollsionREcatangle getCollision() {
        return collision;
    }

    public void setCollision(CollsionREcatangle collision) {
        this.collision = collision;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public Seed() {
        texture = new Texture("Seed/EyeMonster_Em.png");
        sprite = new Sprite(texture);
        sprite.setSize(texture.getWidth() * 3 / 2, texture.getHeight() * 3 / 2);
        collision.setWidth(sprite.getWidth());
        collision.setHeight(sprite.getHeight());
    }
}
