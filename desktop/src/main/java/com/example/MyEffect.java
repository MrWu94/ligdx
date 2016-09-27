package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyEffect implements ApplicationListener {

    SpriteBatch batch;//画笔
    ParticleEffect effect;
    InputProcessor inputProcessor;
    float Position_X, Position_Y;

    @Override
    public void create() {

        batch = new SpriteBatch();
        effect = new ParticleEffect();
        effect.load(
                Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/effect.p"),
                Gdx.files.internal(""));
        inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int i) {
                return false;
            }

            @Override
            public boolean keyUp(int i) {
                return false;
            }

            @Override
            public boolean keyTyped(char c) {
                return false;
            }

            @Override
            public boolean touchDown(int i, int i1, int i2, int i3) {
                return false;
            }

            @Override
            public boolean touchUp(int i, int i1, int i2, int i3) {
                return false;
            }

            @Override
            public boolean touchDragged(int i, int i1, int i2) {
                Position_X = i;
                Position_Y = Gdx.graphics.getHeight() - i1;

                return false;
            }

            @Override
            public boolean mouseMoved(int i, int i1) {
                return false;
            }

            @Override
            public boolean scrolled(int i) {
                return false;
            }
        };
        Gdx.input.setInputProcessor(inputProcessor);


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        effect.setPosition(Position_X,Position_Y);
        batch.begin();
        effect.draw(batch,Gdx.graphics.getDeltaTime());
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
