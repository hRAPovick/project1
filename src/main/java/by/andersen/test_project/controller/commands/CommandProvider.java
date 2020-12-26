package by.andersen.test_project.controller.commands;

import by.andersen.test_project.controller.commands.impl.CreateUserCommand;
import by.andersen.test_project.controller.commands.impl.DeleteUserCommand;
import by.andersen.test_project.controller.commands.impl.ErrorCommand;
import by.andersen.test_project.controller.commands.impl.GoToMainCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private final Map<CommandName, Command> commandMap = new HashMap<>();

    public CommandProvider() {
        commandMap.put(CommandName.CREATE, new CreateUserCommand());
        commandMap.put(CommandName.DELETE, new DeleteUserCommand());
        commandMap.put(CommandName.ERROR, new ErrorCommand());
        commandMap.put(CommandName.GO_TO_MAIN, new GoToMainCommand());
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commandMap.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            command = commandMap.get(CommandName.ERROR);
        }
        return command;
    }
}
