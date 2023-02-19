@file:Suppress("DEPRECATION")

package com.example.login_dp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.home_dp.RefMainActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    private var auth : FirebaseAuth? = null
    private var googleSignInClient : GoogleSignInClient? = null
    private var GOOGLE_LOGIN_CODE = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        google_sign_in_button.setOnClickListener {
            //First step
            googleLogin()
        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    override fun onStart() { //전에 로그인한 기록이 있으면 바로 내 냉장고 화면으로 넘어감(자동로그인)
        super.onStart()
        val account = GoogleSignIn.getLastSignedInAccount(this)
        if (account !== null){
            moveMainPage(FirebaseAuth.getInstance().currentUser)
        }
    }

    private fun googleLogin() {
        val signInIntent = googleSignInClient?.signInIntent
        startActivityForResult(signInIntent, GOOGLE_LOGIN_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == GOOGLE_LOGIN_CODE) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!)
            // result가 성공했을 때 이 값을 firebase에 넘겨주기
            if(result!!.isSuccess) {
                val account = result.signInAccount
                // Second step
                firebaseAuthWithGoogle(account)
            }
        }
    }

    private fun firebaseAuthWithGoogle(account : GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken,null)
        auth?.signInWithCredential(credential)
            ?.addOnCompleteListener {
                    task ->
                if(task.isSuccessful) {
                    // Login, 아이디와 패스워드가 맞았을 때
                    moveMainPage(task.result?.user)
                } else {
                    // Show the error message, 아이디와 패스워드가 틀렸을 때
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                }
            }
    }

    // 로그인이 성공하면 다음 페이지로 넘어가는 함수
    private fun moveMainPage(user: FirebaseUser?) {
        // 파이어베이스 유저 상태가 있을 경우 다음 페이지로 넘어갈 수 있음
        if(user != null) {
            Toast.makeText(this,  "로그인 성공", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, RefMainActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this,  "로그인 실패", Toast.LENGTH_LONG).show()
        }
    }


    /// 뒤로가기 버튼으로 앱 종료 ///
    private var waitTime = 0L

    override fun onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 2000){
            waitTime = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        else{
            finishAffinity() //루트 액티비티를 종료
            System.runFinalization() // 현재 작업중인 쓰레드가 다 종료되면 종료시키기
            exitProcess(0) // 현재 액티비티를 종료
        }
    }
}