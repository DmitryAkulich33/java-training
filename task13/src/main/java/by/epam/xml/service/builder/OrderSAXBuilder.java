package by.epam.xml.service.builder;

import by.epam.xml.domain.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class OrderSAXBuilder extends BaseBuilder {
    private static Logger log = LogManager.getLogger(OrderSAXBuilder.class.getName());

    private Set<Order> orders;
    private OrderSAXHandler sh;
    private XMLReader reader;

    public OrderSAXBuilder() {
        log.info("SAX analyzer creation.");
        sh = new OrderSAXHandler();
        try {
            log.info("Creating a handler object.");
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
            log.info("Parsing an XML document.");
            reader.parse(fileName);
        } catch (SAXException e) {
            log.error("SAX parser error.");
            System.err.print("SAX parser error: " + e);
        } catch (IOException e) {
            log.error("Error I/O flow.");
            System.err.print("Error I/O flow: " + e);
        }
        orders = sh.getOrders();
    }
}
