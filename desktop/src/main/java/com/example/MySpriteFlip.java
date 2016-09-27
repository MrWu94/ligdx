package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by hansheng on 16-9-26.
 */

public class MySpriteFlip implements ApplicationListener {

    Stage stage;
    TextureRegion region;
    Texture texture;
    SpriteBatch batch;
    @Override
    public void create() {
        stage=new Stage();
        texture=new Texture(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/huge.jpg"));
        region=new TextureRegion(texture,0,0,400,400);
        batch=new SpriteBatch();

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(region,0,0,128,128,256,256,1,1,0);
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
