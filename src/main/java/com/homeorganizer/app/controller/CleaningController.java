package com.homeorganizer.app.controller;

import com.homeorganizer.app.service.CleaningService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("cleaning")
public class CleaningController {
    private final CleaningService cleaningService;

    @PostMapping("/{groupId}")
    public void setAssignedGroup(@PathVariable String groupId) {
        cleaningService.assignGroup(groupId);
    }

    @DeleteMapping("/{cleaningId}")
    public void deleteCleaning(@PathVariable Long cleaningId) {
        cleaningService.deleteCleaning(cleaningId);
    }

    @PutMapping("/{groupId}/{userId}")
    public void updateCleaningDetails(@PathVariable String groupId, @PathVariable String userId) {
        cleaningService.approveCleaning(groupId, userId);
    }
}
