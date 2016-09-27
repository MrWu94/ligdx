package com.example.color;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by hansheng on 16-9-27.
 */

public class MyText implements ApplicationListener {

    public static TextureAtlas textAtlas;
    public static TextureRegion closeNormalRegion;
    public static TextureRegion closeDownRegion;
    public static TextureRegionDrawable closeNormalRegionDrawable;
    public static TextureRegionDrawable closeDownRegionDrawable;
    public static Button closeButton;
    private Button btnRGB;
    Stage stage;
    Music angleSpeak03;
    AnimatedImage fingerAnimatedImage;
    Music fingerMusic;
    private Button btnSanjianse;

    @Override
    public void create() {
        stage = new Stage();
        textAtlas = new TextureAtlas(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/text.atlas"));
        closeNormalRegion = textAtlas.findRegion("close_normal");
        closeDownRegion = textAtlas.findRegion("close_down");
        closeNormalRegionDrawable = new TextureRegionDrawable(closeNormalRegion);
        closeDownRegionDrawable = new TextureRegionDrawable(closeDownRegion);
        closeButton = new Button(closeNormalRegionDrawable, closeDownRegionDrawable);
        closeButton.setPosition(1200, 710);
        closeButton.addListener(new ClickListener() {
                                    @Override
                                    public void clicked(InputEvent event, float x, float y) {
                                        Gdx.app.exit();
                                        super.clicked(event, x, y);
                                    }
                                }
        );
        stage.addActor(closeButton);
        initWelcomeStage();
        Gdx.input.setInputProcessor(stage);

    }


    void initWelcomeStage() {

        ImageResource red = new ImageResource(textAtlas, "red_big", 200, 100);
        Image redImage = red.createImage();
        redImage.addAction(Actions.sequence(Actions.delay(4f), Actions.scaleTo(2f, 2f, 0.2f)
                , Actions.scaleTo(1f, 1f, 0.2f), Actions.scaleTo(1.5f, 1.5f, 0.2f)
                , Actions.scaleTo(1f, 1f, 0.2f)));
//        Assets.welcomeStage.addActor(redImage);
        stage.addActor(redImage);
        ImageResource yellow = new ImageResource(textAtlas, "yellow_big", 400, 70);
        Image yellowImage = yellow.createImage();
        yellowImage.addAction(Actions.sequence(Actions.delay(5f), Actions.scaleTo(2f, 2f, 0.2f)
                , Actions.scaleTo(1f, 1f, 0.2f), Actions.scaleTo(1.5f, 1.5f, 0.2f)
                , Actions.scaleTo(1f, 1f, 0.2f)));
//        Assets.welcomeStage.addActor(yellowImage);
        stage.addActor(yellowImage);
        ImageResource blue = new ImageResource(textAtlas, "blue_big", 600, 100);
        Image blueImage = blue.createImage();
        blueImage.addAction(Actions.sequence(Actions.delay(6f), Actions.scaleTo(2f, 2f, 0.2f)
                , Actions.scaleTo(1f, 1f, 0.2f), Actions.scaleTo(1.5f, 1.5f, 0.2f)
                , Actions.scaleTo(1f, 1f, 0.2f)));
//        Assets.welcomeStage.addActor(blueImage);
        stage.addActor(blueImage);
        angleSpeak03 = Gdx.audio.newMusic(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/angle03.mp3"));
        angleSpeak03.play();
        Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                final Music right = Gdx.audio.newMusic(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/answer_right.mp3"));
                ImageResource btnSanyuanseResource = new ImageResource(textAtlas, "btn_sanyuan_normal"
                        , "btn_sanyuan_select", 0, 400, new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (fingerMusic != null && !fingerMusic.isPlaying()) {
                            right.play();
                        }
                        explainColor();
                    }
                });
                final Music notRight = Gdx.audio.newMusic(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/not_right.mp3"));
                btnRGB = btnSanyuanseResource.createButton();
//                Assets.welcomeStage.addActor(btnRGB);
                stage.addActor(btnRGB);
                ImageResource btnSanjianseResource = new ImageResource(textAtlas, "btn_sanjian_normal"
                        , "btn_sanjian_select", 475, 400, new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        if (fingerMusic != null && !fingerMusic.isPlaying())
                            notRight.play();
                        explainColor();

                    }
                });
                btnSanjianse = btnSanjianseResource.createButton();
//                Assets.welcomeStage.addActor(btnSanjianse);
                stage.addActor(btnSanjianse);
                AnimationResource animationResource = new AnimationResource("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/finger.atlas", 51, 0.1f, true);

                fingerAnimatedImage = animationResource.createAnimatedImage();
                fingerAnimatedImage.setPosition(300, 330);
//                Assets.welcomeStage.addActor(fingerAnimatedImage);
                stage.addActor(fingerAnimatedImage);


            }
        }, 7f);
        angleSpeak03.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                fingerMusic = Gdx.audio.newMusic(Gdx.files.internal("/home/hansheng/AndroidStudioProjects/ligdx/desktop/assets/data/finger.mp3"));
                fingerMusic.play();

            }
        });

    }

    private void explainColor() {
        btnSanjianse.addAction(Actions.fadeOut(0.3f));
//        Assets.welcomeStage.addActor(btnSanjianse);
        stage.addActor(btnSanjianse);
        btnSanjianse.remove();
        btnRGB.addAction(Actions.moveTo(300, 400, 0.5f));
//        Assets.welcomeStage.addActor(btnRGB);
        fingerAnimatedImage.remove();

//        Timer timer = new Timer();
//        timer.scheduleTask(new Timer.Task() {
//            @Override
//            public void run() {
//                ImageResource imageResource = new ImageResource(Assets.textAtlas
//                        , "btn_sanyuan_normal", 300, 400);
//                imgRGB = imageResource.createImage();
//                Assets.welcomeStage.addActor(imgRGB);
//                btnRGB.remove();
//
//            }
//        }, 0.5f);
//        timer.scheduleTask(new Timer.Task() {
//            @Override
//            public void run() {
//                Music music = Gdx.audio.newMusic(Gdx.files.internal("res/angle04.mp3"));
//                music.play();
//                music.setOnCompletionListener(new Music.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(Music music) {
//
//                        createStar();
//                        isDrawStar = true;
//                    }
//                });
//            }
//        }, 3f);


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
