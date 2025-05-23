package com.Tilldawn.View;

import com.Tilldawn.Controller.GameMenuController;
import com.Tilldawn.Main;
import com.Tilldawn.model.App;
import com.Tilldawn.model.GameAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class GameMenu implements Screen {
    private OrthographicCamera camera;
    private GameMenuController controller;
    private Stage stage;
    private Label HpLabel;
    private Label Time;
    private Table table = new Table();
    private Table PauseMenu = new Table();
    private Table ChooseAbilityTable = new Table();
    private TextButton FirstAbility;
    private TextButton SecondAbility;
    private TextButton ThirdAbility;
    private TextButton PauseGame;
    private TextButton Resume;
    private TextButton GiveUP;
    private Label KillsLabel;
    private Label AmmoLable;
    private Label LevelLable;

    public Label getAmmoLable() {
        return AmmoLable;
    }

    public Label getLevelLable() {
        return LevelLable;
    }

    public Label getKillsLabel() {
        return KillsLabel;
    }

    public Label getHpLabel() {
        return HpLabel;
    }



    public Label getTime() {
        return Time;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public Table getPauseMenu() {
        return PauseMenu;
    }

    public Table getChooseAbilityTable() {
        return ChooseAbilityTable;
    }

    public TextButton getFirstAbility() {
        return FirstAbility;
    }

    public Table getTable() {
        return table;
    }

    public TextButton getSecondAbility() {
        return SecondAbility;
    }

    public TextButton getThirdAbility() {
        return ThirdAbility;
    }

    public TextButton getPauseGame() {
        return PauseGame;
    }

    public TextButton getGiveUP() {
        return GiveUP;
    }

    public TextButton getResume() {
        return Resume;
    }

    public GameMenu(GameMenuController controller) {
        this.controller = controller;
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        HpLabel = new Label("Hp :  " + 10 , GameAssets.getInstance().getSkin());
        Time = new Label("Time :  " + 10 , GameAssets.getInstance().getSkin());
        FirstAbility = new TextButton("First Ability", GameAssets.getInstance().getSkin());
        SecondAbility = new TextButton("Second Ability", GameAssets.getInstance().getSkin());
        ThirdAbility = new TextButton("Third Ability", GameAssets.getInstance().getSkin());
        controller.setGameMenu(this);
        PauseGame = new TextButton("Pause", GameAssets.getInstance().getSkin());
        GiveUP = new TextButton("Give Up", GameAssets.getInstance().getSkin());
        Resume = new TextButton("Resume", GameAssets.getInstance().getSkin());
        KillsLabel = new Label("Kills :  0", GameAssets.getInstance().getSkin());
        LevelLable = new Label("Level :  1", GameAssets.getInstance().getSkin());
        AmmoLable = new Label("Ammo : " + App.ReturnCurrentGame().getWeopen().AmmoMAx, GameAssets.getInstance().getSkin());
    }

    @Override

    public void show() {
        stage = new Stage();
        table.setFillParent(true);
        ChooseAbilityTable.setFillParent(true);
        PauseMenu.setFillParent(true);
        table.setVisible(true);
        ChooseAbilityTable.setVisible(false);
        PauseMenu.setVisible(false);
        ChooseAbilityTable.add(FirstAbility);
        ChooseAbilityTable.padLeft(30);
        ChooseAbilityTable.add(SecondAbility);
        ChooseAbilityTable.padLeft(30);
        ChooseAbilityTable.add(ThirdAbility);
        stage.addActor(ChooseAbilityTable);
        for(int i = 0;i < App.ReturnCurrentGame().NUmberOfTreeMonsters ; i++) {
            controller.getEnemyController().getTreecontroller().CreateTree();
        }
        camera.position.set(Gdx.graphics.getWidth()/2f, Gdx.graphics.getHeight()/2f, 0);
        camera.update();
        Gdx.input.setInputProcessor(stage);
        table.setFillParent(true);
        table.top().left().padTop(20).padLeft(20);
        table.add(PauseGame).width(100);
        table.padTop(10);
        table.row();
        table.add(HpLabel);
        table.row();
        table.padTop(10);
        table.add(Time);
        table.row();
        table.add(KillsLabel);
        table.row();
        table.add(LevelLable);
        table.row();
        table.add(AmmoLable);
        stage.addActor(table);

        Table CenterTable = new Table();
        CenterTable.center();
        CenterTable.setFillParent(true);
        CenterTable.add(Resume).width(300);
        CenterTable.row().padTop(10);
        CenterTable.add(GiveUP).width(300);

        Table CheatcodesTable = new Table();
        CheatcodesTable.left();
        CheatcodesTable.setFillParent(true);
        ArrayList<String> Cheat = GameAssets.getInstance().CheatCodes();
        for(String C : Cheat) {
            CheatcodesTable.add(new Label(C , GameAssets.getInstance().getSkin()));
            CheatcodesTable.row();
        }
        PauseMenu.addActor(CheatcodesTable);
        PauseMenu.addActor(CenterTable);
        stage.addActor(PauseMenu);
    }

    @Override
    public void render(float v) {

        /*if(App.ReturnCurrentGame().getPlayer().getHp() < 0)
        {
            Gdx.app.exit();
        }*/
        float heroX = controller.getPlayer().getPosX();
        float heroY = controller.getPlayer().getPosY();
        camera.position.set(heroX, heroY, 0);
        camera.update();
        ScreenUtils.clear(0 , 0 , 0 , 1);
        Main.getBatch().setProjectionMatrix(camera.combined);
        Main.getBatch().begin();
        controller.Update(v , camera);
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
