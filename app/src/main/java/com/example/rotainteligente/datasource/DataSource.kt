package com.example.rotainteligente.datasource

import android.util.Log
import com.example.rotainteligente.model.Counter
import com.example.rotainteligente.model.Entrada
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance();
    private val collectionContador = firestore.collection("contador", )
    private val collectionEntrada = firestore.collection("entrada")

    private val _allTasks = MutableStateFlow<MutableList<Entrada>>(mutableListOf())
    private val allTasks: StateFlow<MutableList<Entrada>> = _allTasks

    fun contar(contagem: Counter) {
        val documentReference = collectionContador.document()
        val taskPayload = mapOf(
            "cont" to contagem.counter,
        )

        documentReference.set(taskPayload)
            .addOnCompleteListener {
                Log.d("Firestore", "Documento Salvo.")
            }
            .addOnFailureListener {
                Log.d("Firestore", "Erro ao salvar o documento. ")
            }
            .addOnCanceledListener {
                Log.d("Firestore", "A ação foi cancelada.")
            }
            .addOnCompleteListener {
                Log.d("Firestore", "Ação finalizada.")
            }
    }

    fun getEntrada(): Flow<MutableList<Entrada>> {
        val taskList: MutableList<Entrada> = mutableListOf()

        firestore.collection("entrada").get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    val task = document.toObject<Entrada>()
                    Log.d("REPOSITORY", task.numeroRota)

                    taskList.add(task)
                    _allTasks.value = taskList
                }
            }
            .addOnCompleteListener {
                println("COMPLETED GET TASKS")
            }
        return allTasks
    }
}
