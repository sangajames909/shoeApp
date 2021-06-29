package com.example.shoeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmnetC : Fragment() {
    lateinit var btnNext: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragmnet_c, container, false)
        btnNext = view.findViewById(R.id.skip)
        btnNext.setOnClickListener {
            val intent = Intent(activity,Home::class.java)
            activity?.startActivity(intent)
        }
        return view
    }

}