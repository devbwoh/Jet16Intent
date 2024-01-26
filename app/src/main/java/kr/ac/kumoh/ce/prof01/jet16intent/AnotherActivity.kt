package kr.ac.kumoh.ce.prof01.jet16intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.ce.prof01.jet16intent.databinding.ActivityAnotherBinding

class AnotherActivity : AppCompatActivity() {
    private lateinit var main: ActivityAnotherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_another)
        main = ActivityAnotherBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnChange.setOnClickListener {
            main.txtHello.text = "반갑습니다"
        }
    }
}