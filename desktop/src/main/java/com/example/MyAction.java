package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hansheng on 16-9-27.
 */

public class MyAction implements ApplicationListener {

    Stage stage;
    TextureAtlas atlas;
    TextureRegion textureRegion;
    TextureRegion scaleRegion;
    TextureRegion yidongRegion;
    Image retateImage;
    Image scaleImage;
    Image yidongImage;

    @Override
    public void create() {
        stage = new Stage();
        atlas = new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/event.atlas"));
        yidongRegion = atlas.findRegion("youjiantou");
        yidongImage = new Image(yidongRegion);
        yidongImage.setPosition(200, 400);
        yidongImage.addAction(Actions.sequence(Actions.moveTo(300, 700, 1), Actions.moveTo(100, 700, 1)));
        stage.addActor(yidongImage);
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
