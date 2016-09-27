package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyImage implements ApplicationListener {

    private Stage stage;
    private Image image;
    private Texture texture;
    private TextureRegion textureRegion;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        texture = new Texture(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/huge.jpg"));
        textureRegion = new TextureRegion(texture);
        image = new Image(textureRegion);
        image.setColor(Color.PINK);
        image.setPosition(230, 40);
        image.setOrigin(image.getWidth() / 2, image.getHeight() / 2);
        stage.addActor(image);


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
