package by.epam.xml.parser;

import by.epam.xml.xmlorders.Client;
import by.epam.xml.xmlorders.Order;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import by.epam.xml.xmlorders.Pie;
import by.epam.xml.xmlorders.StatusEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class OrderDOMBuilder {
    private Set<Order> orders;
    private DocumentBuilder docBuilder;

    public OrderDOMBuilder() {
        this.orders = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void buildSetOrders(String fileName) {
        Document doc = null;
        try {
        // parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // получение списка дочерних элементов <order>
            NodeList ordersList = root.getElementsByTagName("order");
            for (int i = 0; i < ordersList.getLength(); i++) {
                Element orderElement = (Element) ordersList.item(i);
                Order order = buildOrder (orderElement);
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
        // заполнение объекта order
        order.setId(Integer.parseInt(orderElement.getAttribute("id")));
        order.setStatusEnum(StatusEnum.valueOf(orderElement.getAttribute("status").toUpperCase()));
        order.setDeliveryDate(LocalDateTime.parse(getElementTextContent(orderElement, "deliveryDate")));
        order.setProductionDate(LocalDateTime.parse(getElementTextContent(orderElement, "productionDate")));
        // заполнение объекта client
        Client client = order.getClient();
        Element clientElement = (Element) orderElement.getElementsByTagName("client").item(0);
        client.setName(getElementTextContent(clientElement, "name"));
        client.setSurname(getElementTextContent(clientElement, "surname"));
        client.setPatronymic(getElementTextContent(clientElement, "patronymic"));
        client.setAddress(getElementTextContent(clientElement, "address"));
        client.setPhone(getElementTextContent(clientElement, "phone"));
        client.setNote(getElementTextContent(clientElement, "note"));
        client.setId(Integer.parseInt(clientElement.getAttribute("id")));
        // заполнение объекта pie
        Pie pie = order.getPie();
        Element pieElement = (Element) orderElement.getElementsByTagName("pie").item(0);
        pie.setTitle(getElementTextContent(pieElement, "title"));
        pie.setWeight(Integer.parseInt(getElementTextContent(pieElement, "weight")));
        pie.setPrice(Double.parseDouble(getElementTextContent(pieElement, "price")));
        pie.setDescription(getElementTextContent(pieElement, "description"));
        pie.setId(Integer.parseInt(pieElement.getAttribute("id")));
        return order;
    }

    // получение текстового содержимого тега
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

