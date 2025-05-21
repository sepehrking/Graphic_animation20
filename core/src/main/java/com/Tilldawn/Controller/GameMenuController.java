package com.Tilldawn.Controller;

import com.Tilldawn.Controller.ModelsController.BulletController;
import com.Tilldawn.Controller.ModelsController.EnemyController;
import com.Tilldawn.Controller.ModelsController.PlayerController;
import com.Tilldawn.Controller.ModelsController.SeedController;
import com.Tilldawn.Main;
import com.Tilldawn.View.DestroyedAnimation;
import com.Tilldawn.View.FinishMenu;
import com.Tilldawn.View.GameMenu;
import com.Tilldawn.model.*;
import com.Tilldawn.model.Enums.Abilites;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Animation;

public class GameMenuController {
    private Player player;
    private PlayerController playerController;
    private GirdController girdController;
    private EnemyController enemyController;
    private GameMenu gameMenu;
    private BulletController bulletController = new BulletController();
    private SeedController seedController = new SeedController();

    public EnemyController getEnemyController() {
        return enemyController;
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public GameMenuController() {
        playerController = new PlayerController();
        enemyController = new EnemyController();
        //playerController.setPlayer();
        player = new Player();
        App.ReturnCurrentGame().setPlayer(player);
        girdController = new GirdController(player);
        playerController.setPlayer(player , girdController);
    }

    public Player getPlayer() {
        return player;
    }

    public void Update(float Delta , Camera camera)
    {
        if(gameMenu.getTable().isVisible()) {
            gameMenu.getHpLabel().setText("Hp :  " + App.ReturnCurrentGame().getPlayer().getHp());
            String OKTime =  String.format("%.1f" , App.ReturnCurrentGame().getTimer().getTime());
            gameMenu.getTime().setText("Time :  " + OKTime);
            gameMenu.getKillsLabel().setText(App.ReturnCurrentGame().getPlayer().getKills());
            gameMenu.getAmmoLable().setText("Ammo :  " + App.ReturnCurrentGame().getPlayer().getWeopenC().getAmoo());
            gameMenu.getLevelLable().setText("Level :  " + App.ReturnCurrentGame().getPlayer().getLevel());
            girdController.update();
            playerController.Update(Delta , camera);
            for (Enemy enemy : App.ReturnCurrentGame().getEnemies()) {
                enemyController.Update(enemy, Delta);
            }
            for (Bullet bullet : App.ReturnCurrentGame().getBullets()) {
                bulletController.Update(bullet, Delta);
            }
            for (Seed seed : App.ReturnCurrentGame().getSeeds()) {
                seedController.update(seed, Delta);
            }
            if (App.ReturnCurrentGame().isISLEVELUP()) {
                gameMenu.getPauseMenu().setVisible(false);
                gameMenu.getTable().setVisible(false);
                gameMenu.getChooseAbilityTable().setVisible(true);
                String firstAbility = Abilites.DAMAGER.toString() , secondAbility = Abilites.AMOCREASE.toString() , thirdAbility = Abilites.PRECREASE.toString();
                gameMenu.getFirstAbility().setText(firstAbility);
                gameMenu.getSecondAbility().setText(secondAbility);
                gameMenu.getThirdAbility().setText(thirdAbility);
                App.ReturnCurrentGame().setISLEVELUP(false);
            }
            if(gameMenu.getPauseGame().isChecked()) {
                gameMenu.getPauseMenu().setVisible(true);
                gameMenu.getTable().setVisible(false);
                gameMenu.getChooseAbilityTable().setVisible(false);
                gameMenu.getPauseGame().setChecked(false);
            }
            App.ReturnCurrentGame().getTimer().IncreaseTime(Delta);
            if (App.ReturnCurrentGame().getTimer().getTacnecalMonsterSpawn() > 3) {
                for (int i = 0; i < Delta / 10; i++) {
                    enemyController.getTenteacontroller().CreateTentacleMonster();
                    App.ReturnCurrentGame().getTimer().setTacnecalMonsterSpawn(0);
                }
            }
            if (App.ReturnCurrentGame().getTotalTime() / 4 < App.ReturnCurrentGame().getTimer().getTime()) {
                if (App.ReturnCurrentGame().getTimer().getEyebatSpawn() > 10) {
                    for (int i = 0; i < (4 * App.ReturnCurrentGame().getTimer().getTime() - App.ReturnCurrentGame().getTotalTime() + 30) / 30; i++) {
                        enemyController.getEyecontroller().CreateEyeBatMonster();
                    }
                    App.ReturnCurrentGame().getTimer().setEyebatSpawn(0);
                }
            }
            ApplyExplosion(Delta);
            CheckEndGame();
        }

        if(gameMenu.getChooseAbilityTable().isVisible()) {
            CharSequence Ability = null;
            if(gameMenu.getFirstAbility().isChecked())
            {
                Ability = gameMenu.getFirstAbility().getText();
            }
            if(gameMenu.getSecondAbility().isChecked())
            {
                Ability = gameMenu.getSecondAbility().getText();
            }
            if(gameMenu.getThirdAbility().isChecked())
            {
                Ability = gameMenu.getThirdAbility().getText();
            }
            if(Ability != null) {
                for (Abilites ability : Abilites.values()) {
                    if (ability.toString().contentEquals(Ability)) {
                        if(ability == Abilites.DAMAGER) {
                            player.getAbillityController().DAMAGER();
                        }
                        if(ability == Abilites.VITALITY) {
                            player.getAbillityController().VITALITY();
                        }
                        if(ability == Abilites.SPEEDY) {
                            player.getAbillityController().SPEEDY();
                        }
                        if(ability == Abilites.PRECREASE) {
                            player.getAbillityController().PRECREASE();
                        }
                        if(ability == Abilites.AMOCREASE) {
                            player.getAbillityController().AMOCREASE();
                        }
                    }
                }
                gameMenu.getChooseAbilityTable().setVisible(false);
                gameMenu.getTable().setVisible(true);
                gameMenu.getPauseMenu().setVisible(false);
            }
            gameMenu.getThirdAbility().setChecked(false);
            gameMenu.getSecondAbility().setChecked(false);
            gameMenu.getFirstAbility().setChecked(false);
        }

        if(gameMenu.getPauseMenu().isVisible()) {
            if(gameMenu.getResume().isChecked()) {
                gameMenu.getPauseMenu().setVisible(false);
                gameMenu.getTable().setVisible(true);
                gameMenu.getChooseAbilityTable().setVisible(false);
                gameMenu.getResume().setChecked(false);
            }
        }
    }

    public void ApplyExplosion(float delta)
    {
        for(int i = App.ReturnCurrentGame().getDestroyedAnimations().size() - 1 ; i >= 0 ; i--)
        {
            DestroyedAnimation d = App.ReturnCurrentGame().getDestroyedAnimations().get(i);
            d.getSprite().setPosition(d.getX(), d.getY());
            d.getSprite().setRegion(d.getAnimation().getKeyFrame(d.getTime()));

            if(!d.getAnimation().isAnimationFinished(d.getTime()))
            {
                d.setTime(d.getTime() + delta);
            }
            else
            {
                //d.setTime(0);
                 App.ReturnCurrentGame().getDestroyedAnimations().remove(i);
            }
            d.getSprite().draw(Main.getBatch());
            d.getAnimation().setPlayMode(Animation.PlayMode.LOOP);
        }
    }

    public void CheckEndGame()
    {
        boolean gameOver = false;
        if(App.ReturnCurrentGame().getPlayer().getHp() < 0)
        {
            gameOver = true;
        }
        if(App.ReturnCurrentGame().getTotalTime() < App.ReturnCurrentGame().getTimer().getTime())
        {
            gameOver = true;
        }
        if(gameOver)
        {
            Main.getMain().setScreen(new FinishMenu(new FinishMenuController()));
        }
    }

}
