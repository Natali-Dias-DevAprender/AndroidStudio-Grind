package com.generation.todoandroid.model

data class Tarefa(
    var id : Long,  //Adiconando uma variavél com o id
    var nome: String,
    var descricao: String,
    var responsavel: String,
    var data: String,
    var status: Boolean,
    var categoria: Categoria
        ) {

}