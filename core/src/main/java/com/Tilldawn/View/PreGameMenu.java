package com.Tilldawn.View;

import com.Tilldawn.Controller.PreGameMenucontroller;
import com.Tilldawn.Main;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class PreGameMenu implements Screen {
    private PreGameMenucontroller controller;
    private Stage stage;
    private SelectBox<String> selectHero;
    private SelectBox<String> selectWeaopen;
    private SelectBox<String> SelectTime;
    private TextButton back;

    public PreGameMenu(PreGameMenucontroller controller) {
        this.controller = controller;
        selectHero = new SelectBox<>(GameAssets.getInstance().getSkin());
        selectWeaopen = new SelectBox<>(GameAssets.getInstance().getSkin());
        SelectTime = new SelectBox<>(GameAssets.getInstance().getSkin());
        back = new TextButton("Back", GameAssets.getInstance().getSkin());
        controller.setPreGameMenu(this);
    }

    public SelectBox<String> getSelectTime() {
        return SelectTime;
    }

    public SelectBox<String> getSelectWeaopen() {
        return selectWeaopen;
    }

    public SelectBox<String> getSelectHero() {
        return selectHero;
    }

    public TextButton getBack() {
        return back;
    }

    @Override
    public void show() {
        Array<String> Heros = GameAssets.getInstance().getHeros();
        Array<String> WeaOpen = GameAssets.getInstance().getWeaOpen();
        Array<String> Time = GameAssets.getInstance().gettimes();
        selectWeaopen.setItems(WeaOpen);
        selectHero.setItems(Heros);
        SelectTime.setItems(Time);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);
        table.add(new Label("Select Hero", GameAssets.getInstance().getSkin()));
        table.padLeft(20);
        table.add(selectHero);
        table.padTop(20);
        table.add(new Label("Select WeaOpen", GameAssets.getInstance().getSkin()));
        table.padLeft(20);
        table.add(selectWeaopen);
        table.padTop(20);
        table.add(new Label("Select Time", GameAssets.getInstance().getSkin()));
        table.padLeft(20);
        table.add(SelectTime);
        back.setPosition(Gdx.graphics.getWidth() - 300, Gdx.graphics.getHeight() - 300);
        stage.addActor(back);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.ApplyScrren();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
