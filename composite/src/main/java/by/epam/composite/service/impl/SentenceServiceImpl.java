package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.domain.Paragraph;
import by.epam.composite.domain.Sentence;
import by.epam.composite.domain.Text;
import by.epam.composite.service.SentenceService;
import by.epam.composite.service.comparator.SizeComparator;
import by.epam.composite.service.copier.ComponentCopy;

import java.util.ArrayList;
import java.util.List;

public class SentenceServiceImpl implements SentenceService {
//    public Component sort(Component original) {
//        ComponentCopy componentCopy = new ComponentCopy();
//        Component copy = componentCopy.copyComponent(original);
//        SizeComparator sizeComparator = new SizeComparator();
//        for (int i = 0; i < copy.calcSize(); i++) {
//            for (int j = 0; j < copy.getChild(i).calcSize(); j++) {
//                copy.getChild(i).getChild(j).getComponents().sort(sizeComparator);
//            }
//        }
//        return copy;
//    }

    public Component sort(Component original) {
        SizeComparator sizeComparator = new SizeComparator();
        ComponentCopy componentCopy = new ComponentCopy();
        Component copy = componentCopy.copyComponent(original);
        List<Component> newListParagraphs = new ArrayList<>();

        for (int i = 0; i < copy.calcSize(); i++) {
            List<Component> newListSentences = new ArrayList<>();
            Paragraph paragraph;
            for (int j = 0; j < copy.getChild(i).calcSize(); j++) {
                List<Component> newListLexemes = new ArrayList<>();
                Sentence sentence;
                for (int z = 0; z < copy.getChild(i).getChild(j).calcSize(); z++) {
                    newListLexemes.add(copy.getChild(i).getChild(j).getChild(z));
                }
                newListLexemes.sort(sizeComparator);
                sentence = new Sentence(newListLexemes);
                newListSentences.add(sentence);
            }
            paragraph = new Paragraph(newListSentences);
            newListParagraphs.add(paragraph);
        }
        return new Text(newListParagraphs);
    }
}
