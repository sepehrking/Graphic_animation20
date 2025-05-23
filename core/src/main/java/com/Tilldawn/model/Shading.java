package com.Tilldawn.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class Shading {
    private Texture overlayTexture;

    public void update(float heroX, float heroY, int screenWidth, int screenHeight) {
        Pixmap pixmap = new Pixmap(screenWidth * 2, screenHeight * 2, Pixmap.Format.RGBA8888);
        pixmap.setColor(0, 0, 0, 0.3f);
        pixmap.fill();

        // Draw light circle (clear circle around hero)
        pixmap.setBlending(Pixmap.Blending.None);
        pixmap.setColor(0, 0, 0, 0);
        pixmap.fillCircle((int) App.ReturnCurrentGame().getPlayer().getPosX(), (int) (Gdx.graphics.getHeight() * 2 - App.ReturnCurrentGame().getPlayer().getPosY()) , 100); // Radius 100

        if (overlayTexture != null) overlayTexture.dispose();
        overlayTexture = new Texture(pixmap);
        pixmap.dispose();
    }

    public void render(SpriteBatch batch) {
        Color oldColor = batch.getColor();
        batch.setColor(Color.WHITE);
        batch.draw(overlayTexture, 0, 0);
        batch.setColor(oldColor);
    }

    public void dispose() {
        if (overlayTexture != null) overlayTexture.dispose();
    }
}
