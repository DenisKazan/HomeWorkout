package ru.sport.common.adapter

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

/**
 * Базовый RecyclerView.ViewHolder, реализующий LifecycleOwner для использования LiveData во ViewHolder
 */
open class ViewHolderLifecycleOwner(override val containerView: View) : ViewHolder(containerView),
    LifecycleOwner {

    @Suppress("LeakingThis")
    private val lifecycleRegistry = LifecycleRegistry(this)

    init {
        lifecycleRegistry.markState(Lifecycle.State.INITIALIZED)
    }

    fun markAttach() {
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    fun markDetach() {
        lifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }
}
