package by.epam.xml.service.builder;

import by.epam.xml.domain.Client;
import by.epam.xml.domain.Order;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import by.epam.xml.domain.Pie;
import by.epam.xml.domain.StatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class OrderDOMBuilder extends BaseBuilder {
    private static Logger log = LogManager.getLogger(OrderDOMBuilder.class.getName());

    private Set<Order> orders;
    private DocumentBuilder docBuilder;

    public OrderDOMBuilder() {
        this.orders = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error("Parser configuration error.");
            System.err.println("Parser configuration error: " + e);
        }
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void buildSetOrders(String fileName) {
        Document doc = null;
        try {
            log.info("Parsing an XML document and creating a tree structure.");
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            log.info("Getting a list of children.");
            NodeList ordersList = root.getElementsByTagName("order");
            for (int i = 0; i < ordersList.getLength(); i++) {
                Element orderElement = (Element) ordersList.item(i);
                Order order = buildOrder(orderElement);
                orders.add(order);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private Order buildOrder(Element orderElement) {
        Order order = new Order();
        log.info("Filling the object <order>");
        order.setId(Integer.parseInt(orderElement.getAttribute("id")));
        order.setStatusEnum(StatusEnum.valueOf(orderElement.getAttribute("status").toUpperCase()));
        log.info("Filling the object <client>");
        Client client = order.getClient();
        Element clientElement = (Element) orderElement.getElementsByTagName("client").item(0);
        client.setId(Integer.parseInt(clientElement.getAttribute("id")));
        client.setSurname(getElementTextContent(clientElement, "surname"));
        client.setName(getElementTextContent(clientElement, "name"));
        client.setPatronymic(getElementTextContent(clientElement, "patronymic"));
        client.setAddress(getElementTextContent(clientElement, "address"));
        client.setPhone(getElementTextContent(clientElement, "phone"));
        client.setNote(getElementTextContent(clientElement, "note"));
        log.info("Filling the object <pie>");
        Pie pie = order.getPie();
        Element pieElement = (Element) orderElement.getElementsByTagName("pie").item(0);
        pie.setId(Integer.parseInt(pieElement.getAttribute("id")));
        pie.setTitle(getElementTextContent(pieElement, "title"));
        pie.setWeight(Integer.parseInt(getElementTextContent(pieElement, "weight")));
        pie.setPrice(Double.parseDouble(getElementTextContent(pieElement, "price")));
        pie.setDescription(getElementTextContent(pieElement, "description"));
        log.info("Attribute filling order");
        order.setProductionDate(LocalDateTime.parse(getElementTextContent(orderElement, "productionDate")));
        order.setDeliveryDate(LocalDateTime.parse(getElementTextContent(orderElement, "deliveryDate")));
        return order;
    }

    private static String getElementTextContent(Element element, String elementName) {
        log.info("Getting the text content of a tag");
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

