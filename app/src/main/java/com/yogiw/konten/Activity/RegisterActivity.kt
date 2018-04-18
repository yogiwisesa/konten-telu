package com.yogiw.konten.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yogiw.konten.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnSignUp.setOnClickListener {
            mAuth.createUserWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString())
                    .addOnCompleteListener(this, {
                        task ->
                        if (task.isSuccessful){
                            Toast.makeText(this@RegisterActivity, "Create account successfull", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@RegisterActivity, "Create account failed - " + task.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    })
        }
    }

}
