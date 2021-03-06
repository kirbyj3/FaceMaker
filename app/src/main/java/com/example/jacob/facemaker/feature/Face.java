package com.example.jacob.facemaker.feature;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;

import com.example.jacob.facemaker.RatioLocation;
import com.example.jacob.facemaker.feature.eye.EyeFactory;
import com.example.jacob.facemaker.feature.eye.Eyes;
import com.example.jacob.facemaker.feature.hair.Hair;
import com.example.jacob.facemaker.feature.hair.HairFactory;
import com.example.jacob.facemaker.feature.nose.Nose;
import com.example.jacob.facemaker.feature.nose.OvalNose;
import com.example.jacob.facemaker.feature.hair.SpikedHair;
import com.example.jacob.facemaker.feature.mouth.Mouth;
import com.example.jacob.facemaker.feature.head.Head;

import java.util.Random;

/*
This is my main face class. This is where all the features are created. All the getter and setter
methods for each feature are stored here and this is the gateway to drawing.
 */

public class Face extends AbstractFeature implements Feature {

    // all the features are created
    private Eyes eyes;
    private Head head;
    private Mouth mouth;
    private Hair hair;
    private Nose nose;

    public Face() {
        // these are default features and colors
        eyes = EyeFactory.getInstance(EyeFactory.CRAZY);
        head = new Head(Color.LTGRAY);
        mouth = new Mouth(Color.RED);
        nose = new  OvalNose(Color.BLACK);
        hair = new SpikedHair(Color.RED);
        //NOTE: the color of eyes is set in Eyes class
    }

    //This is where the features are drawn
    public void draw(Canvas c) {

        // rect is the rectangle for our surface space so that each feature can be
        //proportional to it
        Rect rect = c.getClipBounds();

        head.draw(c); // draws head
        hair.setLocation(new RatioLocation(0f, -0.5f, rect)); // sets location for hair
        hair.draw(c); //draws hair
        eyes.draw(c); // draws eyes NOTE: the location of eyes is set in Eyes class;

        nose.setLocation(new RatioLocation(0f, 0f, rect)); //sets location of nose
        nose.draw(c); //draw nose

        mouth.setLocation(new RatioLocation(0f, 0.35f, rect));
        mouth.draw(c);


    }

    /*
    All the following are the getters are setters of each function
    */

    public Nose getNose() {
        return nose;
    }

    public void setNose(Nose nose) {
        this.nose = nose;
    }

    public Hair getHair() {
        return hair;
    }

    public void setHair(Hair hair) {
        this.hair = hair;
    }



    public Head getHead() {
        return head;
    }



    public Eyes getEyes() {
        return eyes;
    }

    public void setEyes(Eyes eyes) {
        this.eyes = eyes;
    }
}
