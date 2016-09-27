package com.example;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Scaling;

/**
 * Created by hansheng on 16-9-27.
 */

public class BgImage extends Image {

    public float getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(float deltaY) {
        this.deltaY = deltaY;
    }

    public float deltaY = 5;

    public void update() {
        float positionY = this.getY();
        if (positionY < -780) {
            positionY = 780;
        } else {
            positionY -= deltaY;
        }
        setY(positionY);
    }

    public BgImage(TextureRegion region) {
        super(region);
    }


    public BgImage(Drawable drawable, Scaling scaling, int align) {
        super(drawable, scaling, align);
        setScaling(scaling);
        setDrawable(drawable);
        setAlign(align);
        setWidth(getPrefWidth());
        setHeight(getImageHeight());
    }
}
