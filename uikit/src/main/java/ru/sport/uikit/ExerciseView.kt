package ru.sport.uikit

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.exercise_view_row.view.*
import ru.sport.common.adapter.DelegateAdapter

class ExerciseView
    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    var title: CharSequence?
        get() = titleView.text
        set(value) {
            titleView.text = value
        }

    var description: CharSequence?
        get() = descriptionView.text
        set(value) {
            descriptionView.text = value
        }

    init {
        View.inflate(context, R.layout.exercise_view_row, this)
    }

    fun setBackgroundRes(@DrawableRes iconRes: Int) {
        cardBackground.setBackgroundResource(iconRes)
    }

    class ViewModel(@StringRes val title: Int,
                    @StringRes val description: Int,
                    @DrawableRes val iconRes: Int)

    class Delegate: DelegateAdapter.Delegate<ViewModel, ViewHolder>() {
        override fun createViewHolder(parent: ViewGroup): ViewHolder {
            val view = ExerciseView(parent.context).apply {
                layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
            return ViewHolder(view)
        }

        override fun bind(viewHolder: ViewHolder, model: ViewModel) {
            viewHolder.bind(model)
        }

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(model: ViewModel) {
            val view = itemView as ExerciseView
            view.title = getString(model.title)
            view.description = getString(model.description)
            view.setBackgroundRes(model.iconRes)
        }

        private fun getString(@StringRes textRes: Int) = itemView.context.getString(textRes)
    }
}
