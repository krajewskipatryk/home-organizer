package pl.home.organizer.application.controller.houseCleaningList;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.home.organizer.application.dto.ListOfHouseCleaningDto;
import pl.home.organizer.application.model.response.HouseCleaningList;
import pl.home.organizer.application.service.HouseCleaningListService;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class GetHouseCleaningListController {
    private final HouseCleaningListService houseCleaningListService;

    @GetMapping
    public HouseCleaningList getCleaningList() {
        HouseCleaningList houseCleaningList = new HouseCleaningList();

        ListOfHouseCleaningDto houseCleaningListDto = houseCleaningListService.getCleaningList();

        BeanUtils.copyProperties(houseCleaningListDto, houseCleaningList);

        return houseCleaningList;
    }
}
