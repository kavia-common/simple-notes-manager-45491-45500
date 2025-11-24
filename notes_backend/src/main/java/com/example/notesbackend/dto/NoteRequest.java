package com.example.notesbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Request payload for creating/updating a note.
 */
@Schema(description = "Request payload for creating/updating a Note")
public class NoteRequest {

    @NotBlank
    @Size(max = 200)
    @Schema(description = "Title of the note", example = "Project Ideas", maxLength = 200)
    private String title;

    @NotBlank
    @Size(max = 4000)
    @Schema(description = "Content of the note", example = "1. Build a notes app", maxLength = 4000)
    private String content;

    public NoteRequest() {}

    public NoteRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getters and setters
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
