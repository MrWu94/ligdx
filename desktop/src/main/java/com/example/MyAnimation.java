package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyAnimation implements ApplicationListener {


    SpriteBatch batch;
    Animation animation;
    Texture texture;
    TextureRegion temp[][];//纹理，简单理解成图像信息的容器
    TextureRegion region[];
    TextureRegion keyFrameRegion;
    float stateTime;


    @Override
    public void create() {

        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/bee.png"));
        temp = TextureRegion.split(texture, texture.getWidth() / 6, texture.getHeight() / 5);
        region = new TextureRegion[5 * 6];
        int i;
        int j;
        int index = 0;
        for (i = 0; i < 5; ++i) {
            for (j = 0; j < 6; ++j) {
                region[index++] = temp[i][j];
            }
        }
        animation = new Animation(0.025f, region);
        animation.setPlayMode(Animation.PlayMode.LOOP_REVERSED);


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stateTime += Gdx.graphics.getDeltaTime();
        keyFrameRegion = animation.getKeyFrame(stateTime, true);
        batch.begin();
        batch.draw(keyFrameRegion, 240, 400);
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
