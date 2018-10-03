package leviata.ceos

import android.app.AlertDialog
import android.content.Context
import android.view.Window


object MessageUtil {

    fun showMessage(context: Context?, message: String, groupTitle: String) {
        val builder = AlertDialog.Builder(context)
        //builder.setTitle(Window.FEATURE_NO_TITLE)
        builder.setMessage(String.format(message, groupTitle))
                .setPositiveButton("Ok") { _, _ -> }

                .setNegativeButton("Cancelar") { _, _ ->

                }

        builder.create().show()
    }
}