package leviata.ceos.util

import android.support.annotation.AnimRes
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

fun View.startAnimation(@AnimRes animRes: Int) {
    this.startAnimation(animRes, null)
}

fun View.startAnimation(@AnimRes animRes: Int, onAnimationEnd: (() -> Unit)?) {
    val animation = AnimationUtils.loadAnimation(context, animRes)
    if(onAnimationEnd != null) {
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                onAnimationEnd()
            }

            override fun onAnimationStart(p0: Animation?) {}
        })
    }
    this.startAnimation(animation)
}

fun View.startAnimation(isVisible: Boolean, @AnimRes startAnimRes: Int, @AnimRes endAnimRes: Int) {
    if(isVisible) {
        if(this.visibility != View.VISIBLE) {
            this.visibility = View.VISIBLE
            this.startAnimation(startAnimRes, null)
        }
    }
    else if(this.visibility != View.INVISIBLE) {
        this.startAnimation(endAnimRes) {
            this.visibility = View.INVISIBLE
        }
    }
}
