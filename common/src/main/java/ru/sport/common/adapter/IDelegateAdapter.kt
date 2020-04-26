package ru.sport.common.adapter

interface IDelegateAdapter {
    fun getItem(position: Int): Any?
    var items: List<Any?>
    fun getItemPosition(item: Any?): Int
    fun addItem(item: Any)
    fun clearItems()
    fun indexOf(item: Any?): Int
    fun removeItem(item: Any)
    fun removeItemByPosition(pos: Int)
    fun addItem(pos: Int, item: Any?)
    fun removeItems(items: List<*>?)
    fun changeItem(item: Any)
    fun changeItemByPosition(pos: Int, item: Any)
    fun addItems(items: List<*>)
    fun addItems(pos: Int, items: List<*>)
}
