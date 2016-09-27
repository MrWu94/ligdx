package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyFlip implements ApplicationListener {


    Stage stage;
    Texture texture;
    TextureRegion region;
    Image image;

    @Override
    public void create() {

        stage = new Stage();
        texture = new Texture(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/huge.jpg"));
        region = new TextureRegion(texture, 0, 0, 200, 200);
        region.flip(true, false);
        image = new Image(region);
        stage.addActor(image);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

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
