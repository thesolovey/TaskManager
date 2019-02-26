package com.gmail.sdima.command;

import com.gmail.sdima.api.ICommand;
import com.gmail.sdima.bootstrap.BootstrapClient;

import java.io.Serializable;

public abstract class AbstractCommand implements ICommand, Serializable {

    protected BootstrapClient bootstrap;

    public AbstractCommand() { }

    public BootstrapClient getBootstrap() { return bootstrap; }

    public void setBootstrap(BootstrapClient bootstrap) { this.bootstrap = bootstrap; }

    public static String COMMAND;

    public AbstractCommand(BootstrapClient bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute();

    public abstract boolean secure();

    public abstract String getKeyWord();

    public abstract String description();

}
