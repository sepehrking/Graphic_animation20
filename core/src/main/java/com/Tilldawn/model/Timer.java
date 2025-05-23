package com.Tilldawn.model;

public class Timer {
    private float Time = 0;
    private float TacnecalMonsterSpawn = 0;
    private float EyebatSpawn = 0;
    private float LastTimeDamaged = 0;
    private boolean BossAppear = false;

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
