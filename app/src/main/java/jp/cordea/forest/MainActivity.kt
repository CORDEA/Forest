package jp.cordea.forest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.ripple
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.font.asFontFamily
import androidx.ui.text.font.font
import androidx.ui.unit.dp
import androidx.ui.unit.sp

class MainActivity : AppCompatActivity() {
    private val resolver by lazy { AppResolver(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                VerticalScroller(modifier = Modifier.fillMaxSize()) {
                    Column {
                        resolver.resolve().forEach { Item(it) }
                    }
                }
            }
        }
    }
}

@Composable
fun Item(app: AppResolver.App) {
    Clickable(onClick = { app.launch() }, modifier = Modifier.ripple()) {
        Box(padding = 16.dp) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.preferredWidth(46.dp) + Modifier.preferredHeight(46.dp)) {
                    Image(asset = app.icon.toBitmap().asImageAsset())
                }
                Spacer(modifier = Modifier.preferredWidth(8.dp))
                Text(
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = font(R.font.raleway_light).asFontFamily(),
                        fontWeight = FontWeight.Bold
                    ),
                    text = app.name,
                    modifier = Modifier.gravity(RowAlign.Center)
                )
            }
        }
    }
}
