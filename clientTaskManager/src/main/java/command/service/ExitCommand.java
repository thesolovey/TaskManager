package command.service;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class ExitCommand extends AbstractCommand {
    public ExitCommand(Bootstrap bootstrap) { super(bootstrap); }

    public static final String COMMAND = "exit";

    @Override
    public void execute() {
        System.out.println("Good bye!");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return null; }

    @Override
    public String description() { return null; }
}
