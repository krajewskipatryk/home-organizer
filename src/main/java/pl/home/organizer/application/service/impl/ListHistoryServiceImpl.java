package pl.home.organizer.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.entity.CleaningEntity;
import pl.home.organizer.application.mapper.ListHistoryMapper;
import pl.home.organizer.application.repository.ListHistoryRepository;
import pl.home.organizer.application.service.ListHistoryService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ListHistoryServiceImpl implements ListHistoryService {
    @Autowired
    public ListHistoryRepository listHistoryRepository;

    @Override
    public HouseCleanerDto addCleaner(HouseCleanerDto cleanerDto) {
        CleaningEntity cleanerEntity;
        cleanerEntity = ListHistoryMapper.INSTANCE.cleanerDtoToCleanerEntity(cleanerDto);
        LocalDate cleaningDate = LocalDate.now();

        listHistoryRepository.save(cleanerEntity);

        return ListHistoryMapper.INSTANCE.cleanerEntityToCleanerDto(cleanerEntity);
    }

    @Override
    public List<String> getCleaningList() {
        return null;
    }
}
