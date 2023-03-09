package home.iren.iNote.controller;

import home.iren.iNote.model.Note;
import home.iren.iNote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteRepository noteRepo;

    @GetMapping
    public String notesPage(Model model) {
        Iterable<Note> notesList = noteRepo.findAll();
        model.addAttribute("noteslist", notesList);
        return "notes";
    }
}