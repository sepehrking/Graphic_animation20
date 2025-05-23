package com.Tilldawn;

import com.Tilldawn.Controller.SignUpcontroller;
import com.Tilldawn.Controller.StartMenuController;
import com.Tilldawn.View.LoginMenu;
import com.Tilldawn.View.SignupMenu;
import com.Tilldawn.View.StartMenu;
import com.Tilldawn.model.AudioManager;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    private static Main main;
    private static SpriteBatch batch;
    private Texture image;
    @Override
    public void create() {
        Pixmap pixmap = new Pixmap(Gdx.files.internal("T_CursorSprite.png"));
        Cursor cursor = Gdx.graphics.newCursor(pixmap, 26, 26);
        Gdx.graphics.setCursor(cursor);
        main = this;
        batch = new SpriteBatch();
       // AudioManager.PlayedMusic.play();
        getMain().setScreen(new StartMenu(new StartMenuController()));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }

    public static Main getMain() {
        return main;
    }

    public static SpriteBatch getBatch() {
        return batch;
    }
}
