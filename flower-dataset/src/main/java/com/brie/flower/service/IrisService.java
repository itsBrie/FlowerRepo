package com.brie.flower.service;

import com.brie.flower.model.Iris;
import com.brie.flower.utility.IrisCSVParser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//What actions should we take for the suggested class
@Service
public class IrisService {
    //CRUD Operations
    private List<Iris> irisList = IrisCSVParser.getIrisDataset();

    public List<Iris> findAll() {
        return irisList;
    }

    public Iris findBy(Integer id) { //searching list for specific ID
        Optional<Iris> optIris = irisList.stream().filter(e -> e.getId().equals(id)).findFirst();
        return optIris.orElse(null);
    }

    public Iris addIris(Iris iris) { //add an iris to the list
        // TODO: Create validation in case iris is null.
        if (iris == null) {
            System.out.println("Iris cannot be null");
            throw new NullPointerException("Iris cannot be nulll");
        }
        // TODO: Create validation to ensure unique ID;
//        Optional<Iris> optIris = irisList.stream().filter(e->e.getId().equals(iris.getId())).findFirst();
//        if (optIris.isPresent()){
//            System.out.println("This Iris ID is already in the list, select another one");
//        }
        irisList.add(iris);
        return findBy(iris.getId());
    }


    public Iris updateIris(Iris iris,Integer id) {  //updating an iris in the list

        Iris zeroIris = new Iris(0, 0.0, 0.0, 0.0, 0.0, " ");
//        TODO: Validate iris is NOT null
        if (iris == null) {
            System.out.println("Iris cannot be null");
            throw new NullPointerException("Iris cannot be null");
        } else if (iris.equals(zeroIris)) {
            System.out.println("Iris cannot be zero");
            throw new IllegalArgumentException("Id must be valid");
        } else if (!iris.getId().equals(id)) {
            throw new IllegalArgumentException("Id does not match");
        }

//        TODO: Check if incoming iris is present before we update (store idx if present)
        Optional<Iris> optIris = irisList.stream().filter(e -> e.getId().equals(iris.getId())).findFirst();
        if (!optIris.isPresent()) {
            System.out.println("This Iris ID is already in the list, select another one");
            throw new NullPointerException("Iris cannot be null");
        }
        int idx = irisList.indexOf(optIris.get());
        // example of updating an attribute;

        irisList.set(idx, iris);
        return findBy(iris.getId());
    }

    public Iris deleteIris(Integer id) { //removing iris from list, by id
        Iris foundIris = findBy(id);
        if (foundIris != null) {
            irisList.remove(id);

        }
        return foundIris;
    }


}
