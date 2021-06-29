package com.example.shoeapp

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_upload_form.view.*

class UploadAdapter(private val context: Activity, private val price:Array<String>,
                    private val number:Array<String>, private val name:Array<String>,
                    private val brand: Array<String>) :ArrayAdapter<String>(context,R.layout.custom_list, name) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val Row = inflater.inflate(R.layout.custom_list, null, true)
        val Textprice: TextView = Row.findViewById(R.id.Textprice)
        val textNumber: TextView = Row.findViewById(R.id.userNumber)
        val textName: TextView = Row.findViewById(R.id.userName)
        val textBrand: TextView = Row.findViewById(R.id.userBrand)

        Textprice.text = "Price: ${price[position]}"
        textNumber.text = "Number: ${number[position]}"
        textName.text = "Name: ${name[position]}"
        textBrand.text = "Shoe Brand: ${brand[position]}"


        return Row

    }
}