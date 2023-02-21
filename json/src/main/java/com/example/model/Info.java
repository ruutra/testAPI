package com.example.model;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Info {

    private String userID;
    private List<Ticker> tickers;
    private UUID uuid;
    private String lastUpdate;

    public void setUserID(String userID) {
        if (userID.startsWith("LT")) {
            this.userID = userID;
        }
    }
}
