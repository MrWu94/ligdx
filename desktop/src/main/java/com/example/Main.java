package com.example;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.example.color.AnimationDemo;
import com.example.color.MyBackgroung;
import com.example.color.MyText;

/**
 * Created by hansheng on 16-9-26.
 */

public class Main {
    public static void main(String... args) {
        new LwjglApplication(new MyDelta(), "Hello", 1280, 800);
    }
}
