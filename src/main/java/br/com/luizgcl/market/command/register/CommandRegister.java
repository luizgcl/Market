package br.com.luizgcl.market.command.register;

import br.com.luizgcl.market.command.type.Command;
import br.com.luizgcl.market.command.type.ICommand;
import org.reflections.Reflections;

import java.util.HashSet;
import java.util.Set;

public class CommandRegister implements ICommand {

    protected static Reflections reflections = new Reflections("br.com.luizgcl.market.command.list");

    protected static Set<Command> commands = new HashSet<>();

    public static void registerCommands() {
        for (Class<?> classes : reflections.getSubTypesOf(Command.class)) {
            try {
                Command command = (Command) classes.newInstance();
                commands.add(command);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void execute(String[] args) {
        commands.forEach(command -> {
            if (command.aliases.contains(args[0])) {
                command.handle(args);
            }
        });
    }

    public static Set<Command> getCommands() {
        return commands;
    }

}
