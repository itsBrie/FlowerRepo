package com.brie.flower.utility;

import com.brie.flower.model.Iris;

import java.util.ArrayList;
import java.util.List;

//this class handles reading the file and putting it in a list
//this will get called when the program begins
public class IrisCSVParser {
    private static List<Iris> list = new ArrayList<>();
    private static final String IRIS_CSV = "src/main/resources/Iris.csv";
    private static IrisCSVParser instance;

    /**
     * Singleton pattern
     * @return
     */
    public static IrisCSVParser getInstance() {
        if(instance == null) {
            synchronized ((IrisCSVParser.class)) {
                if(instance == null) {
                    return new IrisCSVParser();
                }
            }
        }
        return instance;
    }

    private IrisCSVParser() {
        readCSV();
    }


    private static void readCSV() {


    }

    public static List<Iris> getIrisDataset() {
        return list;
    }

}
