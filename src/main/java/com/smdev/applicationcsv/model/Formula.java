package com.smdev.applicationcsv.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Formula implements Serializable {

    private static final long serialVersionUID = 1L;

    @NonNull
    private String value;

    @Override
    public String toString() {
        return "formula: " + value;
    }
}
