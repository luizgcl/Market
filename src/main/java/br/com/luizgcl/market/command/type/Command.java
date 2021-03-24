package br.com.luizgcl.market.command.type;

import java.util.Arrays;
import java.util.List;

public abstract class Command {

    public String name;
    public String description;
    public List<String> aliases;

    public Command(String name, String description, String... aliases) {
        this.name = name;
        this.description = description;
        this.aliases = Arrays.asList(aliases);
    }

    public abstract void handle(String[] args);

}
