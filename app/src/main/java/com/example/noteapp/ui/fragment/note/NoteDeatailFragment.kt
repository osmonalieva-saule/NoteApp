package com.example.noteapp.ui.fragment.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp.App
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentNoteBinding
import com.example.noteapp.databinding.FragmentNoteDeatailBinding
import com.example.noteapp.data.db.model.NoteModel


class NoteDeatailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDeatailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDeatailBinding.inflate(inflater, container, false)
        return binding.root
    }
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupListener()
}
    private fun setupListener() = with(binding) {
        btnAdd.setOnClickListener{
            val etTitle:String = etTitle.text.toString()
            val etDescription:String = etDescription.text.toString()
            App.appDatabase?.noteDao()?.insert(NoteModel(etTitle, etDescription))
            findNavController().navigateUp()
    }
  }
}