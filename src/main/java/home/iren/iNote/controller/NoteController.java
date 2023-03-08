package home.iren.iNote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Note - home page");
        return "index";
    }

}