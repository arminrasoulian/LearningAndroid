package com.rasoulian.learndiwithcoin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.LocalDate
import com.rasoulian.learndiwithcoin.NasaMediaItem.NasaMediaType

class MainActivity : AppCompatActivity() {
    private lateinit var downloadButton : MaterialButton
    private lateinit var nasaApiService : NasaApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        nasaApiService = retrofit.create(NasaApiService::class.java)

        downloadButton = findViewById(R.id.fetch_data_button)
        downloadButton.setOnClickListener {
            var images = nasaApiService.listRepos(LocalDate.parse("2021-10-10")).enqueue(object :
                Callback<List<NasaMediaItem>> {
                override fun onResponse(
                    call: Call<List<NasaMediaItem>>,
                    response: Response<List<NasaMediaItem>>
                ) {
                    val firstImage = response.body()?.first { it.mediaType == NasaMediaType.Image }
                }

                override fun onFailure(call: Call<List<NasaMediaItem>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                }

            })
            val firstImage = images
        }
    }

    override fun onCreateView(
        parent: View?,
        name: String,
        context: Context,
        attrs: AttributeSet
    ): View? {
        return super.onCreateView(parent, name, context, attrs)
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }
}