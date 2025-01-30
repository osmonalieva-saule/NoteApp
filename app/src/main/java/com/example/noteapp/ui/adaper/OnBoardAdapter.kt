package com.example.noteapp.ui.adaper

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.noteapp.ui.fragment.on_board.OnBoardPagingFragment
import com.example.noteapp.ui.fragment.on_board.OnBoardPagingFragment.Companion.ARG_ON_BOARD_POSITION


class OnBoardAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): OnBoardPagingFragment = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(ARG_ON_BOARD_POSITION , position)

        }
    }
}