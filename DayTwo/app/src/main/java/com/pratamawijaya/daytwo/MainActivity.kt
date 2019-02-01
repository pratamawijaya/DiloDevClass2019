package com.pratamawijaya.daytwo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pratamawijaya.daytwo.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_rv.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)


        val listItems = listOf(
                "Text 1",
                "Text 2",
                "Text 3",
                "Text 4"
        )

        // declare layout manager
        val linearLayoutManager = LinearLayoutManager(this)
        val myAdapter = MyAdapter(listItems)

        rvSatu.apply {
            layoutManager = linearLayoutManager
            adapter = myAdapter
        }


//        var counter = 0
//
//        btnToast.setOnClickListener { showToastMessage(counter) }
//
//        btnCount.setOnClickListener {
//            counter++
//            updateTxtCounter(counter)
//        }
//
//        btnReset.setOnClickListener {
//            counter = 0
//            updateTxtCounter(counter)
//        }
    }

    /**
     * update value ke textview
     */
    private fun updateTxtCounter(counter: Int) {
//        tvCount.text = "$counter"
    }

    /**
     * tampilkan value counter ke toast
     *
     * @param counter
     */
    private fun showToastMessage(counter: Int) {
//        Toast.makeText(this, "Nilainya adalah $counter", Toast.LENGTH_SHORT).show()
    }
}
