package com.example.introduccionandroid.vm




import androidx.lifecycle.ViewModel
import com.example.introduccionandroid.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NoteViewModel : ViewModel() {

    // TODO: Estado observable de la lista de notas.
    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes: StateFlow<List<Note>> = _notes

    // TODO: Generador de IDs (p. ej., AtomicLong). Opcionalmente, arranca en 0.
    // Sugerencia:
    // private val seq = AtomicLong(0)

    // TODO: Implementar agregar nota.
    // Requisitos:
    // - Ignorar entradas vacías (trim).
    // - Generar ID incremental (seq.incrementAndGet()).
    // - Actualizar _notes de forma inmutable (it + nuevaNota).
    fun addNote(text: String) {
        // val t = text.trim()
        // if (t.isEmpty()) return
        // val newNote = Note(id = seq.incrementAndGet(), text = t)
        // _notes.update { it + newNote }
    }

    // TODO: Implementar eliminar nota por id.
    // Requisitos:
    // - Filtrar la lista removiendo la nota cuyo id coincida.
    fun removeNote(id: Long) {
        // TODO: implementar
        // Sugerencia:
        // _notes.update { list -> list.filterNot { it.id == id } }
    }
}
