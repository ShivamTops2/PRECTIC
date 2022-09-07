package com.example.project2.project2

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.R.attr.password
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.project2.*
import com.example.project2.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean(
                "user_session",
                false
            ) && !sharedPreferences.getString("mob", "")!!.isEmpty()
        ) {
            startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
            finish()
        }


        binding.btnNewUser.setOnClickListener()
        {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        binding.btnLogin.setOnClickListener()
        {
            var mobile = binding.edtMobile.text.toString()
            var password = binding.edtPass.text.toString()


            var apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

            var call: Call<RegisterModel> = apiinterface.logindata(mobile, password)
            call.enqueue(object : Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>
                ) {
                    sharedPreferences.edit().putString("mob", mobile).commit()

                    sharedPreferences.edit().putBoolean("user_session", true).commit();


                    Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show()

                    startActivity(Intent(applicationContext, DashboardActivity::class.java))
                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable) {
                    Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
                }
            })

        }
    }
}
/*val call: Call<RegisterModel> = apiinterface.logindata(mobile, pass)
            call.enqueue(object :Callback<RegisterModel>{
                override fun onResponse(call: Call<RegisterModel>, response: Response<RegisterModel>, )
                {
                        Toast.makeText(applicationContext,"Success",Toast.LENGTH_LONG).show()
                }
                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail",Toast.LENGTH_LONG).show()
                }
            })*//*





        }



    }

}

*/
/* call.enqueue(object : Callback<String?> {
     override fun onResponse(call: Call<String?>, response: Response<String?>) {
         Log.i("Responsestring", response.body().toString())
         //Toast.makeText()
         if (response.isSuccessful) {
             if (response.body() != null) {
                 Log.i("onSuccess", response.body().toString())
                 val jsonresponse = response.body().toString()
                 parseLoginData(jsonresponse)
             } else {
                 Log.i("onEmptyResponse",
                     "Returned empty response") //Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
             }
         }
     }
     override fun onFailure(call: Call<String?>, t: Throwable) {}
 })

/*
import android.app.DownloadManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import android.content.SharedPreferences
import com.android.volley.Request.Method.POST
import com.example.project2.Apiinterface
import com.example.project2.DashboardActivity
import com.example.project2.R
import com.example.project2.SignupActivity
import com.example.project2.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        sharedPreferences=getSharedPreferences("user_session", MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) && !sharedPreferences.getString("m1", "")!!.isEmpty())
        {
            val i = Intent(this, DashboardActivity::class.java)
            startActivity(i)
            finish()
        }


       binding. btnNewUser.setOnClickListener()
        {
            startActivity(Intent(this, SignupActivity::class.java))
        }
       binding. btnLogin.setOnClickListener()
        {
            var mobile = binding.edtMobile.text.toString()
            var password = binding.edtPass.text.toString()

            val stringRequest = StringRequest(
                //DownloadManager.Request.Method.POST,
                "https://topste.000webhostapp.com/API/TEST%202/login.php=$mobile&pass=$password",
                { response ->
                    if (response.trim { it <= ' ' } == "0")
                    {
                        Toast.makeText(this@LoginActivity, "Login Fail", Toast.LENGTH_SHORT).show()
                    }

                    else
                    {
                        Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()

                        var editor:SharedPreferences.Editor=sharedPreferences.edit()
                        editor.putString("m1",mobile)
                        editor.putString("p1",password)
                        sharedPreferences.edit().putBoolean("user_session",true).commit();
                        editor.apply()
                        editor.commit()

                        var intent= Intent(applicationContext, DashboardActivity::class.java)
                        startActivity(intent)
                    }
                }) { Toast.makeText(this@LoginActivity, "No Internet", Toast.LENGTH_SHORT).show() }

            val queue = Volley.newRequestQueue(this@LoginActivity)
            queue.add(stringRequest)
        }


    }

    override fun onBackPressed()
    {
        finishAffinity()
    }
}*/
});

 */
