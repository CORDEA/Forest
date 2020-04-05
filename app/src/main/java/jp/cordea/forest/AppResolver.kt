package jp.cordea.forest

import android.content.Context
import android.content.Intent
import android.content.pm.ResolveInfo
import android.graphics.drawable.Drawable

class AppResolver(private val context: Context) {
    fun resolve(): List<App> =
        context.packageManager.queryIntentActivities(
            Intent(Intent.ACTION_MAIN, null).apply { addCategory(Intent.CATEGORY_LAUNCHER) },
            0
        ).map { App(context, it) }

    class App(
        private val context: Context,
        private val resolveInfo: ResolveInfo
    ) {
        val icon: Drawable = resolveInfo.loadIcon(context.packageManager)
        val name: String = resolveInfo.loadLabel(context.packageManager).toString()

        fun launch() {
            context.startActivity(
                context.packageManager.getLaunchIntentForPackage(resolveInfo.resolvePackageName)
            )
        }
    }
}
