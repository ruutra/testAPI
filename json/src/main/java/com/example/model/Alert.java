package com.example.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {

    private int timeFrame;
    private int percent;
}
