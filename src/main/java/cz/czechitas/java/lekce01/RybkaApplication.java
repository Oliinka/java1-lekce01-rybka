package cz.czechitas.java.lekce01;

import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import cz.czechitas.java.playground.CzechitasGameApplication;
import cz.czechitas.java.playground.Kamen;
import cz.czechitas.java.playground.Rybka;
import javafx.scene.paint.Color;

public class RybkaApplication extends CzechitasGameApplication {
  private Rybka rybka;
  private Kamen kamen;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  protected void initSettings(GameSettings settings) {
    settings.setNative(true);
    settings.setWidth(800);
    settings.setHeight(600);
    settings.setTitle("Rybka Renata");
    settings.setVersion("1.0");
  }

  @Override
  protected void initGame() {
    FXGL.getGameScene().setBackgroundColor(Color.AQUA);
    super.initGame();
  }

  @Override
  protected void onStart() {
    kamen = new Kamen(200, 200);
    rybka = new Rybka(100, 100);

    // Move the fish around the stone using a loop
    moveRybkaMultipleTimes(rybka, 20, () -> rybka.plavatVpravo());
    moveRybkaMultipleTimes(rybka, 20, () -> rybka.plavatDolu());
    moveRybkaMultipleTimes(rybka, 20, () -> rybka.plavatVlevo());
    moveRybkaMultipleTimes(rybka, 20, () -> rybka.plavatNahoru());
  }
    private void moveRybkaMultipleTimes(Rybka rybka, int times, Runnable movementMethod) {
      for (int i = 0; i < times; i++) {
        movementMethod.run();
      }

    }

  }

