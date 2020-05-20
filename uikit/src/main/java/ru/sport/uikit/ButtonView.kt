package ru.sport.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.button_row.view.*


class ButtonView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    var title: CharSequence?
        get() = text_btn.text
        set(value) {
            text_btn.text = value
        }

    init {
        View.inflate(context, R.layout.button_row, this)
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.ProgressButton,
                0, 0
            )
            title = a.getString(R.styleable.ProgressButton_text)
            if (a.hasValue(R.styleable.ProgressButton_android_textColor)) {
                text_btn.setTextColor(a.getColorStateList(R.styleable.ProgressButton_android_textColor))
            } else {
                text_btn.setTextColor(
                    AppCompatResources.getColorStateList(
                        context,
                        R.color.kit_button_text_color
                    )
                )
            }
            if (a.getDrawable(R.styleable.ProgressButton_background) != null) {
                text_btn.background = a.getDrawable(R.styleable.ProgressButton_background)
            }
            val isEnabled =
                a.getBoolean(R.styleable.ProgressButton_android_enabled, true)
            setEnabled(isEnabled)
            a.recycle()
        }
    }

}
