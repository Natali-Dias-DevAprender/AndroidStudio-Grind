package com.generation.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.todolist.adapter.TarefaAdapter
import com.generation.todolist.adapter.TaskClickListener
import com.generation.todolist.databinding.FragmentListBinding
import com.generation.todolist.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment(), TaskClickListener {

    private lateinit var binding : FragmentListBinding
    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        mainViewModel.listTarefa()

        // val view = inflater.inflate(R.layout.fragment_list, container, false)

        // val floatingAdd = view.findViewById<FloatingActionButton>(R.id.floatingAdd)

        /*val listTarefas = listOf(
            Tarefa(
                "Arrumar a cama",
                "Arrumar a cama todos os dias",
                "Gabriela",
                "2022-09-26",
                false,
                "Tarefas diárias"
                    ),
            Tarefa(
                "Aulas MBA",
                "Aulas do MBA às 19h",
                "Gabriela",
                "2022-10-10",
                false,
                "MBA USP"
            ),
            Tarefa(
                "Leitura Código Limpo",
                "Leitura do livro às 21h",
                "Gabriela",
                "2022-09-26",
                false,
                "Leitura"
            ),
        )*/

        //Configuração do RecyclerView
        val adapter = TarefaAdapter(this, mainViewModel)
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        //adapter.setList(listTarefas)

        binding.floatingAdd.setOnClickListener {
            mainViewModel.tarefaSelecionada = null
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        mainViewModel.myTarefaResponse.observe(viewLifecycleOwner){
            response -> if (response.body() != null){
                adapter.setList(response.body()!!)
        }
        }

        return binding.root
    }

    override fun onTaskClickListener(tarefa: Tarefa) {
        mainViewModel.tarefaSelecionada = tarefa
        findNavController().navigate(R.id.action_listFragment_to_formFragment)
    }


}