package by.epam.xml.service.builder;

import by.epam.xml.domain.Order;
import by.epam.xml.domain.OrderEnum;
import by.epam.xml.domain.StatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.*;

public class OrderSAXHandler extends DefaultHandler {
    private static Logger log = LogManager.getLogger(OrderSAXBuilder.class.getName());

    private Set<Order> orders;
    private Order current = null;
    private OrderEnum currentEnum = null;
    private EnumSet<OrderEnum> withText;

    public OrderSAXHandler() {
        orders = new HashSet<>();
        withText = EnumSet.range(OrderEnum.CLIENT, OrderEnum.DELIVERYDATE);
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if ("order".equals(localName)) {
            log.info("Creating order.");
            current = new Order();
            log.info("Get order's attribute values");
            current.setId(Integer.parseInt(attrs.getValue(0)));
            if (attrs.getLength() == 2) {
                current.setStatusEnum(StatusEnum.valueOf(attrs.getValue(1).toUpperCase()));
            }
        } else if ("client".equals(localName)) {
            log.info("Get client's attribute values");
            current.getClient().setId(Integer.parseInt(attrs.getValue(0)));
        } else if ("pie".equals(localName)) {
            log.info("Get pie's attribute values");
            current.getPie().setId(Integer.parseInt(attrs.getValue(0)));
        } else {
            log.info("Creating elements.");
            OrderEnum temp = OrderEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if ("order".equals(localName)) {
            orders.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case SURNAME:
                    current.getClient().setSurname(s);
                    break;
                case NAME:
                    current.getClient().setName(s);
                    break;
                case PATRONYMIC:
                    current.getClient().setPatronymic(s);
                    break;
                case ADDRESS:
                    current.getClient().setAddress(s);
                    break;
                case PHONE:
                    current.getClient().setPhone(s);
                    break;
                case NOTE:
                    current.getClient().setNote(s);
                    break;
                case TITLE:
                    current.getPie().setTitle(s);
                    break;
                case WEIGHT:
                    current.getPie().setWeight(Integer.parseInt(s));
                    break;
                case PRICE:
                    current.getPie().setPrice(Double.parseDouble(s));
                    break;
                case DESCRIPTION:
                    current.getPie().setDescription(s);
                    break;
                case PRODUCTIONDATE:
                    current.setProductionDate(LocalDateTime.parse(s));
                    break;
                case DELIVERYDATE:
                    current.setDeliveryDate(LocalDateTime.parse(s));
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
