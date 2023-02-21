package com.example.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticker {

    private String ticker;
    private List<Alert> alerts;
}
