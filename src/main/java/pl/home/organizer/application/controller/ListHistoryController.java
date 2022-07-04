package pl.home.organizer.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.home.organizer.application.dto.HouseCleanerDto;
import pl.home.organizer.application.mapper.ListHistoryMapper;
import pl.home.organizer.application.model.request.CleanerDetailsRequestModel;
import pl.home.organizer.application.service.ListHistoryService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class ListHistoryController {
    private final ListHistoryService listHistoryService;

    @PostMapping
    public String addCleaningPosition(@RequestBody CleanerDetailsRequestModel cleanerDetails) {
        HouseCleanerDto cleanerDto = ListHistoryMapper.INSTANCE.cleanerDetailsToCleanerDto(cleanerDetails);

        listHistoryService.addCleaner(cleanerDto);

        return "Record has been added correctly!";
    }

    @GetMapping
    public List<String> getCleaningHistory() {
        return listHistoryService.getCleaningList();
    }
}
