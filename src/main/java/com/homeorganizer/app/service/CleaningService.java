package com.homeorganizer.app.service;


public interface CleaningService {
    void assignGroup(String groupId);
    void removeCleaningRecord(Long id);
    void approveCleaning(String groupId, String userId);
}
