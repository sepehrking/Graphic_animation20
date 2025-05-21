package com.Tilldawn.View;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class DestroyedAnimation {
    private float X;
    private float Y;
    private Animation<Texture> animation;
    private Sprite sprite;
    private float Time = 0 ;

    public float getTime() {
        return Time;
    }

    public void setTime(float time) {
        Time = time;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public Animation<Texture> getAnimation() {
        return animation;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public DestroyedAnimation(float x, float y) {
        Y = y;
        X = x;
        animation = new Animation<Texture>(0.1f , new Texture("Explosion/ExplosionFX_0.png") , new Texture("Explosion/ExplosionFX_1.png") ,
            new Texture("Explosion/ExplosionFX_2.png") , new Texture("Explosion/ExplosionFX_3.png") ,
            new Texture("Explosion/ExplosionFX_4.png") , new Texture("Explosion/ExplosionFX_5.png"));
        sprite = new Sprite(new Texture("Explosion/ExplosionFX_0.png"));
    }
}
