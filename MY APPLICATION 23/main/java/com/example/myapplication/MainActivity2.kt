package com.example.myapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.BaseSliderView
import com.daimajia.slider.library.SliderTypes.TextSliderView


class MainActivity2 : AppCompatActivity()
{

    lateinit var slider:SliderLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        slider=findViewById(R.id.slider)

        val file_maps = HashMap<String, Int>()
        file_maps["Hannibal"] = R.drawable.c
        file_maps["Big Bang Theory"] = R.drawable.n
        file_maps["House of Cards"] = R.drawable.c
        file_maps["Game of Thrones"] = R.drawable.n




        for(name in file_maps.keys)
        {
            var txtslider=TextSliderView(this)
            txtslider.description(name)
                .description(name)
                .image(file_maps[name]!!)
                .setScaleType(BaseSliderView.ScaleType.Fit)
            slider.addSlider(txtslider)
        }




    }
}