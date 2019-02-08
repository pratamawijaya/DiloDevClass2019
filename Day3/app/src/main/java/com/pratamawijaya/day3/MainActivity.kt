package com.pratamawijaya.day3

import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        SomeTask().execute()

        doAsync {
            val str = URL("https://api.myjson.com/bins/eufxk").readText()

            uiThread {
                Log.d("tag anko", "result $str")
            }
        }

    }

    class SomeTask : AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg param: Void?): String {
            return URL("https://api.myjson.com/bins/eufxk").readText()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.d("tag asynctask", "result $result")
        }
    }
}
