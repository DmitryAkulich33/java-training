package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;
import by.epam.composite.service.ParagraphService;
import by.epam.composite.service.comparator.SizeComparator;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphServiceImpl implements ParagraphService {
    private static Logger log = LogManager.getLogger(ParagraphServiceImpl.class.getName());

    public Component sort(Component component) {
        SizeComparator sizeComparator = new SizeComparator();
        List<Component> newListParagraphs = new ArrayList<>();
        for(int i = 0; i < component.calcSize(); i++){
            newListParagraphs.add(component.getChild(i));
        }
        newListParagraphs.sort(sizeComparator);
        log.info("Paragraphs are sorted.");
        return new Text(newListParagraphs);
    }
}
