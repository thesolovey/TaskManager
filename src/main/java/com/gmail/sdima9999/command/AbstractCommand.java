package com.gmail.sdima9999.command;
import com.gmail.sdima9999.bootstrap.Bootstrap;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;

    protected static String COMMAND;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute();

    public abstract boolean secure();

    public abstract String getKeyWord();

    public abstract String description();

}
