package by.epam.exercise04.controller;

import by.epam.exercise04.domain.Constants;
import by.epam.exercise04.service.impl.DragonCaveServiceImpl;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DragonCaveServiceImpl service = new DragonCaveServiceImpl();
        List<String> list = service.findValidLines(Constants.TREASURE_LIST_PATH);
        int i = 1;
        for (String line: list) {
            System.out.println(i + " " + line);
            i++;
        }
    }
}
