package com.gmail.sdima;

import com.gmail.sdima.bootstrap.Bootstrap;

import javax.enterprise.inject.se.SeContainerInitializer;
import javax.enterprise.inject.spi.CDI;

public class App {
    public static void main(String[] args) {

//        final SeContainerInitializer initializer = SeContainerInitializer.newInstance();
//        final SeContainer container = initializer.addPackages(App.class).initialize();
//        final Bootstrap bootstrap = container.select(Bootstrap.class).get();
        SeContainerInitializer.newInstance().addPackages(App.class).initialize();
        final Bootstrap bootstrap = CDI.current().select(Bootstrap.class).get();
        bootstrap.start();
    }
}

