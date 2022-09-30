package com.generation.todoandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.generation.todoandroid.databinding.FragmentFormBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    //Aqui indicaremos que toda a instancia da ViewModel
    // que criarmos e que a gente ultilizar o nosso activityViewModel ,poderemos criar a instancia da viewModel
    //pra sobreviver em todas as nossas telas.
    private val mainViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner){
            Log.d("Requisicao",it.body().toString())
        }

        binding.buttonSalvar.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_listFragment)
        }

        return binding.root
    }
}