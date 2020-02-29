package by.epam.xml.parser;

import by.epam.xml.xmlorders.Order;
import by.epam.xml.xmlorders.OrderSAXHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class OrderSAXBuilder {
    private Set<Order> orders;
    private OrderSAXHandler sh;
    private XMLReader reader;

    public OrderSAXBuilder() {
        // создание SAX-анализатора
        sh = new OrderSAXHandler();
        try {
// создание объекта-обработчика
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        }
    }

    public Set<Order> getOrders() {
        return orders;
    }
    public void buildSetOrders(String fileName) {
        try {
// разбор XML-документа
            reader.parse(fileName);
        } catch (SAXException e) {
            System.err.print("ошибка SAX парсера: " + e);
        } catch (IOException e) {
            System.err.print("ошибка I/О потока: " + e);
        }
        orders = sh.getOrders();
    }
}
