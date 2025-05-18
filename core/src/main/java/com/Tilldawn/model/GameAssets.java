package com.Tilldawn.model;

import com.Tilldawn.model.Enums.Avatars;
import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Musics;
import com.Tilldawn.model.Enums.Weopens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class GameAssets {
    private static GameAssets instance;
    private final Skin skin;

    private GameAssets() {
        skin = new Skin(Gdx.files.internal("Skins/pixthulhu-ui.json"));
    }

    public static GameAssets getInstance() {
        if (instance == null) {
            instance = new GameAssets();
        }
        return instance;
    }

    public Skin getSkin() {
        return skin;
    }

    public ArrayList<ImageButton> getbuttons()
    {
        ArrayList<ImageButton> buttons = new ArrayList<>();
        for(Avatars avatars : Avatars.values())
        {
            Texture texture = new Texture(Gdx.files.internal(avatars.Path_Avatars));
            buttons.add(new ImageButton(new TextureRegionDrawable(new TextureRegion(texture))));
        }
        return buttons;
    }

    public Array<String> getHeros() {
        Array<String> heros = new Array<>();
        for(Heros hero : Heros.values())
        {
            heros.add(hero.toString());
        }
        return heros;
    }

    public Array<String> getWeaOpen() {
        Array<String> weaOpen = new Array<>();
        for(Weopens weaOpens : Weopens.values())
        {
            weaOpen.add(weaOpens.toString());
        }
        return weaOpen;
    }

    public Array<String> gettimes()
    {
        Array<String> times = new Array<>();
        times.add("2 MIn");
        times.add("5 Min");
        times.add("10 Min");
        times.add("20 Min");
        return times;
    }

    public Array<String> GetMusics()
    {
        Array<String> musics = new Array<>();
        for(Musics music : Musics.values())
        {
            musics.add(music.toString());
        }
        return musics;
    }
}
