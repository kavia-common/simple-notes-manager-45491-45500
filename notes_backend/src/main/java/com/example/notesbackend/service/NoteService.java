package com.example.notesbackend.service;

import com.example.notesbackend.dto.NoteRequest;
import com.example.notesbackend.exception.NotFoundException;
import com.example.notesbackend.model.Note;
import com.example.notesbackend.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service encapsulating CRUD operations for notes.
 */
@Service
@Transactional
public class NoteService {

    private final NoteRepository repo;

    public NoteService(NoteRepository repo) {
        this.repo = repo;
    }

    // PUBLIC_INTERFACE
    public Note create(NoteRequest req) {
        /** Creates and persists a new Note from request payload. */
        Note n = new Note(req.getTitle(), req.getContent());
        return repo.save(n);
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public List<Note> findAll() {
        /** Returns all notes. */
        return repo.findAll();
    }

    // PUBLIC_INTERFACE
    @Transactional(readOnly = true)
    public Note findById(Long id) {
        /** Returns a note by id or throws NotFoundException. */
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Note with id " + id + " not found"));
    }

    // PUBLIC_INTERFACE
    public Note update(Long id, NoteRequest req) {
        /** Updates a note by id using request payload. */
        Note n = findById(id);
        n.setTitle(req.getTitle());
        n.setContent(req.getContent());
        return repo.save(n);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        /** Deletes a note by id. */
        if (!repo.existsById(id)) {
            throw new NotFoundException("Note with id " + id + " not found");
        }
        repo.deleteById(id);
    }

    // PUBLIC_INTERFACE
    public void seedIfEmpty() {
        /** Seeds repository with sample notes if empty. */
        if (repo.count() == 0) {
            repo.save(new Note("Welcome to Notes", "This is your first note. Feel free to edit or delete it."));
            repo.save(new Note("Quick Tips", "Use POST /notes to create, GET /notes to list."));
            repo.save(new Note("Todos", "1) Implement frontend\n2) Wire auth (optional)\n3) Polish UI"));
        }
    }
}
