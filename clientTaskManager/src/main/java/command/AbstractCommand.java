package command;
import bootstrap.Bootstrap;

public abstract class AbstractCommand {

    protected Bootstrap bootstrap;

    public Bootstrap getBootstrap() { return bootstrap; }

    public void setBootstrap(Bootstrap bootstrap) { this.bootstrap = bootstrap; }

    public static String COMMAND;

    public AbstractCommand(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract void execute();

    public abstract boolean secure();

    public abstract String getKeyWord();

    public abstract String description();

}
