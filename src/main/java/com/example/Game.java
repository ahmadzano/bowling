package com.example;

import sun.plugin.javascript.navig.FrameArray;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList<Frame> frames = new ArrayList<Frame>();

    private static final int PIN_NUMBERS  = 10 ;

    public void Game() {

    }

    public void start() {
        for (int i = 0; i < 10; i++) {
            Frame frame = new Frame();
            frame.roll(false);

            if (this.getFrames().size() == 10 ) {
                //int lastIndex = this.getFrames().lastIndexOf(Frame.class);
                if (this.getFrames().get(9).isSpare() || this.getFrames().get(9).isStrike()) {
                    frame.roll(true);
                }
            }

            this.frames.add(frame);
        }
    }

    public  boolean over() {
        return true;
    }

    public int totalScore()
    {
        return 0;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<Frame> frames) {
        this.frames = frames;
    }

}
