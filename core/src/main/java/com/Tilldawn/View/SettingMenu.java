package com.Tilldawn.View;

import com.Tilldawn.Controller.SettingController;
import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class SettingMenu implements Screen {
    private SettingController controller;
    private Stage stage;
    private Slider VoloumSlider;
    private SelectBox<String> SelectMusic;
    private CheckBox SfxChecker;
    private CheckBox AutoReload;
    private TextButton EXIT;



    public TextButton getEXIT() {
        return EXIT;
    }

    public SettingMenu(SettingController controller) {
        VoloumSlider = new Slider(0f , 1f , 0.01f , false , GameAssets.getInstance().getSkin());
        SelectMusic = new SelectBox<>(GameAssets.getInstance().getSkin());
        SfxChecker = new CheckBox("Enable SFX" , GameAssets.getInstance().getSkin());
        AutoReload = new CheckBox("Auto Reload" , GameAssets.getInstance().getSkin());
        EXIT = new TextButton("Back to MainMenu", GameAssets.getInstance().getSkin());
        this.controller = controller;
        controller.setSettingMenu(this);
    }

    public CheckBox getAutoReload() {
        return AutoReload;
    }

    public SelectBox<String> getSelectMusic() {
        return SelectMusic;
    }

    public CheckBox getSfxChecker() {
        return SfxChecker;
    }

    public Slider getVoloumSlider() {
        return VoloumSlider;
    }

    @Override
    public void show() {
        SfxChecker.setChecked(App.ReturnCurrentGame().getPregame().getSFX());
        AutoReload.setChecked(App.ReturnCurrentGame().getPregame().isAutoReload());
        VoloumSlider.setValue(App.ReturnCurrentGame().getPregame().getVoulume());
        Array<String> musics = GameAssets.getInstance().GetMusics();
        SelectMusic.setItems(musics);
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Table ExitTable = new Table();
        ExitTable.setFillParent(true);
        ExitTable.top().left();
        ExitTable.add(EXIT);
        stage.addActor(ExitTable);

        Table table = new Table();
        table.setFillParent(true);
        table.center();
        table.add(new Label("Setting" , GameAssets.getInstance().getSkin()));
        table.row().padTop(50);
        table.add(new Label("Voloum", GameAssets.getInstance().getSkin()));
        table.padLeft(20);
        table.add(VoloumSlider);
        table.row().padTop(20);
        table.add(new Label("Music" , GameAssets.getInstance().getSkin()));
        table.padLeft(20);
        table.add(SelectMusic);
        table.row().padTop(20);
        table.add(SfxChecker);
        table.row().padTop(20);
        table.add(AutoReload);
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
