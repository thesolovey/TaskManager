package com.gmail.sdima9999.command.servises;

import com.gmail.sdima9999.bootstrap.Bootstrap;
import com.gmail.sdima9999.command.AbstractCommand;

public class ExitCommand extends AbstractCommand {
    public ExitCommand(Bootstrap bootstrap) { super(bootstrap); }

    @Override
    public void execute() {
        System.out.println("Good bye!");
    }

    @Override
    public void secure() {

    }
}
