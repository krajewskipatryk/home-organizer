package pl.home.organizer.application.controller.houseCleaningList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.model.request.CleanerDetailsRequestModel;
import pl.home.organizer.application.service.HouseCleaningListService;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class AddToHouseCleaningListController {
    private final HouseCleaningListService houseCleaningListService;

    @PostMapping
    public String addCleaningPosition(@RequestBody CleanerDetailsRequestModel cleanerDetailsRequestModel) {
        HouseCleanerDto houseCleanerDto = new HouseCleanerDto();

        BeanUtils.copyProperties(cleanerDetailsRequestModel, houseCleanerDto);

        houseCleaningListService.addCleaner(houseCleanerDto);

        return "Record has been added correctly!";
    }
}
