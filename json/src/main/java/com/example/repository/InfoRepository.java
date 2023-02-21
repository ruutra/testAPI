package com.example.repository;

import com.example.model.Alert;
import com.example.model.Info;
import com.example.model.Ticker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class InfoRepository {

    private final List<Info> infoList;
    private final List<Ticker> tickers;
    private final List<Alert> alerts;

    public List<Info> getAll() {
        return infoList;
    }

    public void addTicker(String userID, String tickerName, int timeFrame, int percent) {
        Alert newAlert = new Alert();
        newAlert.setTimeFrame(timeFrame);
        newAlert.setPercent(percent);

        for (Ticker ticker : tickers) {
            if (ticker.getTicker().equals(tickerName)) {
                alerts.add(newAlert);
                ticker.setAlerts(alerts);
                return;
            } else {
                alerts.clear();
            }
        }
        Ticker newTicker=new Ticker();
        newTicker.setTicker(tickerName);
        alerts.add(newAlert);
        newTicker.setAlerts(alerts);

        for (Info info:infoList){
            if (info.getUserID().equals(userID)){
                tickers.add(newTicker);
                info.setTickers(tickers);
                info.setLastUpdate(String.valueOf(LocalDate.now())+" "+(LocalTime.now()).truncatedTo(ChronoUnit.SECONDS));
                return;
            }
        }
        Info newInfo=new Info();
        newInfo.setUserID(userID);
        tickers.add(newTicker);
        newInfo.setTickers(tickers);
        newInfo.setUuid(UUID.randomUUID());
        newInfo.setLastUpdate(String.valueOf(LocalDate.now())+" "+(LocalTime.now()).truncatedTo(ChronoUnit.SECONDS));

        infoList.add(newInfo);
    }

    public void deleteTicker(String tickerName, int alertIndex) {
        for (Ticker ticker:tickers){
            if (ticker.getTicker().equals(tickerName)){
                for (int i=0;i<alerts.size();i++){
                    if (alertIndex==i){
                        alerts.remove(i);
                    }
                }
            }
        }
    }
}
