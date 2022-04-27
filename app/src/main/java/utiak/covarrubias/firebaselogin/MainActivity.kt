package utiak.covarrubias.firebaselogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import utiak.covarrubias.firebaselogin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.btnSignOut.setOnClickListener {
            signOut()
        }
    }

    private fun signOut(){
        Firebase.auth.signOut()
        Toast.makeText(this, "Se cerró sesión de manera exitosa.",
            Toast.LENGTH_LONG).show()
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }
}