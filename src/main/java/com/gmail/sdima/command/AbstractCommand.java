package com.gmail.sdima.command;
import com.gmail.sdima.bootstrap.Bootstrap;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;

    public static String COMMAND;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute();

    public abstract boolean secure();

    public abstract String getKeyWord();

    public abstract String description();

}
