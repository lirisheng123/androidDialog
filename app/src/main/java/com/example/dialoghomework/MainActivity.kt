package com.example.dialoghomework

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), DataAdapter.RecyclerViewItemClickListener {
    //tinternl语法限制只能在这个类使用该字段，可见修饰符
    internal var customDialog: CustomListViewDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickHere(view: View) {
        val items = arrayOf(
            "Apple Apple Apple ",
            "Banana",
            "Orange",
            "Grapes",
            "Apple",
            "Banana",
            "Orange",
            "Grapes",
            "Apple",
            "Banana",
            "Orange",
            "Grapes",
            "Apple",
            "Banana",
            "Orange",
            "Grapes",
            "Apple",
            "Banana",
            "Orange",
            "Grapes"
        )
        val dataAdapter = DataAdapter(
            items,
            this
        )
        customDialog = CustomListViewDialog(this@MainActivity, dataAdapter)
        customDialog!!.show()
        customDialog!!.setCanceledOnTouchOutside(false)

}

    override fun clickOnItem(data: String) {
        //Synthetic property without calling findViewById() method and supports view caching to improve performance.
        button.text = data
        if (customDialog != null) {
            customDialog!!.dismiss()
        }
    }

}
