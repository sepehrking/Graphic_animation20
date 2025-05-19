package com.Tilldawn.model;

public class CollsionREcatangle {
    private  float x;
    private float y;
    private float width;
    private float height;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean IsCollide(CollsionREcatangle rec) {

        if(rec.x >= x - 1 && rec.x < x + width && rec.y > y && rec.y <= y + height + 1)
        {
            return true;
        }
        if(x >= rec.x  - 1 && x <= 1 + rec.width + rec.x && y + 1 >= rec.y  && y  -1 <= rec.height + rec.y)
        {
            return true;
        }
        return false;
    }
}
