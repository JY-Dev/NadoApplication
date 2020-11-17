package com.jydev.nadoapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jydev.nadoapplication.R
import com.jydev.nadoapplication.util.OnClickUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        OnClickUtil.setOnClick(alliance,this)
        login_btn.setOnClickListener {
            if(id_et.text.isNotEmpty()&&pw_et.text.isNotEmpty())
                startActivity(Intent(this,GuideActivity::class.java))
            else
                Toast.makeText(this,"아이디와 비밀번호를 입력해주세요.",Toast.LENGTH_SHORT).show()
        }
    }
}