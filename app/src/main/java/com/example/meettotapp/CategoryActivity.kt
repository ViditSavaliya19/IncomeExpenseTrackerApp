package com.example.meettotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.meettotapp.adapter.CategoryAdapter
import com.example.meettotapp.helper.DbHelper
import com.example.meettotapp.model.CategoryModel

class CategoryActivity : AppCompatActivity() {
    lateinit var rvCategory: RecyclerView
    lateinit var btnAddCategor: Button
    lateinit var edtCategory:EditText
    var list = arrayListOf<CategoryModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
       var db = DbHelper(this)
        list = db.getCategory()

        initBinding()
    }

    private fun initBinding() {
        btnAddCategor=findViewById<Button>(R.id.btnAddCategory)
        edtCategory=findViewById<EditText>(R.id.edtCategory)
        rvCategory=findViewById<RecyclerView>(R.id.rvCategory)

        var adapter = CategoryAdapter(this@CategoryActivity,list)
        var layoutManager = LinearLayoutManager(this, VERTICAL,false)
        rvCategory.layoutManager = layoutManager
        rvCategory.adapter =adapter

        btnAddCategor.setOnClickListener {
            var db  = DbHelper(this@CategoryActivity)
            if(edtCategory.text.isEmpty())
            {
                edtCategory.setError("Please Enter Category")
            }
            else
            {
                db.addCategory(edtCategory.text.toString())
                finish()
            }

        }
    }
}