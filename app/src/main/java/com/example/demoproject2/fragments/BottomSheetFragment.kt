package com.example.demoproject2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.demoproject2.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val peekHeight = arguments?.getInt("peek") ?: 0
        if (peekHeight > 0) {
            val behavior = BottomSheetBehavior.from(view.parent as View)
            behavior.peekHeight = peekHeight
            behavior.isDraggable = true
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
    companion object {
        fun newInstance(peek: Int): BottomSheetFragment {
            val fragment = BottomSheetFragment()
            val args = Bundle()
            args.putInt("peek", peek)
            fragment.arguments = args
            return fragment
        }
    }

}


