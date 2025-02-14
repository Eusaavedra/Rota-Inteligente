package com.example.rotainteligente.repository

import com.example.rotainteligente.datasource.DataSource
import com.example.rotainteligente.model.Counter
import com.example.rotainteligente.model.Entrada
import kotlinx.coroutines.flow.Flow

class Repository {
    private val dataSource: DataSource = DataSource()

    fun contar(contagem: Counter) {
        dataSource.contar(contagem)
    }
    fun getDados(): Flow<MutableList<Entrada>>{
        return dataSource.getEntrada()
    }
}
