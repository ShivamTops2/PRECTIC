package com.example.project2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.project2.databinding.ActivitySignupBinding
import com.example.project2.project2.LoginActivity
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import java.util.concurrent.TimeUnit

class SignupActivity : AppCompatActivity() {

    private lateinit var varificationId: String
    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface: Apiinterface

    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
   // var passPattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnAlreadyAccount.setOnClickListener()
        {
            startActivity(Intent(this, LoginActivity::class.java))

        }
      /*  binding.btnGET.setOnClickListener()
        {
            if (TextUtils.isEmpty(binding.btnGET.text.toString())) {
                Toast.makeText(this, "Enter Valid number", Toast.LENGTH_SHORT).show()
            } else {
                val number = binding.btnGET.text.toString()
                sendvrifycode(number)
            }
        }*/
       /* binding.edtOTP.setOnClickListener(View.OnClickListener {
            verifycode(binding.edtOTP.getText().toString())
        })
    }

    private fun sendvrifycode(number: String) {
        PhoneAuthProvider.getInstance()
            .verifyPhoneNumber(number, 60, TimeUnit.SECONDS, this, mCallVBack)


*/


        binding.btnRegister.setOnClickListener()
        {
            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var mobile = binding.edtPhone.text.toString()
            var email = binding.edtEmail.text.toString()
            var pass = binding.edtPassword.text.toString()
            var cpass = binding.edtConfirmPassword.text.toString()

            clearfocus()

            try {
                if (fname.equals(""))
                {
                    clearfocus()
                    binding.layoutFirstName.setError("Please Enter FirstName.!")
                }
                else if (lname.equals(""))
                {
                    clearfocus()

                    binding.layoutLastName.setError("Please Enter LastName.!")
                }
                else if (email.matches(emailPattern.toRegex()) == false)
                {

                    binding.edtEmail.setError("Invalid Email.!");
                }
                else if (mobile.equals("")) {

                    binding.edtPhone.setError("Please Enter Mobile Number.!");
                }

                else if (pass.matches(pass.toRegex()) == false)
                {

                    binding.edtPassword.setError("Please Enter Password.!");
                }
                else if (cpass.equals(""))
                {

                    binding.edtConfirmPassword.setError("Please Enter Confirm Password.!");
                }
                else if (!pass.equals(cpass))
                {
                    Snackbar.make(it,
                        "Password and cofirm password are not same",
                        Snackbar.LENGTH_LONG).show()
                }
                else
                {

                    apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
                    var registercall: Call<Void> =
                        apiinterface.insertdata(fname, lname, mobile, email,
                            pass)

                    registercall.enqueue(object : Callback<Void?> {
                        override fun onResponse(
                            call: Call<Void?>,
                            response: Response<Void?>,
                        ) {


                        }

                        override fun onFailure(call: Call<Void?>, t: Throwable) {


                            //Toast.makeText(applicationContext, "" + t, Toast.LENGTH_LONG).show()
                            Log.d("XyzError",t.message.toString())
                        }
                    })
                    startActivity(Intent(this, LoginActivity::class.java))


                }


            } catch (e: Exception) {
                Toast.makeText(applicationContext, "" + e, Toast.LENGTH_LONG).show()
            }


        }


    }

    private fun sendvrifycode(number: String) {

    }
    /*var mCallVBack: PhoneAuthProvider.OnVerificationStateChangedCallbacks =
        object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(s: String, forceResendingToken: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                varificationId = s
            }
*/
           /* override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                val code = phoneAuthCredential.smsCode
                code?.let { verifycode(it) }
            }

            override fun onVerificationFailed(e: FirebaseException) {}
        }
*/
  /*  private fun verifycode(code: String) {
        val credential = PhoneAuthProvider.getCredential(varificationId!!, code)
        SingInWhithCredentinal(credential)
    }
*/
   /* private fun SingInWhithCredentinal(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, task.exception!!.message, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }*/






override fun onPause()
    {
        binding.edtFirstName.error=null
        super.onPause()



    }

    fun clearfocus()
    {
        binding.edtFirstName.clearFocus()
        binding.layoutFirstName.clearFocus()
        binding.edtFirstName.setError(null)
        binding.layoutFirstName.setError(null)



    }


}