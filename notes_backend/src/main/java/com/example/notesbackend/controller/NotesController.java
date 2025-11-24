package com.example.notesbackend.controller;

import com.example.notesbackend.dto.NoteRequest;
import com.example.notesbackend.dto.NoteResponse;
import com.example.notesbackend.model.Note;
import com.example.notesbackend.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing notes.
 */
@RestController
@RequestMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Notes", description = "CRUD operations for notes")
public class NotesController {

    private final NoteService service;

    public NotesController(NoteService service) {
        this.service = service;
        // Ensure we have some data to preview
        this.service.seedIfEmpty();
    }

    // PUBLIC_INTERFACE
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new note",
            description = "Creates a new note with title and content.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Note created",
                            content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content)
            }
    )
    public NoteResponse create(
            @Valid @RequestBody NoteRequest request
    ) {
        /** Creates a new note resource. */
        Note saved = service.create(request);
        return NoteResponse.from(saved);
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(
            summary = "List all notes",
            description = "Returns an array of notes.",
            responses = @ApiResponse(responseCode = "200", description = "List of notes",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = NoteResponse.class)))))
    public List<NoteResponse> list() {
        /** Returns all notes. */
        return service.findAll().stream().map(NoteResponse::from).toList();
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(
            summary = "Get note by id",
            description = "Returns a single note by its identifier.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note found",
                            content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "404", description = "Note not found", content = @Content)
            }
    )
    public NoteResponse getById(
            @Parameter(description = "ID of the note to retrieve", example = "1")
            @PathVariable Long id
    ) {
        /** Returns a single note by id. */
        return NoteResponse.from(service.findById(id));
    }

    // PUBLIC_INTERFACE
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Update note by id",
            description = "Replaces the title and content of an existing note.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note updated",
                            content = @Content(schema = @Schema(implementation = NoteResponse.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error", content = @Content),
                    @ApiResponse(responseCode = "404", description = "Note not found", content = @Content)
            }
    )
    public NoteResponse update(
            @Parameter(description = "ID of the note to update", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody NoteRequest request
    ) {
        /** Updates an existing note by id. */
        return NoteResponse.from(service.update(id, request));
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete note by id",
            description = "Deletes an existing note by id.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Note deleted"),
                    @ApiResponse(responseCode = "404", description = "Note not found", content = @Content)
            }
    )
    public void delete(
            @Parameter(description = "ID of the note to delete", example = "1")
            @PathVariable Long id
    ) {
        /** Deletes a note by id. */
        service.delete(id);
    }
}
