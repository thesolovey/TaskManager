package com.gmail.sdima.command;

import com.gmail.sdima.bootstrap.Bootstrap;

import java.io.Serializable;

public abstract class AbstractCommand implements Serializable {
    protected Bootstrap bootstrap;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) { this.bootstrap = bootstrap; }

    public abstract void execute();
}
