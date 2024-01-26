package kr.ac.kumoh.ce.prof01.jet16intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import kr.ac.kumoh.ce.prof01.jet16intent.ui.theme.Jet16IntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jet16IntentTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ButtonHomepage()
            ButtonYoutube()
            ButtonCoordinates()
            ButtonMap()
            ButtonCall()
            ButtonSms()
            ButtonExplicitIntent()
        }
    }
}

@Composable
fun ButtonHomepage() {
    val context = LocalContext.current
    Button(
        onClick = {
            val uri = Uri.parse("https://github.com/devbwoh")
            //val uri = Uri.parse("https://www.instagram.com/jennierubyjane/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
//            if (intent.resolveActivity(context.packageManager) == null) {
//                // NOTE: 앱이 없을 때 처리
//                return@Button
//            }
            startActivity(context, intent, null)
        }
    ) {
        Text("홈페이지", fontSize = 20.sp)
    }
}

@Composable
fun ButtonYoutube() {
    val context = LocalContext.current
    Button(
        onClick = {
            val uri = Uri.parse("https://www.youtube.com/playlist?list=PLWz5rJ2EKKc94tpHND8pW8Qt8ZfT1a4cq")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(context, intent, null)
        }
    ) {
        Text("유튜브", fontSize = 20.sp)
    }
}

@Composable
fun ButtonCoordinates() {
    val context = LocalContext.current
    Button(
        onClick = {
            val uri = Uri.parse("geo:36.145014,128.393047?z=17")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(context, intent, null)
        }
    ) {
        Text("경위도 좌표", fontSize = 20.sp)
    }
}

@Composable
fun ButtonMap() {
    val context = LocalContext.current
    Button(
        onClick = {
            //val uri = Uri.parse("geo:0,0?q=국립금오공과대학교")
            val uri = Uri.parse("geo:0,0?q=경북 구미시 대학로 61")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(context, intent, null)
        }
    ) {
        Text("지도", fontSize = 20.sp)
    }
}

@Composable
fun ButtonCall() {
    val context = LocalContext.current
    Button(
        onClick = {
            val uri = Uri.parse("tel:010-1234-5678")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(context, intent, null)
        }
    ) {
        Text("전화 걸기", fontSize = 20.sp)
    }
}

@Composable
fun ButtonSms() {
    val context = LocalContext.current
    Button(
        onClick = {
//            val uri = Uri.parse("sms:010-1234-5678")
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            intent.putExtra("sms_body", "반갑습니다.")
            val intent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("sms:010-1234-5678")
                putExtra("sms_body", "만나서 반갑습니다.")
            }
            startActivity(context, intent, null)
        }
    ) {
        Text("문자 보내기", fontSize = 20.sp)
    }
}

@Composable
fun ButtonExplicitIntent() {
    val context = LocalContext.current

    Button(
        onClick = {
            val intent = Intent(context, AnotherActivity::class.java)
            startActivity(context, intent, null)
        }
    ) {
        Text("Activity 실행", fontSize = 20.sp)
    }
}