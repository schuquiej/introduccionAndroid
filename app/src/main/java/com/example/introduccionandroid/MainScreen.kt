package com.example.introduccionandroid

import com.example.introduccionandroid.vm.NoteViewModel


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.introduccionandroid.model.Note

@Composable
fun MainScreen(vm: NoteViewModel) {
    // TODO: Observar la lista de notas desde el ViewModel
    val notes by vm.notes.collectAsStateWithLifecycle()

    // TODO: Estado local para el texto de entrada
    var input by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Notas (Compose + MVVM)",
            style = MaterialTheme.typography.titleLarge
        )

        // TODO: Campo de texto para escribir la nota
        OutlinedTextField(
            value = input,
            onValueChange = { input = it }, // TODO: validar largo/dígitos si aplica
            label = { Text("Escribe una nota") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        // TODO: Botón Agregar (por ahora SIN acción)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(Modifier.weight(1f))
            Button(
                onClick = {
                    // TODO: llamar vm.addNote(input) y limpiar input
                }
            ) {
                Text("Agregar")
            }
        }

        Divider()

        // TODO: Lista de notas (sin acción de borrado aún)
        if (notes.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Sin notas. Agrega la primera 👇")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(notes, key = { it.id }) { note ->
                    NoteItem(
                        note = note,
                        onDelete = {
                            // TODO: invocar vm.removeNote(note.id)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun NoteItem(
    note: Note,
    onDelete: () -> Unit
) {
    // TODO: Tarjeta simple con texto y botón Eliminar (acción vacía por ahora)
    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 1.dp,
        shadowElevation = 0.dp,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = note.text,
                modifier = Modifier.weight(1f),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(Modifier.width(12.dp))
            OutlinedButton(onClick = {
                // TODO: llamar callback para eliminar
                onDelete()
            }) {
                Text("Eliminar")
            }
        }
    }
}
