package com.poc.service.bussinesdelegate;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NoteWebClientBDL {
    public Mono<NoteDTO> createNote(NoteDTO noteDTO);
    public Mono<NoteDTO> updateNote(NoteDTO noteDTO);
    public Mono<String> deleteNoteById(Long id);
    public Mono<NoteDTO> getNoteById(Long id);
    public Flux<NotePaginatedDTO> getAllNotesByTitle(String title, int page, int size);
}
