package leviata.ceos

import android.app.AlertDialog
import android.content.Context
import android.content.Intent

object MessageUtil {

    fun showMessage(context: Context?, message: String, groupTitle: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Grupos")
        builder.setMessage(String.format(message, groupTitle))
                .setPositiveButton("Convidar") { dialog, _ ->
                    val groupIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, String.format("Ei, que tal fazer parte, junto comigo, do grupo '%s' no aplicativo Ceos e aumentar seus conhecimentos? https://goo.gl/AhHHGE", groupTitle))
                        type = "text/plain"
                    }
                    context?.startActivity(groupIntent)
                    dialog.cancel()
                }

                .setNegativeButton("Cancelar") { dialog, _ ->
                    dialog.cancel()
                }

        builder.create().show()
    }

}