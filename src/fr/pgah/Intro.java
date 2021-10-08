package fr.pgah;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;

public class Intro extends ApplicationAdapter {
  SpriteBatch batch;
  Texture img;
  int x;
  int y;
  int hauteurFenetre;
  int largeurFenetre;
  int hauteurImg;
  int largeurImg;
  int directionEnY; // 0 pour monter et 1 pour descendre
  int directionEnX;

  @Override
  public void create() {
    batch = new SpriteBatch();
    img = new Texture("sio.jpg");
    x = 0;
    y = 0;
    hauteurFenetre = Gdx.graphics.getHeight();
    largeurFenetre = Gdx.graphics.getWidth();
    hauteurImg = img.getHeight();
    largeurImg = img.getWidth();
    directionEnY = 0;


  }

  @Override
  public void render() {
    ScreenUtils.clear(1, 0, 0, 1);

    // if (tape la bordure haute)
    if (y + hauteurImg == hauteurFenetre) {
      directionEnY = 1;
    }
    if (y==0) {
      directionEnY = 0;
    }
    if (x + largeurImg == largeurFenetre) {
      directionEnX = 1;
    }
    if (x==0) {
      directionEnX = 0;
    }


    if (directionEnY == 0) {
      y = y +  1; // incrémentation
    } else {
      y = y - 1; // décrémentation
    }

    if (directionEnX == 0) {
      x = x +  1; // incrémentation
    } else {
      x = x - 1; // décrémentation
    }

    batch.begin();
    batch.draw(img, x, y);
    batch.end();
  }
}
