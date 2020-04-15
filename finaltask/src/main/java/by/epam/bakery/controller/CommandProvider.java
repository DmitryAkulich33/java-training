package by.epam.bakery.controller;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandName;
import by.epam.bakery.controller.command.impl.admin.*;
import by.epam.bakery.controller.command.impl.common.*;
import by.epam.bakery.controller.command.impl.courier.*;
import by.epam.bakery.controller.command.impl.user.CreatorFeedbackCommand;
import by.epam.bakery.controller.command.impl.common.ShowFeedbackCommand;
import by.epam.bakery.controller.command.impl.user.AddOrderCommand;
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
        repository.put(CommandName.SHOW_FEEDBACK, new ShowFeedbackCommand());
        repository.put(CommandName.ADD_FEEDBACK, new CreatorFeedbackCommand());
        repository.put(CommandName.SHOW_ABOUT_US, new ShowAboutUsCommand());
        repository.put(CommandName.SHOW_CONTACTS, new ShowContactsCommand());
        repository.put(CommandName.SHOW_DELIVERY, new ShowDeliveryCommand());
        repository.put(CommandName.ADD_PIE, new AddPieCommand());
        repository.put(CommandName.CLEAR_BASKET, new ClearBasketCommand());
        repository.put(CommandName.ADD_ORDER, new AddOrderCommand());
        repository.put(CommandName.ADMIN_ACCOUNT, new AdminAccountCommand());
        repository.put(CommandName.ADMIN_PIES, new AdminPiesCommand());
        repository.put(CommandName.ADMIN_FEEDBACK, new AdminFeedbackCommand());
        repository.put(CommandName.FIND_PIE_BY_ID, new FindPieByIdCommand());
        repository.put(CommandName.FIND_PIE_BY_NAME, new FindPieByNameCommand());
        repository.put(CommandName.DELETE_PIE, new DeletePieCommand());
        repository.put(CommandName.SAVE_PIE, new SavePieCommand());
        repository.put(CommandName.CHANGE_PIE, new ChangePieCommand());
//        repository.put(CommandName.FIND_FEEDBACK_BY_USER, new FindFeedbackByUserCommand());
        repository.put(CommandName.DELETE_FEEDBACK, new DeleteFeedbackCommand());
//        repository.put(CommandName.SHOW_LAST_FEEDBACK, new ShowLastFeedbackCommand());
        repository.put(CommandName.ADMIN_USERS, new AdminUsersCommand());
        repository.put(CommandName.DELETE_USER, new DeleteUserCommand());
        repository.put(CommandName.SAVE_USER, new SaveUserCommand());
//        repository.put(CommandName.FIND_USER_BY_ID, new FindUserByIdCommand());
//        repository.put(CommandName.FIND_USER_BY_SURNAME, new FindUserBySurnameCommand());
        repository.put(CommandName.CHANGE_USER, new ChangeUserCommand());
//        repository.put(CommandName.ADMIN_ORDER, new AdminOrderCommand());
        repository.put(CommandName.ADMIN_ORDER_PRODUCT, new AdminOrderProductCommand());
        repository.put(CommandName.SHOW_BASKET, new ShowBasketCommand());
        repository.put(CommandName.DELETE_PIE_FROM_BASKET, new DeletePieFromBasketCommand());
//        repository.put(CommandName.FIND_ORDER_BY_USER_ID, new FindOrderByUserId());
        repository.put(CommandName.DELETE_ORDER, new DeleteOrderCommand());
//        repository.put(CommandName.SHOW_LAST_ORDER, new ShowLastOrderCommand());
        repository.put(CommandName.CHANGE_ORDER, new ChangeOrderCommand());
//        repository.put(CommandName.FIND_ORDER_PRODUCT_BY_USER_ID, new FindOrderProductByUserIdCommand());
//        repository.put(CommandName.FIND_ORDER_PRODUCT_BY_ORDER_ID, new FindOrderProductByOrderIdCommand());
        repository.put(CommandName.DELETE_ORDER_PRODUCT, new DeleteOrderProductCommand());
