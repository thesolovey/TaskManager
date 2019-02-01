package command;

import bootstrap.Bootstrap;

import java.io.Serializable;

public abstract class AbstractCommand implements Serializable {
    protected Bootstrap bootstrap;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) { this.bootstrap = bootstrap; }

    public abstract void execute();

    public abstract boolean secure();

    public abstract String getKeyWord();

    public abstract String description();

}
