package com.smdev.applicationcsv.csv;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Argument implements Serializable {

    @NonNull
    private String name;

    @NonNull
    private Integer value;
}
