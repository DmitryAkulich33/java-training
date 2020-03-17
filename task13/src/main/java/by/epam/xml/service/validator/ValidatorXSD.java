package by.epam.xml.service.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXSD {
    private static Logger log = LogManager.getLogger(ValidatorXSD.class.getName());
    private final String language =  XMLConstants.W3C_XML_SCHEMA_NS_URI;
//    private final String schemaName =  "e:/myjava/task13/src/main/resources/xml/orders.xsd";
    private final String schemaName =  "d:/java-training/task13/src/main/resources/xml/orders.xsd";

    public Boolean isValid (String fileName){
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            // создание схемы
            Schema schema = factory.newSchema(schemaLocation);
            // создание валидатора на основе схемы
            Validator validator = schema.newValidator();
            // проверка документа
            Source source = new StreamSource(fileName);
            validator.validate(source);
            log.info(fileName + " is valid.");
            return true;
        } catch (SAXException e) {
            log.error("validation "+ fileName + " is not valid because " + e.getMessage());
            return false;
        } catch (IOException e) {
            log.error(fileName + " is not valid because " + e.getMessage());
            return false;
        }
    }
}
