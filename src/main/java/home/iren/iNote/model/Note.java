package home.iren.iNote.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long noteId;

    @NotNull
    @Size(min = 5, message = "Content must be at least 5 characters long")
    @Column(name = "note_content")
    private String noteContent;
}
