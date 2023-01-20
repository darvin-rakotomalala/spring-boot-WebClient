package com.poc.controller;

import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import com.poc.service.bussinesdelegate.NoteWebClientBDL;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "notesClient")
public class NoteWebClientController {

    private final NoteWebClientBDL noteWebClientBDL;

    @Operation(summary = "WS used to create note")
    @PostMapping
    public Mono<NoteDTO> createNote(@RequestBody NoteDTO noteDTO) {
        return noteWebClientBDL.createNote(noteDTO);
    }

    @Operation(summary = "WS used to update note")
    @PutMapping
    public Mono<NoteDTO> updateNote(@RequestBody NoteDTO noteDTO) {
        return noteWebClientBDL.updateNote(noteDTO);
    }

    @Operation(summary = "WS used to delete note by id")
    @DeleteMapping("/{id}")
    public Mono<String> deleteNoteById(@PathVariable("id") Long id) {
        return noteWebClientBDL.deleteNoteById(id);
    }

    @Operation(summary = "WS used to get note by id")
    @GetMapping("/{id}")
    public Mono<NoteDTO> getNoteById(@PathVariable("id") Long id) {
        return noteWebClientBDL.getNoteById(id);
    }

    @Operation(summary = "WS used to get all notes")
    @GetMapping
    public Flux<NotePaginatedDTO> getAllNotesByTitle(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "page", defaultValue = "0", required = false) int page,
            @RequestParam(name = "size", defaultValue = "15", required = false) int size) {
        return noteWebClientBDL.getAllNotesByTitle(title, page, size);
    }

}
