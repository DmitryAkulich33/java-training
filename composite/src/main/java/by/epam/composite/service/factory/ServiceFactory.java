package by.epam.composite.service.factory;

import by.epam.composite.service.LexemeService;
import by.epam.composite.service.ParagraphService;
import by.epam.composite.service.SentenceService;
import by.epam.composite.service.TextService;
import by.epam.composite.service.impl.LexemeServiceImpl;
import by.epam.composite.service.impl.ParagraphServiceImpl;
import by.epam.composite.service.impl.SentenceServiceImpl;
import by.epam.composite.service.impl.TextServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final LexemeService lexemeService = new LexemeServiceImpl();
    private final ParagraphService paragraphService = new ParagraphServiceImpl();
    private final SentenceService sentenceService = new SentenceServiceImpl();
    private final TextService textService = new TextServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public LexemeService getLexemeService() {
        return lexemeService;
    }

    public ParagraphService getParagraphService() {
        return paragraphService;
    }

    public SentenceService getSentenceService() {
        return sentenceService;
    }

    public TextService getTextService() {
        return textService;
    }
}
