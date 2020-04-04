package jp.cordea.forest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.Ripple
import androidx.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                VerticalScroller(modifier = LayoutHeight.Fill + LayoutWidth.Fill) {
                    Column {
                        (0..20).forEach { Item(it.toString()) }
                    }
                }
            }
        }
    }
}

@Composable
fun Item(text: String) {
    Ripple(bounded = true) {
        Clickable(onClick = {}) {
            Container(padding = EdgeInsets(16.dp)) {
                Column(modifier = LayoutAlign.CenterLeft) {
                    Text(text = text)
                    Text(text = text)
                }
            }
        }
    }
}
