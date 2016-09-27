package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyScrollPane implements ApplicationListener {
    Stage stage;
    ScrollPane scrollPane;
    ScrollPane.ScrollPaneStyle scrollPaneStyle;
    Image image[];
    Group group;

    @Override
    public void create() {
        stage = new Stage();
        group = new Group();
        group.setSize(256 * 30, 256);
        group.setSize(256, 512 * 30);

        image = new Image[30];
        int i;
        for (i = 0; i < 30; ++i) {
            image[i] = new Image(
                    new Texture(Gdx.files.
                            internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/shoushi.jpg")));
            image[i].setPosition(i * 256, 0);
            group.addActor(image[i]);
        }

        scrollPaneStyle=new ScrollPane.ScrollPaneStyle();
        scrollPaneStyle.background=null;
        scrollPane=new ScrollPane(group,scrollPaneStyle);
        scrollPane.setSize(480,256);
//        scrollPane.setScrollingDisabled(false,true);
        stage.addActor(scrollPane);
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
