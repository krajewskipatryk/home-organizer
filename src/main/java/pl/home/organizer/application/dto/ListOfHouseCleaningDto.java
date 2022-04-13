package pl.home.organizer.application.dto;

import lombok.Getter;
import lombok.Setter;
import pl.home.organizer.application.entity.HouseCleaningListEntity;

import java.util.List;


@Getter
@Setter
public class ListOfHouseCleaningDto {
    private List<HouseCleaningListEntity> houseCleaningList;
}
