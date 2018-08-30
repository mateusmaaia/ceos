package leviata.ceos

import android.databinding.BindingAdapter
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.GradientDrawable
import android.widget.EditText
import android.widget.ImageView

@BindingAdapter("setUnderlineColor")
fun setUnderlineColor(view: EditText, color: String?) {
    if (color == null) return
    view.background.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP)
}

@BindingAdapter(value = ["backgroundColorScrim", "backgroundGradientScrim"], requireAll = false)
fun setCollapsingScrimColor(layout: ImageView, color: String?, colorGradient: String?) {
    if (color == null || color.isEmpty() || colorGradient == null || colorGradient.isEmpty()) return

    val colors = intArrayOf(Color.parseColor(color), Color.parseColor(colorGradient))
    val gd = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM, colors)

    gd.cornerRadius = 0f
    layout.background = gd

    //layout.setContentScrimColor(LookHelper.convertRgbaToArgb(color))
}