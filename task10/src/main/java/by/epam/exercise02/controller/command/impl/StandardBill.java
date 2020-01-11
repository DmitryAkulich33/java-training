package by.epam.exercise02.controller.command.impl;

import by.epam.exercise02.controller.command.Command;
import by.epam.exercise02.dao.exception.StreamNotReadingException;
import by.epam.exercise02.dao.exception.StreamNotWritingException;
import by.epam.exercise02.domain.Constants;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.PaymentService;
import by.epam.exercise02.service.exception.NoProductsForSaleException;
import by.epam.exercise02.service.exception.NoProductsToBuyException;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

public class StandardBill implements Command {

    @Override
    public String execute(String productNames, String request, Shop shop) {
        String response = null;
        PaymentService paymentService = new PaymentService();
        try {
            paymentService.createStandardBill(Constants.STANDARD_BILL_PATH, productNames, shop,
                    Constants.CUSTOMER_NAME, Constants.STANDARD_BILL_NAME);
            response = "Standard bill was created successfully in the file";
        } catch (NoProductsToBuyException | NoProductsForSaleException | WrongProductsToBuyException ex){
            response = ex.getMessage();
        }
        return response;
    }
}
