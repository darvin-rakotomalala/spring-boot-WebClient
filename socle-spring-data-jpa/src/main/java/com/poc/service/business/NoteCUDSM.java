package com.poc.service.business;

import com.poc.model.domain.Note;

import java.util.List;

public interface NoteCUDSM {
    public Note createOrUpdateNote(Note note);
    public List<Note> saveAllNotes(List<Note> notes);
    public void deleteNoteById(Long id);
}
