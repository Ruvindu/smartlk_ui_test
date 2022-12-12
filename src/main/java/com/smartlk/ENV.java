package com.smartlk;

public class ENV {

    public static void manualwait(int time){
        try {
            Thread.sleep(1000*time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