//        repository.put(CommandName.CHOOSE_ORDER_STATUS, new ChooseOrderStatusCommand());
        repository.put(CommandName.COURIER_ACCOUNT, new CourierAccountCommand());
        repository.put(CommandName.COURIER_CLIENTS, new CourierClientsCommand());
//        repository.put(CommandName.COURIER_FIND_CLIENT_BY_ID, new CourierFindClientByIdCommand());
//        repository.put(CommandName.COURIER_FIND_CLIENT_BY_SURNAME, new CourierFindClientBySurnameCommand());
        repository.put(CommandName.CHANGE_NOTE, new ChangeNoteCommand());
//        repository.put(CommandName.FIND_USER_BY_ROLE, new FindUserByRoleCommand());
        repository.put(CommandName.COURIER_ORDER, new CourierOrderCommand());
//        repository.put(CommandName.COURIER_CHOOSE_ORDER_STATUS, new CourierChooseOrderStatusCommand());
        repository.put(CommandName.CHANGE_ORDER_STATUS, new ChangeOrderStatusCommand());
        repository.put(CommandName.REGISTRATION, new RegistrationCommand());
        repository.put(CommandName.REGISTRATION_USER, new RegistrationUserCommand());
        repository.put(CommandName.ADMIN_ADD_NEW_ORDER, new AdminAddNewOrderCommand());
        repository.put(CommandName.ADMIN_ADD_PIE_TO_ORDER, new AdminAddPieToOrderCommand());
        repository.put(CommandName.ADMIN_ADD_NEW_USER_FOR_ORDER, new AdminAddNewUserForOrder());
        repository.put(CommandName.ADMIN_DELETE_PIE_FROM_ORDER, new AdminDeletePieFromOrderCommand());
        repository.put(CommandName.ADMIN_PRODUCT_TO_ORDER, new AdminProductToOrder());
        repository.put(CommandName.ADMIN_USERS_INCREASE_PAGE, new AdminUsersIncreasePageCommand());
        repository.put(CommandName.ADMIN_USERS_DECREASE_PAGE, new AdminUsersDecreasePageCommand());
        repository.put(CommandName.ADMIN_FEEDBACK_INCREASE_PAGE, new AdminFeedbackIncreasePageCommand());
        repository.put(CommandName.ADMIN_FEEDBACK_DECREASE_PAGE, new AdminFeedbackDecreasePageCommand());
        repository.put(CommandName.SHOW_FEEDBACK_DECREASE_PAGE, new ShowFeedbackDecreasePageCommand());
        repository.put(CommandName.SHOW_FEEDBACK_INCREASE_PAGE, new ShowFeedbackIncreasePageCommand());
        repository.put(CommandName.COURIER_CLIENTS_INCREASE_PAGE, new CourierClientsIncreasePageCommand());
        repository.put(CommandName.COURIER_CLIENTS_DECREASE_PAGE, new CourierClientsDecreasePageCommand());
        repository.put(CommandName.ADMIN_ORDER_PRODUCT_INCREASE_PAGE, new AdminOrderProductIncreasePageCommand());
        repository.put(CommandName.ADMIN_ORDER_PRODUCT_DECREASE_PAGE, new AdminOrderProductDecreasePageCommand());
        repository.put(CommandName.COURIER_ORDER_INCREASE_PAGE, new CourierOrderIncreasePageCommand());
        repository.put(CommandName.COURIER_ORDER_DECREASE_PAGE, new CourierOrderDecreaseCommand());
        repository.put(CommandName.PERSONAL_ACCOUNT_INCREASE_PAGE, new PersonalAccountIncreasePageCommand());
        repository.put(CommandName.PERSONAL_ACCOUNT_DECREASE_PAGE, new PersonalAccountDecreasePageCommand());
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
