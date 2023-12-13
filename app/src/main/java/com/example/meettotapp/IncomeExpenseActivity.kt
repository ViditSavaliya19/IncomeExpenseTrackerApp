package com.example.meettotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.example.meettotapp.helper.DbHelper
import com.example.meettotapp.model.CategoryModel
import com.example.meettotapp.model.IncomeExpenseModel

class IncomeExpenseActivity : AppCompatActivity() {
    lateinit var db: DbHelper
    lateinit var btnExpense: Button
    lateinit var btnIncome: Button
    lateinit var edtTitle: EditText
    lateinit var edtAmount: EditText
    lateinit var edtDate: EditText
    lateinit var edtNotes: EditText
    lateinit var edtTime: EditText
    lateinit var spinner: Spinner
    var categoryList = arrayListOf<CategoryModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_expense)
        db = DbHelper(this)
        categoryList = db.getCategory()
        initBinding()
    }

    private fun initBinding() {

        spinner = findViewById<Spinner>(R.id.spinner)
        edtTitle = findViewById<EditText>(R.id.edtTitle)
        edtAmount = findViewById<EditText>(R.id.edtAmount)
        edtNotes = findViewById<EditText>(R.id.edtNotes)
        edtDate = findViewById<EditText>(R.id.edtDate)
        edtTime = findViewById<EditText>(R.id.edtTime)
        btnIncome = findViewById<Button>(R.id.btnIncome)
        btnExpense = findViewById<Button>(R.id.btnExpense)

        //Spinner Category
        var nameList = arrayListOf<String>()
        categoryList.forEach {
            nameList.add(it.name)
        }
        var arrayAdapter = ArrayAdapter(
            this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, nameList
        )
        spinner.adapter = arrayAdapter

        // Button Click

        btnIncome.setOnClickListener {
            var index = spinner.selectedItemPosition

            var model = IncomeExpenseModel(
                edtTitle.text.toString(),
                edtAmount.text.toString(),
                edtNotes.text.toString(),
                edtDate.text.toString(),
                edtTime.text.toString(),
                0,
                nameList[index]
            )

            db.addIncomeExpense(model)
        }

        btnExpense.setOnClickListener {
            var index = spinner.selectedItemPosition

            var model = IncomeExpenseModel(
                edtTitle.text.toString(),
                edtAmount.text.toString(),
                edtNotes.text.toString(),
                edtDate.text.toString(),
                edtTime.text.toString(),
                1,
                nameList[index]
            )

            db.addIncomeExpense(model)
        }

    }
}