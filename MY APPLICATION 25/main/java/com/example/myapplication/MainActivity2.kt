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
        file_maps["cosmetic"] = R.drawable.cosmetic
        file_maps["clothes"] = R.drawable.clothes
        file_maps["eletronic"] = R.drawable.eletronic
        file_maps["cosmetic"] = R.drawable.cosmetic
        file_maps["clothes"] = R.drawable.clothes
        file_maps["eletronic"] = R.drawable.eletronic
        file_maps["cosmetic"] = R.drawable.cosmetic
        file_maps["clothes"] = R.drawable.clothes
        file_maps["eletronic"] = R.drawable.eletronic





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