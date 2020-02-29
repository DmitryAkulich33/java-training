package by.epam.xml.parser;

import by.epam.xml.xmlorders.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class OrderStAXBuilder {
    private HashSet<Order> orders = new HashSet<>();
    private XMLInputFactory inputFactory;

    public OrderStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public HashSet<Order> getOrders() {
        return orders;
    }

    public void buildSetOrders(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.ORDER) {
                        Order order = buildOrder(reader);
                        orders.add(order);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Order buildOrder(XMLStreamReader reader) throws XMLStreamException {
        Order order = new Order();
        order.setId(Integer.parseInt(reader.getAttributeValue(null, OrderEnum.ID.getValue())));
        order.setStatusEnum(StatusEnum.valueOf(reader.getAttributeValue(null, OrderEnum.STATUS.getValue()).toUpperCase()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case CLIENT:
                            order.setClient(getXMLClient(reader));
                            break;
                        case PIE:
                            order.setPie(getXMLPie(reader));
                            break;
                        case PRODUCTIONDATE:
                            order.setProductionDate(LocalDateTime.parse(getXMLText(reader)));
                            break;
                        case DELIVERYDATE:
                            order.setDeliveryDate(LocalDateTime.parse(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                name = reader.getLocalName();
                if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.ORDER) {
                    return order;
                }
                break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }

    private Client getXMLClient(XMLStreamReader reader) throws XMLStreamException {
        Client client = new Client();
        client.setId(Integer.parseInt(reader.getAttributeValue(null, OrderEnum.ID.getValue())));
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case SURNAME:
                            client.setSurname(getXMLText(reader));
                            break;
                        case NAME:
                            client.setName(getXMLText(reader));
                            break;
                        case PATRONYMIC:
                            client.setPatronymic(getXMLText(reader));
                            break;
                        case ADDRESS:
                            client.setAddress(getXMLText(reader));
                            break;
                        case PHONE:
                            client.setPhone(getXMLText(reader));
                            break;
                        case NOTE:
                            client.setNote(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.CLIENT) {
                        return client;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private Pie getXMLPie(XMLStreamReader reader) throws XMLStreamException {
        Pie pie = new Pie();
        pie.setId(Integer.parseInt(reader.getAttributeValue(null, OrderEnum.ID.getValue())));
        //atribut
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (OrderEnum.valueOf(name.toUpperCase())) {
                        case TITLE:
                            pie.setTitle(getXMLText(reader));
                            break;
                        case WEIGHT:
                            pie.setWeight(Integer.parseInt(getXMLText(reader)));
                            break;
                        case PRICE:
                            pie.setPrice(Double.parseDouble(getXMLText(reader)));
                            break;
                        case DESCRIPTION:
                            pie.setDescription(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (OrderEnum.valueOf(name.toUpperCase()) == OrderEnum.PIE) {
                        return pie;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Address");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}

