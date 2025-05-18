package com.Tilldawn.Controller;

import com.Tilldawn.Main;
import com.Tilldawn.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GirdController {
    private Player charachter;
    private Texture backgroundTexture;
    private float backgroundX;
    private float backgroundY;

    public GirdController(Player Charachter) {
        this.backgroundTexture = new Texture("background.png");
        this.charachter = Charachter;
        backgroundX = charachter.getPosX();
        backgroundY = charachter.getPosY();
    }

    public void update() {
        backgroundY = Gdx.graphics.getHeight() / 2f ;
        backgroundX = Gdx.graphics.getWidth() / 2f ;
        backgroundX *= -1;
        backgroundY *= -1;
        Main.getBatch().draw(backgroundTexture, backgroundX, backgroundY);
    }
}
