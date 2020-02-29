package by.epam.xml.parser;

import by.epam.xml.xmlorders.Order;
import by.epam.xml.xmlorders.OrderEnum;
import by.epam.xml.xmlorders.StatusEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class OrderStAXBuilder {
    private HashSet<Order> students = new HashSet<>();
    private XMLInputFactory inputFactory;

    public OrderStAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public HashSet<Order> getStudents() {
        return students;
    }
    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name ;
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
                        students.add(order);
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
                System.err.println("Impossible close file "+fileName+" : "+e);
            }
        }
    }
    private Order buildOrder(XMLStreamReader reader) throws XMLStreamException {
        Order order = new Order();
        order.setId(Integer.parseInt(reader.getAttributeValue(null, OrderEnum.ID.getValue())));
        order.setStatusEnum(StatusEnum.valueOf(reader.getAttributeValue(null, OrderEnum.STATUS.getValue()).toUpperCase()));

        String name ;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                name = reader.getLocalName();
                switch (StudentEnum.valueOf(name.toUpperCase())) {
                    sac  e NAME:
                    st.setName(getXMLText(reader));
                    break;
                    sac  e TELEPHONE:
                    name = getXMLText(reader);
                    st.setTelephone(Integer.parseInt(name));
                    break;
                    sac  e ADDRESS:
                    st.setAddress(getXMLAddress(reader));
                    break;
                }
                break;
                ac   se XMLStreamConstants.END_ELEMENT:
                name = reader.getLocalName();
                if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.STUDENT) {
                    return st;
                }
                break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Student");
    }
    private Student.Address getXMLAddress(XMLStreamReader reader) throws XMLStreamException {
        Student.Address address = new Student.Address();
        int type;
        String name ;
        while (reader.hasNext()) {
            type = re ad er.next();
            switch (type) {
                ac   se XMLStreamConstants.START_ELEMENT:
                name = re ad er.getLocalName();
                switch (StudentEnum.valueOf(name.toUpperCase())) {
                    ac   se COUNTRY:
                    address.setCountry(getXMLText(reader));
                    break;
                    ac   se CITY:
                    address.setCity(getXMLText(reader));
                    break;
                    ac   se STREET:
                    address.setStreet(getXMLText(reader));
                    break;
                }
                break;
                ac   se XMLStreamConstants.END_ELEMENT:
                name = reader.getLocalName();
                if (StudentEnum.valueOf(name.toUpperCase()) == StudentEnum.ADDRESS){
                    return address;
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
            text = re ad er.getText();
        }
        return text;
    }
}

