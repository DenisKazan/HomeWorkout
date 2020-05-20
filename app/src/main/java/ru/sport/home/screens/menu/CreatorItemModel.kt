package ru.sport.home.screens.menu

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import ru.sport.common.adapter.DelegateAdapter
import ru.sport.home.R
import ru.sport.uikit.ExerciseView

class CreatorItemModel(
    val action: () -> Unit
)

class CreatorItemDelegate: DelegateAdapter.Delegate<CreatorItemModel, CreatorItemViewHolder>() {
    override fun createViewHolder(parent: ViewGroup): CreatorItemViewHolder {
        val view = ExerciseView(parent.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        return CreatorItemViewHolder(view)
    }

    override fun bind(viewHolder: CreatorItemViewHolder, model: CreatorItemModel) {
        viewHolder.bind(model)
    }

}

class CreatorItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bind(model: CreatorItemModel) {
        with(itemView as ExerciseView) {
            title = getString(R.string.new_excersice)
            setBackgroundRes(R.drawable.ic_launcher_background)
            setOnClickListener { model.action.invoke() }
        }
    }

    private fun getString(@StringRes stringRes: Int) = itemView.context.getString(stringRes)

}
