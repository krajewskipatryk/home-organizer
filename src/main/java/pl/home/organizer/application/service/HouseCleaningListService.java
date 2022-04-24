package pl.home.organizer.application.service;


import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.dto.ListOfHouseCleaningDto;

public interface HouseCleaningListService {
    ListOfHouseCleaningDto getCleaningList();
    HouseCleanerDto addCleaner(HouseCleanerDto cleanerDto);
}
