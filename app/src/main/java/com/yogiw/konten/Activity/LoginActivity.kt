package com.yogiw.konten.Activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yogiw.konten.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (mAuth.currentUser != null){
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        mAuth = FirebaseAuth.getInstance()
        btnLogin.setOnClickListener {
            mAuth.signInWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString())
                    .addOnCompleteListener(this, {
                        task ->
                        if (task.isSuccessful){
                            startActivity(Intent(applicationContext, MainActivity::class.java))
                        } else {
                            Toast.makeText(this@LoginActivity, "Login failed- " + task.exception?.message, Toast.LENGTH_SHORT).show()
                        }
                    })
        }
        btnSignUp.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }

    }

}
