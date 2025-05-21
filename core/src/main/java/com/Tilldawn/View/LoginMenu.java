package com.Tilldawn.View;

import com.Tilldawn.Controller.LoginController;
import com.Tilldawn.Main;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;


public class LoginMenu implements Screen {
    private LoginController controller;
    private Stage stage;
    private TextField usernameField;
    private TextField passwordField;
    private TextField sequrityFeild;
    private TextButton loginButton;
    private TextButton ForgetButton;
    private Label errorLabel;
    private TextButton exitButton;

    public LoginMenu(LoginController controller) {
        usernameField = new TextField("Username" , GameAssets.getInstance().getSkin());
        passwordField = new TextField("Password" , GameAssets.getInstance().getSkin());
        sequrityFeild = new TextField("Security" , GameAssets.getInstance().getSkin());
        ForgetButton = new TextButton("Forget Pass", GameAssets.getInstance().getSkin());
        loginButton = new TextButton("Login", GameAssets.getInstance().getSkin());
        errorLabel = new Label("", GameAssets.getInstance().getSkin());
        exitButton = new TextButton("Exit", GameAssets.getInstance().getSkin());
        this.controller = controller;
        controller.setLoginMenu(this);
    }

    public Label getErrorLabel() {
        return errorLabel;
    }

    public TextButton getForgetButton() {
        return ForgetButton;
    }

    public TextButton getLoginButton() {
        return loginButton;
    }

    public TextField getSequrityFeild() {
        return sequrityFeild;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public TextButton getExitButton() {
        return exitButton;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table ExitTable = new Table();
        ExitTable.setFillParent(true);
        ExitTable.top().left();
        ExitTable.add(exitButton);
        stage.addActor(ExitTable);

        Table table = new Table();
        table.setFillParent(true);
        table.add(new Label("LoginMenu", GameAssets.getInstance().getSkin()));
        table.row().padTop(30);
        table.add(usernameField).width(300);
        table.row().padTop(10);
        table.add(passwordField).width(300);
        table.row().padTop(10);
        table.add(sequrityFeild).width(300);
        table.row().padTop(10);
        table.add(ForgetButton).width(100);

        table.add(loginButton).width(100);
        table.row().padTop(10);
        table.add(errorLabel).width(500);
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
