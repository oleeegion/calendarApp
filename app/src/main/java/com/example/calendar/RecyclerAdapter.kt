package com.example.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.DB.TaskEntity


class RecyclerAdapter(private val taskNameId: List<TaskEntity>,
                      private val selectedDate: String):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // хранение и визуализация элементов списка
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val idTextView: TextView = itemView.findViewById(R.id.textViewId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_maket, parent, false)
        return ViewHolder(itemView)
    }

    // привязать к объекту viewHolder данные для отображения
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = taskNameId[position]
        holder.nameTextView.text = pos.name
        holder.idTextView.text = pos.id.toString()


    }

    override fun getItemCount(): Int {
        return taskNameId.size
    }



}