package com.Tilldawn.model;

import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Weopens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
    private Texture playerTexture;
    private Sprite playerSprite;
    Heros Hero;
    private float posX = Gdx.graphics.getWidth() / 2f;
    private float posY = Gdx.graphics.getHeight() / 2f;
    private float playerHealth;
    private CollRect collRect;
    private float time = 0;
    private float speed = 5;

    public Player() {
        this.Hero = App.Games.get(App.UserLoginId).getHero();
        this.playerTexture = new Texture(Gdx.files.internal(this.Hero.AnimationAdreeses.get(0)));
        this.playerSprite = new Sprite(this.playerTexture);
        this.playerSprite.setSize(playerTexture.getWidth() * 3, playerTexture.getHeight() * 3);
        this.playerHealth = this.Hero.Hp;
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public float getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(float playerHealth) {
        this.playerHealth = playerHealth;
    }

    public CollRect getCollRect() {
        return collRect;
    }

    public void setCollRect(CollRect collRect) {
        this.collRect = collRect;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Sprite getPlayerSprite() {
        return playerSprite;
    }
}
