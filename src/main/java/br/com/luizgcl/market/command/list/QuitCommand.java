package br.com.luizgcl.market.command.list;

import br.com.luizgcl.market.command.type.Command;

public class QuitCommand extends Command {

    public QuitCommand() {
        super("quit", "Saia da interface de comando.", "quit");
    }

    @Override
    public void handle(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("> Interface do mercado encerrada!");
    }

}
