package com.Tilldawn.Controller;

import com.Tilldawn.Controller.ModelsController.BulletController;
import com.Tilldawn.Controller.ModelsController.EnemyController;
import com.Tilldawn.Controller.ModelsController.PlayerController;
import com.Tilldawn.Controller.ModelsController.SeedController;
import com.Tilldawn.View.GameMenu;
import com.Tilldawn.model.*;
import com.Tilldawn.model.Enums.Abilites;

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

    public void Update(float Delta)
    {
        if(gameMenu.getTable().isVisible()) {
            girdController.update();
            playerController.Update(Delta);
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
    }
}
