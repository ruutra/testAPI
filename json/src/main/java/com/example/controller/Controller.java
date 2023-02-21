package com.example.controller;

import com.example.service.InfoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/json")
public class Controller {

    private final InfoService jsonService;
    ObjectMapper mapper = new ObjectMapper();

    @GetMapping(value = "/{userID}/{tickerName}/{timeFrame}/{percent}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String addJson(@RequestParam("action") String action,
                                        @PathVariable("userID") String userID,
                                        @PathVariable("tickerName") String tickerName,
                                        @PathVariable("timeFrame") int timeFrame,
                                        @PathVariable("percent") int percent) throws JsonProcessingException {
        if (action.equals("add")) {
            jsonService.addTicker(userID, tickerName, timeFrame, percent);
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonService.getAllInfo());
    }

    @GetMapping(value = "/{tickerName}/{alertIndex}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteJson(@RequestParam("action") String action,
                                        @PathVariable("tickerName") String tickerName,
                                        @PathVariable("alertIndex") int alertIndex) throws JsonProcessingException {
        if (action.equals("delete")) {
            jsonService.deleteTicker(tickerName, alertIndex);
        }
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonService.getAllInfo());
    }
}
