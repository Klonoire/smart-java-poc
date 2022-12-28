package com.icinf.smartmicroservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private int octave;
    private String note;
    private double frequency;
    private int smartId;
}
