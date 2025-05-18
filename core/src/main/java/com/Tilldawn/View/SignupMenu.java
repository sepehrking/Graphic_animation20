package com.Tilldawn.View;

import com.Tilldawn.Controller.SignUpcontroller;
import com.Tilldawn.Main;
import com.Tilldawn.model.GameAssets;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


public class SignupMenu implements Screen {
    Stage stage;
    private Label ErrorMassage;
    private SignUpcontroller controller;
    private TextField UsernameField;
    private TextField PasswordField;
    private TextField SequrityFeild;
    private TextButton ConfirmButton;
    private Table table;

    public SignupMenu(SignUpcontroller controller) {
        table = new Table();
        ErrorMassage = new Label("" , GameAssets.getInstance().getSkin());
        UsernameField = new TextField("Username" , GameAssets.getInstance().getSkin());
        PasswordField = new TextField("Password" , GameAssets.getInstance().getSkin());
        ConfirmButton = new TextButton("Confirm" , GameAssets.getInstance().getSkin());
        SequrityFeild = new TextField("" , GameAssets.getInstance().getSkin());
        this.controller = controller;
        controller.SetMenu(this);
    }

    @Override
    public void show() {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table.center();
        table.setFillParent(true);
        table.add(new Label("Welcome to the Game let's Signup", GameAssets.getInstance().getSkin()));
        table.row().padTop(30);
        table.add(UsernameField).width(300);
        table.row().padTop(10);
        table.add(PasswordField).width(300);
        table.row().padTop(10);
        table.add(new Label("What is your favorite Color" , GameAssets.getInstance().getSkin()));
        table.add(SequrityFeild).width(300);
        table.row().padTop(10);
        table.add(ConfirmButton).width(50);
        table.row().padTop(10);
        table.add(ErrorMassage).width(500);

        this.stage.addActor(table);
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


    public Stage getStage() {
        return stage;
    }

    public SignUpcontroller getController() {
        return controller;
    }

    public TextField getUsernameField() {
        return UsernameField;
    }

    public TextField getPasswordField() {
        return PasswordField;
    }

    public Table getTable() {
        return table;
    }

    public TextButton getConfirmButton() {
        return ConfirmButton;
    }

    public Label getErrorMassage() {
        return ErrorMassage;
    }

    public TextField getSequrityFeild() {
        return SequrityFeild;
    }
}
