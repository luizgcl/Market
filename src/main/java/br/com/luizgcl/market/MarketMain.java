package br.com.luizgcl.market;

import br.com.luizgcl.market.command.register.CommandRegister;
import br.com.luizgcl.market.thread.MarketThread;

public class MarketMain {

    public static void main(String[] args) {

        CommandRegister.registerCommands();

        Thread thread = new MarketThread();
        thread.start();

        System.gc();
    }

}
