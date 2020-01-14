package by.epam.exercise04.service.factory;

import by.epam.exercise04.service.DragonCaveService;
import by.epam.exercise04.service.TreasureService;
import by.epam.exercise04.service.impl.DragonCaveServiceImpl;
import by.epam.exercise04.service.impl.TreasureServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final TreasureService treasureService = new TreasureServiceImpl();
    private final DragonCaveService dragonCaveService = new DragonCaveServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TreasureService getTreasureService() {
        return treasureService;
    }

    public DragonCaveService getDragonCaveService() {
        return dragonCaveService;
    }
}

