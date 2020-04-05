package jp.cordea.forest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    private val resolver by lazy { AppResolver(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                VerticalScroller(modifier = LayoutHeight.Fill + LayoutWidth.Fill) {
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
    Ripple(bounded = true) {
        Clickable(onClick = { app.launch() }) {
            Container(padding = EdgeInsets(16.dp)) {
                Column(modifier = LayoutWidth.Fill) {
                    Text(text = app.name)
                }
            }
        }
    }
}
