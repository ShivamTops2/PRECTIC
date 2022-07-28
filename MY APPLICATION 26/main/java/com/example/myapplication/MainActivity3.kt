package com.example.xyz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import java.util.*

class MainActivity3 : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var edt1:EditText
    lateinit var btn:Button
    lateinit var tts:TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        edt1=findViewById(R.id.edt1)
        btn=findViewById(R.id.btn1)
        tts= TextToSpeech(applicationContext,this)
        btn.setOnClickListener()
        {

            var data=edt1.text.toString()

            tts.speak(data,TextToSpeech.QUEUE_ADD,null)




        }
    }

    override fun onInit(p0: Int)
    {
        tts.setLanguage(Locale.ENGLISH)
        tts.setPitch(0.7F)
        tts.setSpeechRate(0.7F)


    }
}