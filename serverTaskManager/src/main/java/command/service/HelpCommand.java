package command.service;

import bootstrap.Bootstrap;
import command.AbstractCommand;

public class HelpCommand extends AbstractCommand {
    public HelpCommand(Bootstrap bootstrap) { super(bootstrap); }
    public final static String COMMAND = "help";

    @Override
    public void execute() {
        System.out.println("[HELP]");
//        Set<String> commands = bootstrap.getCommands();

//        for (String string : commands)
//        System.out.println(string);
        System.out.println("[OK}");
    }

    @Override
    public boolean secure() {
        return false;
    }

    @Override
    public String getKeyWord() { return "help"; }

    @Override
    public String description() { return "Will show all the commands"; }

}