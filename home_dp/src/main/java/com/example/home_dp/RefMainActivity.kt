package com.example.home_dp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.home_dp.R.layout.activity_main_ref
import com.example.main_dp.SelectMainActivity
import com.example.show_recipes.MainActivityShow
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main_ref.*
import kotlin.system.exitProcess

class RefMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main_ref)

        val user = FirebaseAuth.getInstance().currentUser // 현재 로그인된 사용자 정보
        val username = user?.displayName // 사용자 이름
        val photoUrl = user?.photoUrl //사용자 프로필 사진
        UserName.text = username
        if (photoUrl != null){
            Glide.with(this).load(photoUrl).into(UserPhoto)
        }

        viewpager.adapter = FragmentPagerAdapter(this)
        TabLayoutMediator(tabs, viewpager){ tab, position ->
            when (position) { // 각 탭의 이름
                0 -> tab.text = "내 냉장고"
                1 -> tab.text = "북마크"
            }
        }.attach()

        plus.setOnClickListener {
            val intent = Intent(this, SelectMainActivity::class.java)
            startActivity(intent)
        }

        RecommandButton.setOnClickListener {
            val intent = Intent(this, MainActivityShow::class.java)
            startActivity(intent)
        }

        logout.setOnLongClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("로그아웃 하시겠습니까?")
                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                        // 구글 계정 로그아웃
                        val opt = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                        val client = GoogleSignIn.getClient(this, opt)
                        client.signOut()

                        Toast.makeText(this,  "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()

                        RefMainActivity().finish()
                        finish() // 첫 화면으로 돌아가기
                    })
                .setNegativeButton("취소",
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })
            // 다이얼로그를 띄워주기
            builder.show()

            return@setOnLongClickListener(true)
        }

    }

    /// 뒤로가기버튼으로 앱 종료 ///
    private var waitTime = 0L

    override fun onBackPressed() {
        if (System.currentTimeMillis() - waitTime >= 2000){
            waitTime = System.currentTimeMillis()
            Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        }
        else{
            // 앱 완전히 종료허가
            finishAffinity() //루트 액티비티를 종료
            System.runFinalization() // 현재 작업중인 쓰레드가 다 종료되면 종료시키기
            exitProcess(0) // 현재 액티비티를 종료
        }
    }

}