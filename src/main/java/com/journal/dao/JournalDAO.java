package com.journal.dao;

import com.journal.model.JournalEntry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Data Access Object for managing journal entries.
 * Uses in-memory storage for simplicity.
 */
public class JournalDAO {
    private static JournalDAO instance;
    private final Map<Integer, JournalEntry> entries;
    private final AtomicInteger idCounter;

    private JournalDAO() {
        entries = new ConcurrentHashMap<>();
        idCounter = new AtomicInteger(0);
        initializeSampleData();
    }

    public static synchronized JournalDAO getInstance() {
        if (instance == null) {
            instance = new JournalDAO();
        }
        return instance;
    }

    private void initializeSampleData() {
        addEntry(new JournalEntry(0, "Welcome to My Journal",
                "This is my first journal entry. I'm excited to start documenting my thoughts and experiences."));
        addEntry(new JournalEntry(0, "A Productive Day",
                "Today was a productive day. I managed to complete all my tasks and even had time for some reading."));
    }

    public List<JournalEntry> getAllEntries() {
        return new ArrayList<>(entries.values());
    }

    public JournalEntry getEntryById(int id) {
        return entries.get(id);
    }

    public JournalEntry addEntry(JournalEntry entry) {
        int newId = idCounter.incrementAndGet();
        entry.setId(newId);
        entry.setCreatedAt(LocalDateTime.now());
        entry.setUpdatedAt(LocalDateTime.now());
        entries.put(newId, entry);
        return entry;
    }

    public JournalEntry updateEntry(JournalEntry entry) {
        JournalEntry existing = entries.get(entry.getId());
        if (existing != null) {
            existing.setTitle(entry.getTitle());
            existing.setContent(entry.getContent());
            existing.setUpdatedAt(LocalDateTime.now());
            return existing;
        }
        return null;
    }

    public boolean deleteEntry(int id) {
        return entries.remove(id) != null;
    }
}
