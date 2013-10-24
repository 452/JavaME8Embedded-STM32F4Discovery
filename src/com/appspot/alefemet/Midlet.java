package com.appspot.alefemet;

import com.oracle.deviceaccess.PeripheralManager;
import com.oracle.deviceaccess.gpio.GPIOPin;
import java.io.IOException;
import javax.microedition.midlet.MIDlet;

/**
 * This is simplest demo project Java ME Embedded 8 on STM32F4Discovery board - STM32F407VGT6
 * @author 452
 */
public class Midlet extends MIDlet {

    private static final int DELAY_MS = 10; // 1000 ms = 1 s

    @Override
    public void startApp() {
        try {
            try (GPIOPin ledOrange = (GPIOPin) PeripheralManager.open(1); GPIOPin ledGreen = (GPIOPin) PeripheralManager.open(2)) {
                while(true) {
                    ledOrange.setValue(true);
                    ledGreen.setValue(false);
                    Thread.sleep(DELAY_MS);
                    ledOrange.setValue(false);
                    ledGreen.setValue(true);
                    Thread.sleep(DELAY_MS);
                    //System.out.println("Test ");
                }
            }
        } catch (IOException | InterruptedException ex) {
           //log.log(Level.ALL, "ooops Error : ", ex); // logs not work on this time
        }
    }

    @Override
    public void pauseApp() {
    }

    @Override
    public void destroyApp(boolean unconditional) {
    }
}