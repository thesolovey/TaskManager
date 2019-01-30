package command.service;

import bootstrap.BootstrapClient;
import command.AbstractCommand;

public class ExitCommand extends AbstractCommand {
    public ExitCommand(BootstrapClient bootstrap) { super(bootstrap); }

    public static final String COMMAND = "exit";

    @Override
    public void execute() {
        System.out.println("Good bye!");
    }

    @Override
    public boolean secure() { return false; }

    @Override
    public String getKeyWord() { return "exit"; }

    @Override
    public String description() { return "Exit from TaskManager"; }
}
