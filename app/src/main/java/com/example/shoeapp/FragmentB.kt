package com.example.shoeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentB : Fragment() {
    lateinit var btnSkip: Button
    lateinit var btnNext: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        btnSkip = view.findViewById(R.id.buttonSkip)
        btnNext = view.findViewById(R.id.buttonNext)

        btnSkip.setOnClickListener {
            val intents = Intent(activity,Home::class.java)
            activity?.startActivity(intents)
        }
        btnNext.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout,FragmnetC())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }
        return view
    }


}