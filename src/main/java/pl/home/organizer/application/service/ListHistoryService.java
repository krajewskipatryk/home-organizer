package pl.home.organizer.application.service;


import pl.home.organizer.application.dto.HouseCleanerDto;

import java.util.List;

public interface ListHistoryService {
    List<String> getCleaningList();
    HouseCleanerDto addCleaner(HouseCleanerDto cleanerDto);
}
