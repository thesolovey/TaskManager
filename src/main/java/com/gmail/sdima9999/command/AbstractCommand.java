package com.gmail.sdima9999.command;
import com.gmail.sdima9999.bootstrap.Bootstrap;

public abstract class AbstractCommand {
    protected Bootstrap bootstrap;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute();

    public abstract void secure();

}
