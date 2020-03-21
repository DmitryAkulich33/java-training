package by.epam.bakery.controller;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandName;
import by.epam.bakery.controller.command.impl.common.*;
import by.epam.bakery.controller.command.impl.feedback.CreatorFeedbackCommand;
import by.epam.bakery.controller.command.impl.feedback.ShowFeedBackCommand;
import by.epam.bakery.controller.command.impl.user.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SHOW_MAIN_PAGE, new ShowMainPageCommand());
        repository.put(CommandName.LOGIN, new LoginCommand());
        repository.put(CommandName.LOG_OUT, new LogoutCommand());
        repository.put(CommandName.SORT_BY_INCREASE_PRICE, new SorterByPriceIncreaseCommand());
        repository.put(CommandName.SORT_BY_REDUCTION_PRICE, new SorterByPriceReductionCommand());
        repository.put(CommandName.PERSONAL_ACCOUNT, new PersonalAccountCommand());
        repository.put(CommandName.CHANGE_NAME, new ChangeNameCommand());
        repository.put(CommandName.CHANGE_SURNAME, new ChangeSurnameCommand());
        repository.put(CommandName.CHANGE_PATRONYMIC, new ChangePatronymicCommand());
        repository.put(CommandName.CHANGE_ADDRESS, new ChangeAddressCommand());
        repository.put(CommandName.CHANGE_PHONE, new ChangePhoneCommand());
        repository.put(CommandName.SHOW_FEEDBACK, new ShowFeedBackCommand());
        repository.put(CommandName.ADD_FEEDBACK, new CreatorFeedbackCommand());
        repository.put(CommandName.SHOW_ABOUT_US, new ShowAboutUsCommand());
        repository.put(CommandName.SHOW_CONTACTS, new ShowContactsCommand());
        repository.put(CommandName.SHOW_DELIVERY, new ShowDeliveryCommand());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
