package home.iren.iNote.repository;

import home.iren.iNote.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
