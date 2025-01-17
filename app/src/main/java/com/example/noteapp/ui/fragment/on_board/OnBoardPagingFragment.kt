package com.example.noteapp.ui.fragment.on_board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardPagingBinding


class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        initBtnNext()
    }

    private fun initBtnNext() {
        binding.btnGetStarted.setOnClickListener {
            findNavController().navigate(R.id.noteFragment)
        }
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ON_BOARD_POSITION)) {
            0 -> {
                txtOnboardTitle.text = "Удобство"
                txtOnboardDescription.text =
                    "Создавайте заметки в два клика! Записывайте мысли, идеи и важные задачи мгновенно."
                lottie.setAnimation(R.raw.lottie3)
                btnGetStarted.visibility = View.GONE
            }

            1 -> {
                txtOnboardTitle.text = "Организация"
                txtOnboardDescription.text =
                    "Организуйте заметки по папкам и тегам. Легко находите нужную информацию в любое время."
                lottie.setAnimation(R.raw.lottie2)
                btnGetStarted.visibility = View.GONE
            }

            2 -> {
                txtOnboardTitle.text = "Синхронизация"
                txtOnboardDescription.text =
                    "Синхронизация на всех устройствах. Доступ к записям в любое время и в любом месте."
                lottie.setAnimation(R.raw.lottie3)
                btnGetStarted.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        const val ARG_ON_BOARD_POSITION = "onBoard"
    }
}