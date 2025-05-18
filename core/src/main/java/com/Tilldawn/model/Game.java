package com.Tilldawn.model;

import com.Tilldawn.model.Enums.Heros;
import com.Tilldawn.model.Enums.Weopens;

import java.util.ArrayList;

public class Game {
    private Player player;
    public final int NUmberOfTreeMonsters = 40;
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Heros hero = Heros.Shana;
    private int TotalTime = 0;
    private Weopens Weopen;
    private Timer timer = new Timer();

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
