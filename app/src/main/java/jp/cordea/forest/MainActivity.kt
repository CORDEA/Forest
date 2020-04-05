package jp.cordea.forest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.LayoutHeight
import androidx.ui.layout.LayoutWidth
import androidx.ui.layout.fillMaxWidth
import androidx.ui.material.MaterialTheme
import androidx.ui.material.ripple.ripple
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
    Clickable(onClick = { app.launch() }, modifier = Modifier.ripple()) {
        Box(padding = 16.dp) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = app.name)
            }
        }
    }
}
