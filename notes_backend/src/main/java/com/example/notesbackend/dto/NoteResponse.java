package com.example.notesbackend.dto;

import com.example.notesbackend.model.Note;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.OffsetDateTime;

/**
 * Response representation for a Note.
 */
@Schema(description = "Response representation of a Note")
public class NoteResponse {

    @Schema(description = "Unique identifier", example = "1")
    private Long id;

    @Schema(description = "Title of the note", example = "Project Ideas")
    private String title;

    @Schema(description = "Content of the note", example = "1. Build a notes app")
    private String content;

    @Schema(description = "Creation timestamp")
    private OffsetDateTime createdAt;

    @Schema(description = "Last update timestamp")
    private OffsetDateTime updatedAt;

    public NoteResponse() {}

    public NoteResponse(Long id, String title, String content, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static NoteResponse from(Note n) {
        return new NoteResponse(n.getId(), n.getTitle(), n.getContent(), n.getCreatedAt(), n.getUpdatedAt());
    }

    // Getters and setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public OffsetDateTime getCreatedAt() { return createdAt; }

    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }

    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}
