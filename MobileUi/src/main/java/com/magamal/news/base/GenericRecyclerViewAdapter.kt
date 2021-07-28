package com.magamal.news.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Mahmoud Gamal on 2/19/21.
 */
abstract class GenericRecyclerViewAdapter<T> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected var items = ArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutInflater.from(parent.context)
            .inflate(getLayoutId(), parent, false)
            .run View@{
                return ViewHolder(this)
            }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindData(holder, position, items[position])
    }

    fun setItems(items: List<T>) {
        this.items = ArrayList(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    abstract fun bindData(holder: RecyclerView.ViewHolder, position: Int, t: T)

    abstract fun getLayoutId(): Int
}