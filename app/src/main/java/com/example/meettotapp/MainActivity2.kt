package com.example.meettotapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.meettotapp.adapter.DataAdapter
import com.example.meettotapp.helper.DbHelper
import com.example.meettotapp.model.IncomeExpenseModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity2 : AppCompatActivity() {
    lateinit var rvData: RecyclerView
    lateinit var dataList: ArrayList<IncomeExpenseModel>
    lateinit var db: DbHelper
    lateinit var btnAdd: FloatingActionButton
    lateinit var imgAddCategory: ImageView

    override fun onResume() {
        super.onResume()
        dataList = DbHelper(this).getIncomeExpense()
        revSetUP()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //GetData
        db =DbHelper(this)
        dataList = db.getIncomeExpense()

        initBinding();
    }

    private fun initBinding() {
        btnAdd = findViewById<FloatingActionButton>(R.id.btnAdd)
        imgAddCategory = findViewById<ImageView>(R.id.imgAddCategory)
        rvData = findViewById<RecyclerView>(R.id.rvData)

        revSetUP()


        imgAddCategory.setOnClickListener {
            var intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)

        }

        btnAdd.setOnClickListener {
            var intent = Intent(this, IncomeExpenseActivity::class.java)
            startActivity(intent)
        }
    }

    private fun revSetUP() {
        var adapter = DataAdapter(this, dataList)
        var lm = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvData.layoutManager = lm
        rvData.adapter = adapter
    }
}

/*
* Android Storage
* 1. Variable
* 2. ShapredPrefrense
* 3. Database
*
* 1. Sqlite -> Sql -> Structure Query Language
* CRUD -> CREATE READ UPDATE DELETE
*
*     2  Types
*  - SQL -> Table  -> Row ->
*  - NO SQL -> Branch ->
*
* (Income / Expense)
* - Title
* - Amount
* - Desc
* - Date
* - Time
* - status (income/expense)
* - category
*
*
* (Category)
* - Name
* */