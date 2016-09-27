package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyLabel implements ApplicationListener {


    private Stage stage;
    private BitmapFont font;
    private Label.LabelStyle style;
    private Label label;


    @Override
    public void create() {
        font = new BitmapFont(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/tt1.fnt")
                , Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/tt1.png"), false);
        style = new Label.LabelStyle(font, font.getColor());
        label = new Label("hello libgdx", style);
        stage = new Stage();
        label.setPosition(50, 150);
        label.setFontScale(0.8f);
        label.setColor(Color.GREEN);
        stage.addActor(label);
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
