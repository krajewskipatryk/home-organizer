package com.homeorganizer.app.service;


import com.homeorganizer.app.dto.HouseCleanerDto;

import java.util.List;

public interface ListHistoryService {
    List<String> getCleaningList();
    HouseCleanerDto addCleaner(HouseCleanerDto cleanerDto);
}
