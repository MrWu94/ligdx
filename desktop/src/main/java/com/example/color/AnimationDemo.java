package com.example.color;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by hansheng on 16-9-27.
 */

public class AnimationDemo implements ApplicationListener {
    public TextureAtlas angleAtlas;
    public TextureRegion[] textureRegions;
    public TextureRegion[] textureFlipRegions;
    public TextureRegion[] textureNoSpeakRegions;
    public TextureRegion[] textureFlipNoSpeakRegions;
    public Animation angleAnimation;
    public Animation angleFlipAnimation;
    public static AnimatedImage animatedImage;
    public static AnimatedImage animatedFlipImage;

    Stage stage;
    Group group;


    @Override
    public void create() {
        stage = new Stage();
        group = new Group();
        angleAtlas = new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/big.atlas"));
        if (angleAtlas != null) {
            textureRegions = new TextureRegion[15];
            textureNoSpeakRegions = new TextureRegion[18];

            textureFlipRegions = new TextureRegion[15];
            textureFlipNoSpeakRegions = new TextureRegion[18];

            for (int i = 0; i < 33; i++) {
                if (i <= 14) {
                    if (i < 9) textureRegions[i] = angleAtlas.findRegion("000" + (i + 1));
                    else textureRegions[i] = angleAtlas.findRegion("00" + (i + 1));
                    textureFlipRegions[i] = textureRegions[i];
                } else {
                    textureFlipNoSpeakRegions[i - 15] = textureNoSpeakRegions[i - 15] = angleAtlas.findRegion("00" + (i + 1));

                }
            }
            angleAnimation = new Animation(0.15f, textureRegions);
            angleFlipAnimation = new Animation(0.15f, textureFlipRegions);
            animatedImage = new AnimatedImage(angleAnimation);
//            animatedImage.setPosition(50, 80);
            animatedFlipImage = new AnimatedImage(angleFlipAnimation);
            animatedFlipImage.setPosition(20, 60);

        }
//        stage.addActor(animatedImage);
        stage.addActor(animatedFlipImage);
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
