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
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class FinishMenu implements Screen {

    private Stage stage;
    private FinishMenuController controller;
    private TextButton Goback;

    public TextButton getGoback() {
        return Goback;
    }

    public FinishMenu(FinishMenuController controller) {
        this.controller = controller;
        controller.setFinishMenu(this);
        Goback = new TextButton("Back to Main Menu" , GameAssets.getInstance().getSkin());
    }

    @Override
    public void show() {
        if(App.UserLoginId != -1)
        {
            App.UpdateGame();
        }
        Table table = new Table();
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        if(App.UserLoginId != -1) {
            table.add(new Label("Username :   " + App.ReturnCurrentUser().getUseranme(), GameAssets.getInstance().getSkin()));
            table.row().padTop(20);
        }
        else
        {
            table.add(new Label("You are guest :   ", GameAssets.getInstance().getSkin()));
            table.row().padTop(20);
        }
        table.add(new Label("Time Alived" + App.ReturnCurrentGame().getTimer().getTime() , GameAssets.getInstance().getSkin()));
        table.row().padTop(20);
        table.add(new Label("Kills   : " + App.ReturnCurrentGame().getPlayer().getKills() , GameAssets.getInstance().getSkin()));
        table.row().padTop(20);
        table.add(new Label("Point  : " + App.ReturnCurrentGame().getPlayer().getKills() * App.ReturnCurrentGame().getTimer().getTime() , GameAssets.getInstance().getSkin()));
        table.row().padTop(20);
        table.add(Goback);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.Update();
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
