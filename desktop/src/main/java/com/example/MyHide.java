package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by hansheng on 16-9-27.
 */

public class MyHide implements ApplicationListener {

    Stage stage;
    Group bgGroup1;
    Group bgGroup2;
    Image bgImage1;
    Image bgImage2;
    TextureAtlas atlas;


    @Override
    public void create() {
        stage = new Stage();
        atlas = new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/changescreen.atlas"));
        bgImage1 = new Image(atlas.findRegion("liushishi"));
        bgImage2 = new Image(atlas.findRegion("huge"));
        bgImage1.setSize(480, 800);
        bgImage2.setSize(480, 800);
        bgGroup1 = new Group();
        bgGroup2 = new Group();
        bgGroup1.addActor(bgImage1);
        bgGroup2.addActor(bgImage2);
        bgGroup2.setVisible(false);

        bgGroup1.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                bgGroup1.setVisible(false);
                bgGroup2.setVisible(true);
                return true;
            }
        });
        stage.addActor(bgGroup1);
        stage.addActor(bgGroup2);
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
