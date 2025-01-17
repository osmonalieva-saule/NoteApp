package com.example.noteapp.ui.fragment.on_board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.noteapp.R
import com.example.noteapp.databinding.FragmentOnBoardBinding
import com.example.noteapp.ui.adaper.OnBoardAdapter


class OnBoardFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
        initTvSkip()
    }

    private fun initTvSkip() = with(binding.viewPager2) {
        binding.tvSend.setOnClickListener {
            when {
                currentItem < 3 -> setCurrentItem(currentItem + 2, true)
            }
        }
    }

    private fun setUpListener() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        tvSend.visibility = View.VISIBLE
                    }

                    1 -> {
                        tvSend.visibility = View.VISIBLE
                    }

                    2 -> {
                        tvSend.visibility = View.GONE
                    }
                }
                super.onPageSelected(position)
            }
        })

    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardAdapter(this)

    }
}