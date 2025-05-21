package com.Tilldawn.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet {
    float xd = 1 , yd = 1;
    private float Posx;
    private float Posy;
    private CollsionREcatangle collision = new CollsionREcatangle();
    private Texture texture;
    private Sprite sprite;

    public Bullet(float posx, float posy) {
        posx += 50;
        posy += 20;
        texture = new Texture("bullet.jpg");
        sprite = new Sprite(texture);
        sprite.setSize(texture.getWidth() / 5, texture.getHeight() / 5);
        sprite.setPosition(posx, posy);
        Posx = posx;
        Posy = posy;
        collision.setX(posx);
        collision.setY(posy);
        collision.setWidth(sprite.getWidth());
        collision.setHeight(sprite.getHeight());
    }

    public float getXd() {
        return xd;
    }

    public void setXd(float xd) {
        this.xd = xd;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public CollsionREcatangle getCollision() {
        return collision;
    }

    public void setCollision(CollsionREcatangle collision) {
        this.collision = collision;
    }

    public float getPosy() {
        return Posy;
    }

    public void setPosy(float posy) {
        Posy = posy;
    }

    public float getYd() {
        return yd;
    }

    public void setYd(float yd) {
        this.yd = yd;
    }

    public float getPosx() {
        return Posx;
    }

    public void setPosx(float posx) {
        Posx = posx;
    }
}
