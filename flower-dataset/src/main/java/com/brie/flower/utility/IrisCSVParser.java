package com.brie.flower.utility;

import com.brie.flower.model.Iris;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//this class handles reading the file and putting it in a list
//this will get called when the program begins
public class IrisCSVParser {
    private static List list = Collections.synchronizedList(new ArrayList<>());
    private static final String IRIS_CSV = "src/main/resources/Iris.csv";
    private static IrisCSVParser instance;

    /**
     * Singleton pattern
     *
     * @return
     */
    public static IrisCSVParser getInstance() throws FileNotFoundException { //accessible constructor
        if (instance == null) {
            synchronized ((IrisCSVParser.class)) {
                if (instance == null) {
                    return new IrisCSVParser();
                }
            }
        }
        return instance;
    }

    private IrisCSVParser() throws FileNotFoundException { //private constructor calls the readCSV method
        readCSV();
    }


    private static void readCSV() throws FileNotFoundException {

        //Scan the csv file
        Scanner scan = new Scanner(new FileReader(IRIS_CSV));
        String[] data;
        String line = "";
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            data = line.split(",");
            Iris irisObject = new Iris(Integer.parseInt(data[0].trim()), Double.parseDouble(data[1].trim()), Double.parseDouble(data[2].trim()), Double.parseDouble(data[3].trim()), Double.parseDouble(data[4].trim()), data[5].trim());
            list.add(irisObject);
        }
    }


    public static List getIrisDataset() {
        return list;
    }

}
