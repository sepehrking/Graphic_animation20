package com.Tilldawn.model;

import com.Tilldawn.model.Enums.Avatars;
import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Musics;
import com.Tilldawn.model.Enums.Weopens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.List;

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

    public Array<Float> GETHP()
    {
        Array<Float> hp = new Array<>();
        for(Heros hero : Heros.values())
        {
            hp.add(hero.Hp);
        }
        return hp;
    }

    public Array<Integer> getspeeds()
    {
        Array<Integer> speeds = new Array<>();
        for(Heros hero : Heros.values())
        {
            speeds.add(hero.Speed);
        }
        return speeds;
    }

    public List<User> GETUSERS()
    {
        List<User> users = new ArrayList<>();
        for(User user : App.Users)
        {
            users.add(user);
        }
        return users;
    }

    public Animation<Texture> Character_idle_animation() {
        Animation<Texture> Ret = new Animation<>(0.1f , new Texture(App.ReturnCurrentGame().getHero().AnimationAdreeses.get(0)) , new Texture(App.ReturnCurrentGame().getHero().AnimationAdreeses.get(1))
        , new Texture(App.ReturnCurrentGame().getHero().AnimationAdreeses.get(2)) , new Texture(App.ReturnCurrentGame().getHero().AnimationAdreeses.get(3)) ,
            new Texture(App.ReturnCurrentGame().getHero().AnimationAdreeses.get(4)) , new Texture(App.ReturnCurrentGame().getHero().AnimationAdreeses.get(5)));
        return Ret;
    }

    public ArrayList<String> CheatCodes()
    {
        ArrayList<String> CheatCodes = new ArrayList<>();
        CheatCodes.add("1  :  The game will Skip for 1 minute");
        CheatCodes.add("2  :  Add 1 level to character");
        CheatCodes.add("3 :   get one health ");
        CheatCodes.add("4 :   Go to the Bossfight");
        CheatCodes.add("5 :   Increase the Amoo");
        return CheatCodes;
    }

    public Animation<Texture> getTentacleMonsterAnimation()
    {
        Animation ret = new Animation<>(0.1f , new Texture(Gdx.files.internal("Monsters/TentacleIdle0.png")) ,
            new Texture(Gdx.files.internal("Monsters/TentacleIdle1.png")) , new Texture(Gdx.files.internal("Monsters/TentacleIdle2.png"))
        , new Texture(Gdx.files.internal("Monsters/TentacleIdle3.png")));
        return ret;
    }

    public Animation<Texture> BatAnimation()
    {
        Animation ret = new Animation<>(0.1f , new Texture(Gdx.files.internal("Monsters/T_EyeBat_0.png")) ,
            new Texture(Gdx.files.internal("Monsters/T_EyeBat_1.png")) , new Texture(Gdx.files.internal("Monsters/T_EyeBat_2.png")) ,
            new Texture(Gdx.files.internal("Monsters/T_EyeBat_3.png")));
        return ret;
    }

}
