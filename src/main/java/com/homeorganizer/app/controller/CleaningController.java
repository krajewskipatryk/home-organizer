package com.homeorganizer.app.controller;

import com.homeorganizer.app.model.request.GroupIdRequestModel;
import com.homeorganizer.app.service.CleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class CleaningController {
    private final CleaningService cleaningService;

    @PostMapping("assign")
    public void assignGroup(@RequestBody GroupIdRequestModel groupDetails) {
        cleaningService.assignGroup(groupDetails.getId());
    }

    @DeleteMapping("remove/{cleaningId}")
    public void removeFunctionality(@PathVariable Long cleaningId) {
        cleaningService.removeCleaningRecord(cleaningId);
    }

    @PutMapping("approve/{userId}")
    public void approveCleaning(@RequestBody GroupIdRequestModel groupDetails, @PathVariable String userId) {
        cleaningService.approveCleaning(groupDetails.getId(), userId);
    }
}
