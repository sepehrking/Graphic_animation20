package com.Tilldawn.View;

import com.Tilldawn.Controller.StartMenuController;
import com.Tilldawn.Main;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class StartMenu implements Screen {

    private Stage stage;
    private StartMenuController controller;
    private TextButton Signup;
    private TextButton Login;
    private TextButton Guest;
    private TextButton Exit;

    public TextButton getSignup() {
        return Signup;
    }

    public TextButton getLogin() {
        return Login;
    }

    public TextButton getGuest() {
        return Guest;
    }

    public TextButton getExit() {
        return Exit;
    }

    public StartMenu(StartMenuController controller) {
        this.controller = controller;
        controller.setStartMenu(this);
        Signup = new TextButton("Signup for new user" , GameAssets.getInstance().getSkin());
        Login = new TextButton("Login for existing user" , GameAssets.getInstance().getSkin());
        Guest = new TextButton("Play as guest" , GameAssets.getInstance().getSkin());
        Exit = new TextButton("Exit" , GameAssets.getInstance().getSkin());
    }

    @Override
    public void show() {
        Table table = new Table(GameAssets.getInstance().getSkin());
        table.setFillParent(true);
        stage = new Stage();
        Exit.setPosition(Gdx.graphics.getWidth() / 8 , Gdx.graphics.getHeight() / 8);
        table.add(Exit).width(200);
        table.center();
        table.row();
        Gdx.input.setInputProcessor(stage);
        table.add(Signup).width(600);
        table.row().pad(50);
        table.add(Login).width(600);
        table.row().pad(50);
        table.add(Guest).width(600);
        stage.addActor(table);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.CheckScreen();
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
