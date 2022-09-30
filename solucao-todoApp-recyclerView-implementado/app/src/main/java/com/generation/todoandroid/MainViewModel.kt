package com.generation.todoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todoandroid.api.Repository
import com.generation.todoandroid.model.Categoria
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (
   private val repository: Repository
      ): ViewModel() {




    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    //Aqui pegaremos as requisições dentro da nossa internet.
    init {
        listCategoria()
    }

    fun listCategoria(){
        viewModelScope.launch {

          //Adicionando o bloco try & catch para evitar que o nosso programa quebre.
           try {
            val response = repository.listCategoria()
            _myCategoriaResponse.value = response

           }catch (e: Exception) {
             Log.d("Error", e.message.toString())
           }


        }

    }


}