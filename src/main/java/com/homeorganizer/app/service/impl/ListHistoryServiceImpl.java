package com.homeorganizer.app.service.impl;

import com.homeorganizer.app.dto.HouseCleanerDto;
import com.homeorganizer.app.entity.CleaningEntity;
import com.homeorganizer.app.mapper.ListHistoryMapper;
import com.homeorganizer.app.repository.ListHistoryRepository;
import com.homeorganizer.app.service.ListHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ListHistoryServiceImpl implements ListHistoryService {
    private final ListHistoryRepository listHistoryRepository;

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
