package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast

class RatingandSeek : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ratingand_seek)

        rating .setOnRatingBarChangeListener()
        {
                ratingBar: RatingBar, fl: Float, b: Boolean ->

            Toast.makeText(applicationContext,""+ratingBar.rating,Toast.LENGTH_LONG).show()
        }

        seek1.setOnSeekBarChangeListener(applicationContext)
        seek2.setOnSeekBarChangeListener(applicationContext)
        seek3.setOnSeekBarChangeListener(applicationContext)

    }

}
}