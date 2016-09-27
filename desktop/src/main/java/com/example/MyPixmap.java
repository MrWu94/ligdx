package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyPixmap implements ApplicationListener {

    SpriteBatch batch;
    TextureRegion textureRegion;
    Texture texture;
    Pixmap pixmap;

    @Override
    public void create() {

        batch = new SpriteBatch();
        texture = new Texture(1024, 1024, Pixmap.Format.RGBA8888);
        pixmap = new Pixmap(800, 480, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLUE);
        pixmap.drawLine(0, 0, 100, 100);
        pixmap.drawCircle(150, 150, 32);
        pixmap.drawRectangle(0, 0, 100, 100);
        pixmap.fillCircle(200, 200, 32);
        pixmap.fillRectangle(0, 200, 50, 50);

        pixmap.drawPixmap(new Pixmap(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/huge.jpg")), 200, 0);
        pixmap.drawPixel(150, 0, 0);

        texture.draw(pixmap, 0, 0);
        textureRegion = new TextureRegion(texture, 800, 480);


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(textureRegion, 0, 0);
        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
