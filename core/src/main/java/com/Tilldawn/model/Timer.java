package com.Tilldawn.model;

public class Timer {
    private float Time = 0;
    private float TacnecalMonsterSpawn = 0;
    private float EyebatSpawn = 0;
    private float LastTimeDamaged = 0;
    private boolean BossAppear = false;

    private float Cheat1Timer = 0;
    private float Cheat2Timer = 0;
    private float Cheat3Timer = 0;
    private float Cheat4Timer = 0;
    private float Cheat5Timer = 0;

    public float getCheat1Timer() {
        return Cheat1Timer;
    }

    public void setCheat1Timer(float cheat1Timer) {
        Cheat1Timer = cheat1Timer;
    }

    public float getCheat4Timer() {
        return Cheat4Timer;
    }

    public void setCheat4Timer(float cheat4Timer) {
        Cheat4Timer = cheat4Timer;
    }

    public float getCheat2Timer() {
        return Cheat2Timer;
    }

    public void setCheat2Timer(float cheat2Timer) {
        Cheat2Timer = cheat2Timer;
    }

    public float getCheat3Timer() {
        return Cheat3Timer;
    }

    public void setCheat3Timer(float cheat3Timer) {
        Cheat3Timer = cheat3Timer;
    }

    public float getCheat5Timer() {
        return Cheat5Timer;
    }

    public void setCheat5Timer(float cheat5Timer) {
        Cheat5Timer = cheat5Timer;
    }

    public boolean isBossAppear() {
        return BossAppear;
    }

    public void setBossAppear(boolean bossAppear) {
        BossAppear = bossAppear;
    }

    public void IncreaseTime(float Delta)
    {
        Time += Delta;
        TacnecalMonsterSpawn += Delta;
        EyebatSpawn += Delta;
        LastTimeDamaged += Delta;
        Cheat1Timer += Delta;
        Cheat2Timer += Delta;
        Cheat3Timer += Delta;
        Cheat4Timer += Delta;
        Cheat5Timer += Delta;
    }

    public float getLastTimeDamaged() {
        return LastTimeDamaged;
    }

    public void setLastTimeDamaged(float lastTimeDamaged) {
        LastTimeDamaged = lastTimeDamaged;
    }

    public float getTime() {
        return Time;
    }

    public void setTime(float time) {
        Time = time;
    }

    public float getTacnecalMonsterSpawn() {
        return TacnecalMonsterSpawn;
    }

    public void setTacnecalMonsterSpawn(float tacnecalMonsterSpawn) {
        TacnecalMonsterSpawn = tacnecalMonsterSpawn;
    }

    public float getEyebatSpawn() {
        return EyebatSpawn;
    }

    public void setEyebatSpawn(float eyebatSpawn) {
        EyebatSpawn = eyebatSpawn;
    }
}
