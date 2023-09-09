package com.brie.flower.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Iris {

    private Integer id;

    private Double SepalLengthCm;

    private Double SepalWidthCm;
    private Double PetalLengthCm;
    private Double PetalWidthCm;
    private String Species;


}
