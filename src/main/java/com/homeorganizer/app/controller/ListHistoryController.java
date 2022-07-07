package com.homeorganizer.app.controller;

import com.homeorganizer.app.dto.HouseCleanerDto;
import com.homeorganizer.app.mapper.ListHistoryMapper;
import com.homeorganizer.app.model.request.CleanerDetailsRequestModel;
import com.homeorganizer.app.service.ListHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class ListHistoryController {
    private final ListHistoryService listHistoryService;

    @PostMapping
    public String addCleaningPosition(@RequestBody CleanerDetailsRequestModel cleanerDetails) {
        HouseCleanerDto cleanerDto = ListHistoryMapper.INSTANCE.cleanerDetailsToCleanerDto(cleanerDetails);

        listHistoryService.addCleaner(cleanerDto);

        return "Record has been added correctly!";
    }

    @GetMapping
    public List<String> getCleaningHistory() {
        return listHistoryService.getCleaningList();
    }
}
