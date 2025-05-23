package com.Tilldawn.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
    public static Music PlayedMusic;
    public static Sound Shooting;
    public static float Volume = 0.5f;

    static {
        PlayedMusic = Gdx.audio.newMusic(Gdx.files.internal("Musics/mus1.mp3"));
        PlayedMusic.setLooping(true);
        Shooting = Gdx.audio.newSound(Gdx.files.internal("Musics/UI Click 36.wav"));
        PlayedMusic.setVolume(Volume);
    }


    public AudioManager() {
    }

    public static void PlayShoot()
    {
        if(App.ReturnCurrentGame().getPregame().SFX) {
            Shooting.play();
        }
    }


}

