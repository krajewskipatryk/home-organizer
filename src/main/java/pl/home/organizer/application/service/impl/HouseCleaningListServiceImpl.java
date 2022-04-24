package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.dto.ListOfHouseCleaningDto;
import pl.home.organizer.application.entity.HouseCleaningListEntity;
import pl.home.organizer.application.repository.HouseCleaningListRepository;
import pl.home.organizer.application.service.HouseCleaningListService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class HouseCleaningListServiceImpl implements HouseCleaningListService {
    private final HouseCleaningListRepository houseCleaningListRepository;

    @Override
    public ListOfHouseCleaningDto getCleaningList() {
        ListOfHouseCleaningDto listOfHouseCleaningDto = new ListOfHouseCleaningDto();

        List<HouseCleaningListEntity> houseCleaningList = houseCleaningListRepository.findAll();
        listOfHouseCleaningDto.setHouseCleaningList(houseCleaningList);

        return listOfHouseCleaningDto;
    }

    @Override
    public HouseCleanerDto addCleaner(HouseCleanerDto cleanerDto) {
        HouseCleaningListEntity cleanerEntity = new HouseCleaningListEntity();

        BeanUtils.copyProperties(cleanerDto, cleanerEntity);

        houseCleaningListRepository.save(cleanerEntity);

        HouseCleanerDto returnValue = new HouseCleanerDto();
        BeanUtils.copyProperties(cleanerEntity, returnValue);

        return returnValue;
    }

}
