package com.poc.service.bussinesdelegate;

import com.poc.exception.ErrorsEnum;
import com.poc.exception.FunctionalException;
import com.poc.model.dto.NoteDTO;
import com.poc.model.dto.NotePaginatedDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
@Service
public class NoteWebClientBDLImpl implements NoteWebClientBDL {

    @Value("${webClient.baseUrl}")
    private String webClientBaseUrl;

    WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl(webClientBaseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @Override
    public Mono<NoteDTO> createNote(NoteDTO noteDTO) {
        try {
            log.info("----- createNote");
            return webClient.post().uri(webClientBaseUrl)
                    .body(Mono.just(noteDTO), NoteDTO.class)
                    .retrieve()
                    .bodyToMono(NoteDTO.class);
        } catch (Exception e) {
            log.error("Error createNote while calling WS : {}, message : {}", webClientBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public Mono<NoteDTO> updateNote(NoteDTO noteDTO) {
        try {
            log.info("----- updateNote");
            return webClient.put().uri(webClientBaseUrl)
                    .body(Mono.just(noteDTO), NoteDTO.class)
                    .retrieve()
                    .bodyToMono(NoteDTO.class);
        } catch (Exception e) {
            log.error("Error updateNote while calling WS : {}, message : {}", webClientBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public Mono<String> deleteNoteById(Long id) {
        try {
            log.info("----- deleteNoteById : {}", id);
            return webClient.delete().uri(webClientBaseUrl + "/" + id).retrieve().bodyToMono(String.class);
        } catch (Exception e) {
            log.error("Error deleteNoteById while calling WS : {}, message : {}", webClientBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public Mono<NoteDTO> getNoteById(Long id) {
        try {
            log.info("----- getNoteById : {}", id);
            return webClient.get().uri(webClientBaseUrl + "/" + id)
                    .retrieve().bodyToMono(NoteDTO.class);
        } catch (Exception e) {
            log.error("Error getNoteById while calling WS : {}, message : {}", webClientBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

    @Override
    public Flux<NotePaginatedDTO> getAllNotesByTitle(String title, int page, int size) {
        try {
            log.info("----- getAllNotesByTitle - title : {} page : {} size : {}", title, page, size);
            if (StringUtils.isBlank(title)) {
                return webClient.get().uri(webClientBaseUrl + "?page=" + page + "&size=" + size)
                        .retrieve().bodyToFlux(NotePaginatedDTO.class);
            } else {
                return webClient.get().uri(webClientBaseUrl + "?title=" + title + "&page=" + page + "&size=" + size).retrieve().bodyToFlux(NotePaginatedDTO.class);
            }
        } catch (Exception e) {
            log.error("Error getAllNotesByTitle while calling WS : {}, message : {}", webClientBaseUrl, e.getMessage());
            e.printStackTrace();
            throw new FunctionalException(ErrorsEnum.ERR_CALL_API_NOTE.getErrorMessage());
        }
    }

}
