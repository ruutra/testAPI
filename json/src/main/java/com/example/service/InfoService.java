package com.example.service;

import com.example.model.Info;
import com.example.repository.InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfoService {

    private final InfoRepository infoRepository;

    public void addTicker(String userID, String tickerName, int timeFrame, int percent){
        infoRepository.addTicker(userID, tickerName,timeFrame,percent);
    }

    public void deleteTicker(String tickerName, int alertIndex) {
        infoRepository.deleteTicker(tickerName, alertIndex);
    }

    public List<Info> getAllInfo() {
        return infoRepository.getAll();
    }
}
