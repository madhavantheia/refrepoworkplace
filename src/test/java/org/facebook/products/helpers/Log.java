package org.facebook.products.helpers;

// Java program to demonstrate
// Logger.log(Level level, String msg)  method

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    public static void main(String[] args) {

        // Create a Logger
        Logger logger
                = Logger.getLogger(
                Log.class.getName());

        // log messages using log(Level level, String msg)
        logger.log(Level.INFO, "This is message 1");
        logger.log(Level.WARNING, "This is message 2");
    }
}