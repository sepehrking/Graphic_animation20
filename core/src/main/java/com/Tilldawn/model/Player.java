package com.Tilldawn.model;

import com.Tilldawn.Controller.AbillityController;
import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Weopens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player {
    private AbillityController abillityController;
    private Texture playerTexture;
    private Sprite playerSprite;
    Heros Hero;
    float Hp;
    private float posX = Gdx.graphics.getWidth() / 2f;
    private float posY = Gdx.graphics.getHeight() / 2f;
    private float playerHealth;
    private CollRect collRect;
    private float time = 0;
    private float speed;
    private CollsionREcatangle col = new CollsionREcatangle();
    private int Xp = 0;
    private int Level = 0;
    Weopen weopenC;

    public AbillityController getAbillityController() {
        return abillityController;
    }

    public void setAbillityController(AbillityController abillityController) {
        this.abillityController = abillityController;
    }

    public Weopen getWeopenC() {
        return weopenC;
    }

    public void setWeopenC(Weopen weopenC) {
        this.weopenC = weopenC;
    }

    public int getXp() {
        return Xp;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel() {
        Level++;
    }

    public boolean setXp(int xp) {
        Xp = xp;
        int XPREQ = Level * (Level + 1) * 20;
        XPREQ /= 2;
        if(Xp > XPREQ)
        {
            setLevel();
            return true;
        }
        return false;
    }

    public CollsionREcatangle getCol() {
        return col;
    }

    public void setCol(CollsionREcatangle col) {
        this.col = col;
    }

    public Player() {
        this.Hero = App.Games.get(App.UserLoginId).getHero();
        this.playerTexture = new Texture(Gdx.files.internal(this.Hero.AnimationAdreeses.get(0)));
        this.playerSprite = new Sprite(this.playerTexture);
        this.playerSprite.setSize(playerTexture.getWidth() * 3, playerTexture.getHeight() * 3);
        this.playerHealth = this.Hero.Hp;
        col.setX(this.getPosX());
        col.setY(this.getPosY());
        col.setWidth(playerTexture.getWidth());
        col.setHeight(playerTexture.getHeight());
        Hp = this.Hero.Hp;
        weopenC = new Weopen();
        abillityController = new AbillityController();
        abillityController.setPlayer(this);
        speed = Hero.Speed;
    }

    public float getHp() {
        return Hp;
    }

    public void setHp(float hp) {
        Hp = hp;
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
