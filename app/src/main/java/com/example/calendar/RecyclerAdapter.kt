package com.example.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.DB.TaskEntity


class RecyclerAdapter(private val taskEntities: List<TaskEntity>):
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // хранение и визуализация элементов списка
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
//        val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        private val deleteBtn: ImageButton = itemView.findViewById(R.id.delButton)
        init {
            itemView.setOnClickListener {
                println(nameTextView)
//                println(idTextView)
            }
            deleteBtn.setOnClickListener {

                println("BUTTON HAS BEEN PRESSED")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_maket, parent, false)
        return ViewHolder(itemView)
    }

    // привязать к объекту viewHolder данные для отображения
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = taskEntities[position]
        holder.nameTextView.text = pos.name
//        holder.idTextView.text = pos.id.toString()


    }

    override fun getItemCount(): Int {
        return taskEntities.size
    }



}