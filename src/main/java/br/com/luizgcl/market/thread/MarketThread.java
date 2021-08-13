package br.com.luizgcl.market.thread;

import br.com.luizgcl.market.command.register.CommandRegister;

import java.util.Scanner;

public class MarketThread extends Thread {

    public MarketThread() {
        super("Super-Mercado");
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("> Interface do mercado iniciada!");
        while (!isInterrupted()) {
            System.out.println("> Digite algum comando: ");
            new CommandRegister().execute(scanner.nextLine().split(" "));
        }
    }

}
