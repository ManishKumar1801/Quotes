package com.example.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotes.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyAdapter
    lateinit var list: List<Result>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        list=ArrayList()
        val retrofit= Retrofit.Builder().baseUrl("https://quotable.io/").addConverterFactory(
            GsonConverterFactory.create()).build()
        val getApi=retrofit.create(ApiInterface::class.java)
        val randomNumber=(1..100).random()
        getApi.getQuotes(randomNumber).enqueue(object : Callback<Data?> {
            override fun onResponse(call: Call<Data?>, response: Response<Data?>) {
                list= response.body()?.results !!
                adapter=MyAdapter(this@MainActivity,list)
                binding.recyclerView.adapter=adapter
                binding.recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<Data?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "SomeThing Went Wrong", Toast.LENGTH_SHORT).show()
            }
        })
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))
//        (list as ArrayList<Result>).add(Result("","APJ KALAM","","शिक्षण एक बहुत ही महान पेशा है जो किसी व्यक्ति के चरित्र, क्षमता, और भविष्य को आकार देता हैं। ...","","",0))


    }




















}