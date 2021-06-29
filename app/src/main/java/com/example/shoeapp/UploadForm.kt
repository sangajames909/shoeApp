package com.example.shoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_upload_form.*

class UploadForm : AppCompatActivity() {
    var brandSelected: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_form)
        val brand = resources.getStringArray(R.array.brand)
        val spin = findViewById<Spinner>(R.id.spinner)
        if (spin != null){
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, brand)
            spin.adapter = adapter

            spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(this@UploadForm,
                        getString(R.string.selected_item) + " " +
                                "" + brand[position], Toast.LENGTH_SHORT).show()
                    brandSelected = brand[position].toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Toast.makeText(this@UploadForm, "Brand selected", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    fun Sumbit(view: View){
        val price = editTextPhone.text.toString()
        val number = editTextNumber.text.toString()
        val name = editTextTextPersonName.text.toString()
        //instance
        val databasehelper = Databasehelper(this)
        if (price.trim() != "" && number.trim() != "" && name.trim() != "") {
            val status = databasehelper.addUsers(UploadModel(Integer.valueOf(price), (Integer.valueOf(number)), name,brandSelected))
            if (status > -1) {
                Toast.makeText(applicationContext, "Record Saved", Toast.LENGTH_LONG).show()
                editTextPhone.text?.clear()
                editTextNumber.text?.clear()
                editTextTextPersonName.text?.clear()

            } else {
                Toast.makeText(applicationContext, "Fields cannot be empty ", Toast.LENGTH_LONG).show()
            }
        }else {
            Toast.makeText(applicationContext, "Something went wrong, try again", Toast.LENGTH_LONG).show()
        }
    }
    fun viewdata(view: View) {
        val databasehelper = Databasehelper(this)
        val viewdata: List<UploadModel> = databasehelper.readData()
        val arrayPrice = Array<String>(viewdata.size) { "0" }
        val arrayNumber = Array<String>(viewdata.size) { "0" }
        val arrayName = Array<String>(viewdata.size) { "null" }
        val arrayBrand = Array<String>(viewdata.size) {"null"}
        var index = 0
        for (e in viewdata) {
            arrayPrice[index] = e.price.toString()
            arrayNumber[index] = e.number.toString()
            arrayName[index] = e.Name.toString()
            arrayBrand[index] = e.brandSelected.toString()
            index++
        }
        val myadapter = UploadAdapter(this, arrayPrice, arrayNumber, arrayName, arrayBrand)
        listView.adapter = myadapter

    }

}
