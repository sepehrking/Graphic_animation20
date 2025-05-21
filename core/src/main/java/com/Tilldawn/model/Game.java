package com.Tilldawn.model;

import com.Tilldawn.View.DestroyedAnimation;
import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Weopens;

import java.util.ArrayList;

public class Game {
    private PREGAME pregame = new PREGAME();
    private Player player;
    public final int NUmberOfTreeMonsters = 40;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private ArrayList<Bullet> Bullets = new ArrayList<>();
    private ArrayList<Seed> Seeds = new ArrayList<>();
    private Heros hero = Heros.Shana;
    private int TotalTime = 120 ;
    private Weopens Weopen = Weopens.ShotGun;
    private Timer timer = new Timer();
    private boolean ISLEVELUP = false;
    private ArrayList<DestroyedAnimation> destroyedAnimations = new ArrayList<>();

    public ArrayList<DestroyedAnimation> getDestroyedAnimations() {
        return destroyedAnimations;
    }

    public PREGAME getPregame() {
        return pregame;
    }

    public boolean isISLEVELUP() {
        return ISLEVELUP;
    }

    public void setISLEVELUP(boolean ISLEVELUP) {
        this.ISLEVELUP = ISLEVELUP;
    }

    public ArrayList<Seed> getSeeds() {
        return Seeds;
    }

    public void setSeeds(ArrayList<Seed> seeds) {
        Seeds = seeds;
    }

    public ArrayList<Bullet> getBullets() {
        return Bullets;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public Player getPlayer() {
        return player;
    }

    public Weopens getWeopen() {
        return Weopen;
    }

    public void setWeopen(Weopens weopen) {
        Weopen = weopen;
    }

    public Heros getHero() {
        return hero;
    }

    public void setHero(Heros hero) {
        this.hero = hero;
    }

    public int getTotalTime() {
        return TotalTime;
    }

    public void setTotalTime(int totalTime) {
        TotalTime = totalTime;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
