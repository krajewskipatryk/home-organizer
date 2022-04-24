package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.dto.ListOfHouseCleaningDto;
import pl.home.organizer.application.model.request.CleanerDetailsRequestModel;
import pl.home.organizer.application.model.response.HouseCleaningList;
import pl.home.organizer.application.service.HouseCleaningListService;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class HouseCleaningListController {
    private final HouseCleaningListService houseCleaningListService;

    @PostMapping
    public String addCleaningPosition(@RequestBody CleanerDetailsRequestModel cleanerDetails) {
        HouseCleanerDto cleanerDto = new HouseCleanerDto();

        BeanUtils.copyProperties(cleanerDetails, cleanerDto);

        HouseCleanerDto returnValue = houseCleaningListService.addCleaner(cleanerDto);

        return "Record has been added correctly!";
    }

    @GetMapping
    public HouseCleaningList getCleaningList() {
        HouseCleaningList houseCleaningList = new HouseCleaningList();

        ListOfHouseCleaningDto houseCleaningListDto = houseCleaningListService.getCleaningList();

        BeanUtils.copyProperties(houseCleaningListDto, houseCleaningList);

        return houseCleaningList;
    }
}
