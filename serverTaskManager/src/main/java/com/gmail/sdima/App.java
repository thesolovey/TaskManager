package com.gmail.sdima;

import com.gmail.sdima.bootstrap.Bootstrap;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.gmail.sdima");
        context.refresh();
        Bootstrap bootstrap = context.getBean(Bootstrap.class);
        bootstrap.start();
    }
}

