package home.iren.iNote.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "note_id")
    private Long noteId;

    @NotNull
    @Size(min = 5, message = "Content must be at least 5 characters long")
    @Column(name = "note_content")
    private String noteContent;
}
