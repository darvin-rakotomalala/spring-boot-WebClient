package com.poc.service.application;

import com.poc.model.dto.NoteDTO;

import java.util.List;

public interface NoteCUDSA {
    public NoteDTO createNote(NoteDTO noteDTO);
    public List<NoteDTO> saveAllNotes(List<NoteDTO> notes);
    public NoteDTO updateNote(NoteDTO noteDTO);
    public void deleteNoteById(Long id);
}
