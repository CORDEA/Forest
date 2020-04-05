package jp.cordea.forest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.graphics.drawable.toBitmap
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.*
import androidx.ui.graphics.asImageAsset
import androidx.ui.layout.*
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
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.preferredWidth(46.dp) + Modifier.preferredHeight(46.dp)) {
                    Image(asset = app.icon.toBitmap().asImageAsset())
                }
                Text(text = app.name)
            }
        }
    }
}
