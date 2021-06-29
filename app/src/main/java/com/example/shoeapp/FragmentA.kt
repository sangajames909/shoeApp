package com.example.shoeapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class FragmentA : Fragment() {
    lateinit var btnskip: Button
    lateinit var btnnext: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        btnskip = view.findViewById(R.id.btnSkip)
        btnnext = view.findViewById(R.id.btnNext)

        btnskip.setOnClickListener {
            val intents = Intent(activity, Home::class.java)
            activity?.startActivity(intents)
        }
        btnnext.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.frameLayout,FragmentB())
            transaction?.disallowAddToBackStack()
            transaction?.commit()
        }


        return view
    }

}