package by.epam.exercise01.controller;

import by.epam.exercise01.domain.Constants;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.domain.EpamFile;
import by.epam.exercise01.service.DirectoryService;
import by.epam.exercise01.service.EpamFileService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DirectoryService directoryService = new DirectoryService();
        Directory directory = directoryService.createDirectory(Constants.FILE_DIRECTORY_PATH);
        System.out.println(directory);
        EpamFileService epamFileService = new EpamFileService();
        EpamFile textFile = epamFileService.createFile(directory, Constants.FILE_POEM_NAME, "txt");
        System.out.println(textFile);
        textFile = epamFileService.renameFile(directory, Constants.FILE_POEM_NAME, "txt", Constants.FILE_NEW_POEM_NAME, "txt");
        System.out.println(textFile);
        List<String> list = new ArrayList<>(Arrays.asList("Testing line1", "Testing line2"));
        epamFileService.addContent(textFile, list);
        List<String> list2 = new ArrayList<>(Arrays.asList("Testing line3", "Testing line4"));
        epamFileService.addWrittenContent(textFile, list2);
        directoryService.addFileList(directory);
        System.out.println(directory.getFileList());
        directoryService.deleteFile(directory, Constants.FILE_NEW_POEM_NAME + ".txt");
    }
}
