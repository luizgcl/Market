package br.com.luizgcl.market.command.list;

import br.com.luizgcl.market.command.type.Command;
import br.com.luizgcl.market.command.register.CommandRegister;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "Veja todos os comandos.", "help");
    }

    @Override
    public void handle(String[] args) {
        System.out.println("* Lista de comandos:");

        for (Command command : CommandRegister.getCommands()) {
            System.out.println(" " + command.name + " - " + command.description);
        }
    }

}
