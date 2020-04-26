package ru.sport.common.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 * Базовый наследник RecyclerView.ViewHolder релизующий LayoutContainer для использования kotlinx-bindings
 */
open class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
    LayoutContainer
