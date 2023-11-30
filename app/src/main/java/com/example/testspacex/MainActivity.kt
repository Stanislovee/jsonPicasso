package com.example.testspacex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException


class MainActivity : AppCompatActivity() {

    private lateinit var xRecyclerView: RecyclerView
    private lateinit var xSpaceAdapter: SpaceAdapter
    private lateinit var xSpaceList: ArrayList<Model>
    private lateinit var xRequestQueue: RequestQueue




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        xRecyclerView = findViewById(R.id.recyclerView)
        xRecyclerView.setHasFixedSize(true)
        xRecyclerView.layoutManager = LinearLayoutManager(this)
        xRequestQueue = Volley.newRequestQueue(this)
        parseJSON()
    }

    private  fun parseJSON(){
        val url = "https://api.spacexdata.com/v3/ships"
                val request = JsonObjectRequest(Request.Method.GET, url, null,
                    { response ->
                        try {
                            val jsonObject = response.getJSONObject(" ")
                            for (i in 0 until jsonObject.length()) {
                                val date = jsonObject.getJSONObject(" ")
                                val shipImage = date.getString("image")
                                val shipId = date.getString("ship_id")
                                val shipName = date.getString("ship_name")
                                val shipYear = date.getInt("year_built")
                                xSpaceList.add(Model(shipImage, shipId, shipName, shipYear))
                            }
                            xSpaceAdapter = SpaceAdapter(this@MainActivity, xSpaceList)
                            xRecyclerView.adapter = xSpaceAdapter
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    },
                    { error -> error.printStackTrace() })

                xRequestQueue.add(request)
            }
        }