package leviata.ceos

import android.databinding.BindingAdapter
import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.EditText

@BindingAdapter("setUnderlineColor")
fun setUnderlineColor(view: EditText, color: String?) {
    if (color == null) return
    view.background.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP)
}