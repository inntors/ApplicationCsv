package com.smdev.applicationcsv.csv;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Formula implements Serializable {

    @NonNull
    private String formula;
}
