package com.Tilldawn.View;

import com.Tilldawn.Controller.MainMenuController;
import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenu implements Screen {

    private MainMenuController controller;
    private Stage stage;
    private TextButton Setting;
    private TextButton Profile;
    private TextButton PregameMenu;
    private TextButton ScoreBoard;
    private TextButton Talents;
    private TextButton ContiniueExistingGame;
    private TextButton Logout;
    private Image AvatarImage;
    private TextButton StartGame;
    public MainMenu(MainMenuController controller) {
        Texture texture = new Texture(Gdx.files.internal(App.ReturnCurrentUser().getAvatar().Path_Avatars));
        AvatarImage = new Image(texture);
        StartGame = new TextButton("Start Game", GameAssets.getInstance().getSkin());
        Setting = new TextButton("Setting" , GameAssets.getInstance().getSkin());
        Profile = new TextButton("Profile" , GameAssets.getInstance().getSkin());
        PregameMenu = new TextButton("Pregame" , GameAssets.getInstance().getSkin());
        ScoreBoard = new TextButton("ScoreBoard" , GameAssets.getInstance().getSkin());
        Talents = new TextButton("Talents", GameAssets.getInstance().getSkin());
        ContiniueExistingGame = new TextButton("Continue Saved Game", GameAssets.getInstance().getSkin());
        Logout = new TextButton("Logout", GameAssets.getInstance().getSkin());
       this.controller = controller;
        controller.setMainMenu(this);
    }

    public TextButton getSetting() {
        return Setting;
    }

    public TextButton getProfile() {
        return Profile;
    }

    public TextButton getScoreBoard() {
        return ScoreBoard;
    }

    public TextButton getTalents() {
        return Talents;
    }

    public TextButton getPregameMenu() {
        return PregameMenu;
    }

    public TextButton getStartGame() {
        return StartGame;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Table table = new Table();
        table.top().left().padTop(100).padLeft(100);
        table.setFillParent(true);
        table.add(new Label("PreGame Menu", GameAssets.getInstance().getSkin()));
        table.row().padTop(30);
        table.add(Setting);
        table.row().padTop(10);
        table.add(Profile);
        table.row().padTop(10);
        table.add(PregameMenu);
        table.row().padTop(10);
        table.add(ScoreBoard);
        table.row().padTop(10);
        table.add(Talents);
        stage.addActor(table);

        Table StartTable= new Table();
        StartTable.setFillParent(true);
        StartTable.center();
        StartTable.add(StartGame);
        stage.addActor(StartTable);

        Table RighTable = new Table();
        RighTable.setFillParent(true);
        RighTable.top().right().padTop(100).padRight(40);
        //Show Avatar
        RighTable.add(AvatarImage).width(80).height(80);
        RighTable.row();
        RighTable.add(new Label("Username  :  " + App.ReturnCurrentUser().getUseranme(), GameAssets.getInstance().getSkin()));
        RighTable.row().padTop(10);
        RighTable.add(new Label("Point   :   " + App.ReturnCurrentUser().getPoint(), GameAssets.getInstance().getSkin()));
        RighTable.row().padTop(40);
        RighTable.add(ContiniueExistingGame);
        RighTable.row().padTop(10);
        RighTable.add(Logout);
        stage.addActor(RighTable);
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0, 1);
        Main.getBatch().begin();
        Main.getBatch().end();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
        controller.ApplyScreen();
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
