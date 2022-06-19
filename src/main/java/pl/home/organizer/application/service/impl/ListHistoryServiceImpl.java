package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.entity.CleaningEntity;
import pl.home.organizer.application.repository.ListHistoryRepository;
import pl.home.organizer.application.service.ListHistoryService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ListHistoryServiceImpl implements ListHistoryService {
    private final ListHistoryRepository listHistoryRepository;

    @Override
    public HouseCleanerDto addCleaner(HouseCleanerDto cleanerDto) {
        CleaningEntity cleanerEntity = new CleaningEntity();
        BeanUtils.copyProperties(cleanerDto, cleanerEntity);
        LocalDate cleaningDate = LocalDate.now();

        cleanerEntity.setCleaningDate(cleaningDate);
        listHistoryRepository.save(cleanerEntity);

        HouseCleanerDto returnValue = new HouseCleanerDto();
        BeanUtils.copyProperties(cleanerEntity, returnValue);

        return returnValue;
    }

    @Override
    public List<String> getCleaningList() {
        List<CleaningEntity> houseCleaningList = listHistoryRepository.findAll();

        List<String> convertedValue = houseCleaningList.stream()
                .map(list -> list.getOrder() + ". " + list.getOrder() + " user cleaned at " + list.getCleaningDate())
                .collect(Collectors.toList());
        return convertedValue;
    }
}
