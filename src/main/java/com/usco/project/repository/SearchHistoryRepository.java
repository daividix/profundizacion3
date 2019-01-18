package com.usco.project.repository;

import java.util.List;

import com.usco.project.entity.SearchHistory;

import org.springframework.stereotype.Repository;

@Repository("search_history_repository")
public interface SearchHistoryRepository {

    public abstract List<SearchHistory> findById(Long id);
}