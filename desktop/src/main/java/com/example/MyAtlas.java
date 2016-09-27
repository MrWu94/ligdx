package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyAtlas implements ApplicationListener {

    SpriteBatch batch;
    TextureAtlas atlas;
    TextureRegion region1;
    TextureRegion region2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        atlas = new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/bee.atlas"));
        region1 = atlas.findRegion("00001");
//        region2=atlas.findRegion("00002");


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(region1, 200, 200);
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
