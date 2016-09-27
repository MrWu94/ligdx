package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

/**
 * Created by hansheng on 16-9-27.
 */

public class MyButtonScrool implements ApplicationListener {

    Stage stage;
    ScrollPane scrollPane;
    ScrollPane.ScrollPaneStyle scrollPaneStyle;
    Group group;
    Image images[];
    TextureAtlas textureAtlas;
    Image zuojiantouImage;
    Image youjiantouImage;
    float deltaX = 250;

    @Override
    public void create() {

        stage = new Stage();
        group = new Group();
        group.setSize(256 * 30, 256);
        images = new Image[30];
        int i;
        for (i = 0; i < 30; i++) {
            images[i] = new Image(new Texture(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/shoushi.jpg")));
            images[i].setPosition(i * 256, 0);
            group.addActor(images[i]);

        }
        scrollPaneStyle=new ScrollPane.ScrollPaneStyle();
        scrollPaneStyle.background=null;
        scrollPane=new ScrollPane(group,scrollPaneStyle);
        scrollPane.setSize(480,800);
//        scrollPane.setScrollingDisabled(false,true);
        textureAtlas=new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/event.atlas"));
        zuojiantouImage=new Image(textureAtlas.findRegion("zuojiantou"));
        youjiantouImage=new Image(textureAtlas.findRegion("youjiantou"));
        zuojiantouImage.setPosition(100,500);
        youjiantouImage.setPosition(220,500);
        zuojiantouImage.setColor(Color.YELLOW);
        youjiantouImage.setColor(Color.YELLOW);
        zuojiantouImage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                float positionX=scrollPane.getScrollX();
                scrollPane.setScrollX(positionX-deltaX);
                return true;

            }
        });
        youjiantouImage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                float positionX=scrollPane.getScrollX();
                scrollPane.setScrollX(positionX-deltaX);
                return true;

            }
        });
        stage.addActor(scrollPane);
        stage.addActor(zuojiantouImage);
        stage.addActor(youjiantouImage);
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
