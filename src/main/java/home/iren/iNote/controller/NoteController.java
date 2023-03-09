package home.iren.iNote.controller;

import home.iren.iNote.model.Note;
import home.iren.iNote.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/add")
    public String noteAdd(Model model) {
        return "notes-add";
    }

    @PostMapping("/add")
    public String noteSave(@RequestParam String content, Model model) {
        Note note = new Note();
        note.setNoteContent(content);
        noteRepo.save(note);
        return "redirect:/notes";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        if(!noteRepo.existsById(id)){
            return "not-found";
        }
        Optional<Note> note = noteRepo.findById(id);
        ArrayList<Note> result = new ArrayList<>();
        note.ifPresent(result::add);
        model.addAttribute("noteById", result);
        return "notes-details";
    }

    @GetMapping("/{id}/edit")
    public String noteEdit(@PathVariable(value = "id") Long id, Model model) {
        if(!noteRepo.existsById(id)){
            return "not-found";
        }
        Optional<Note> note = noteRepo.findById(id);
        ArrayList<Note> result = new ArrayList<>();
        note.ifPresent(result::add);
        model.addAttribute("noteById", result);
        return "notes-edit";
    }

    @PostMapping("/{id}/edit")
    public String update(@RequestParam String content, @PathVariable(value = "id") Long id, Model model) {
        Note newNote = noteRepo.findById(id).orElseThrow();
        newNote.setNoteContent(content);
        noteRepo.save(newNote);
        return "redirect:/notes";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable(value = "id") Long id, Model model) {
        Note note = noteRepo.findById(id).orElseThrow();
        noteRepo.delete(note);
        return "redirect:/notes";
    }
}