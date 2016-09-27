package com.example.color;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hansheng on 16-9-27.
 */

public class MyBackgroung implements ApplicationListener {

    public static Texture background;
    public static TextureRegion backgroundRegion;
    public static Image backgroundImage;
    Stage stage;

    public static Texture loadTexture(String file) {
        return new Texture(Gdx.files.internal(file));
    }
    @Override
    public void create() {
        stage=new Stage();
        background = loadTexture("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/welcome.png");
        backgroundRegion = new TextureRegion(background, 0, 0, 1280, 800);
        backgroundImage = new Image(backgroundRegion);
        backgroundImage.setBounds(0, 0, 1280, 800);
        stage.addActor(backgroundImage);


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
