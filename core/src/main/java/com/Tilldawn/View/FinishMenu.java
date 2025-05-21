package com.Tilldawn.View;

import com.Tilldawn.Controller.FinishMenuController;
import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;

public class FinishMenu implements Screen {

    private Stage stage;
    private FinishMenuController controller;

    public FinishMenu(FinishMenuController controller) {
        this.controller = controller;
        controller.setFinishMenu(this);
    }

    @Override
    public void show() {
        Table table = new Table();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.add(new Label("Username :   " + App.ReturnCurrentUser().getUseranme(), GameAssets.getInstance().getSkin()));
        table.row().padTop(20);
        table.add(new Label("Time Alived" + App.ReturnCurrentGame().getTimer().getTime() , GameAssets.getInstance().getSkin()));
        table.row().padTop(20);
        table.add(new Label("Kills   : " + App.ReturnCurrentGame().getPlayer().getKills() , GameAssets.getInstance().getSkin()));
        table.row().padTop(20);
        table.add(new Label("Point  : " + App.ReturnCurrentGame().getPlayer().getKills() * App.ReturnCurrentGame().getTimer().getTime() , GameAssets.getInstance().getSkin()));
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
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
