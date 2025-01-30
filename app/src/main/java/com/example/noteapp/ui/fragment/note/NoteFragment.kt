package com.example.noteapp.ui.fragment.note

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.lottie.Lottie.initialize
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.ui.adaper.NoteAdapter
import com.example.noteapp.ui.utils.PreferenceHelper


class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter()
    private var flag = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        getData()
    }

    private fun getData() {
        App.appDatabase?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)

        }

    }

    private fun initialize() {
        binding.rvNotes.apply {
            //layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
        binding.imgGridLayout.setOnClickListener {
            if (flag) {
                binding.imgGridLayout.setImageResource(R.drawable.ic_grid_layout)
                binding.rvNotes.layoutManager = GridLayoutManager(requireContext(), 2)
                flag = false
            } else {
                binding.imgGridLayout.setImageResource(R.drawable.ic_linear_layout)
                binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
                flag = true
            }
        }
    }

    private fun setupListener() = with(binding) {
        val sharedPreferences = PreferenceHelper
        sharedPreferences.unit(requireContext())
//        btnSave.setOnClickListener {
//            val et = etText.text.toString()
//            sharedPreferences.text = et
//            txtText.text = et
//        }
//        txtText.text = sharedPreferences.text

        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDeatailFragment, null,
                navOptions {
                    anim {
                        enter = R.anim.slide_in_right
                        exit = R.anim.slide_out_left
                    }
                })
        }
    }
}
