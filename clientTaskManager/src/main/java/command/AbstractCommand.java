package command;

import api.ICommand;
import bootstrap.BootstrapClient;

import java.io.Serializable;

public abstract class AbstractCommand implements ICommand, Serializable {

    protected BootstrapClient bootstrap;

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
