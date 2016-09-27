package com.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by hansheng on 16-9-26.
 */

public class MyGame implements ApplicationListener {

    SpriteBatch batch;
    BitmapFont font;
    Texture texture;
    SpriteBatch batchImage;
    TextureRegion textureRegion;
    Sprite sprite;


    @Override
    public void create() {
        texture = new Texture(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/huge.jpg"));
        textureRegion = new TextureRegion(texture, 0, 0, 100, 100);

        sprite = new Sprite(textureRegion);
        sprite.setPosition(100, 100);
        sprite.setRotation(45);
        sprite.setOrigin(0, 0);
        sprite.setScale(0.5f, 0.5f);


        batchImage = new SpriteBatch();
        batch = new SpriteBatch();


        font = new BitmapFont
                        (Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/tt1.fnt"),
                                Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/tt1.png"), false);
        font.setColor(Color.BLUE);


    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batchImage.begin();
        sprite.draw(batchImage);
        batchImage.end();
        batch.begin();
//
//        batchImage.begin();
//        batchImage.draw(textureRegion, 100, 100, 200, 200);
//        batchImage.draw(texture, 0, 0);
//        batchImage.end();
        font.draw(batch, "努力奋斗，快乐生活", 200, 600);
        font.draw(batch, "hello lidgdx", 100, 500);
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
