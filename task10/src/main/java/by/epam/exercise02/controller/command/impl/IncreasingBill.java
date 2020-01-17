package by.epam.exercise02.controller.command.impl;

import by.epam.exercise02.controller.command.Command;
import by.epam.exercise02.domain.Constants;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.PaymentService;
import by.epam.exercise02.service.exception.NoProductsToBuyException;
import by.epam.exercise02.service.exception.ServiceException;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

public class IncreasingBill implements Command {
    @Override
    public String execute(String productNames, String request, Shop shop) {
        String response = null;
        PaymentService paymentService = new PaymentService();
        try {
            paymentService.createBillIncreaseByCost(Constants.BILL_INCREASE_BY_COST_PATH, productNames, shop,
                    Constants.CUSTOMER_NAME, Constants.BILL_INCREASE_BY_COST_NAME);
            response = "Increasing by cost bill was created successfully in the file";
        } catch (NoProductsToBuyException | ServiceException | WrongProductsToBuyException ex){
            response = ex.getMessage();
        }
        return response;
    }
}

