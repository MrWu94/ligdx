package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by hansheng on 16-9-27.
 */

public class MyDelta implements ApplicationListener {

    Stage stage;
    TextureAtlas atlas;
    TextureRegion textureRegion;
    BgImage bgImage1;
    BgImage bgImage2;

    @Override
    public void create() {
        stage=new Stage();
        atlas=new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/changescreen.atlas"));
        textureRegion=atlas.findRegion("liushishi");
        bgImage1=new BgImage(textureRegion);
        bgImage1.setSize(480,480);
        bgImage2=new BgImage(textureRegion);
        bgImage2.setSize(480,800);
        bgImage2.setPosition(0,800);
        stage.addActor(bgImage1);
        stage.addActor(bgImage2);
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        bgImage1.update();
        bgImage2.update();
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
