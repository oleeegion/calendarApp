package com.example.calendar

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.DB.TaskDao
import com.example.DB.TaskDatabase
import com.example.DB.TaskEntity


class RecyclerAdapter(private val taskEntities: MutableList<TaskEntity>,
                      private val taskDao: TaskDao,
                      private val database: TaskDatabase,
                      private val mAct: AppCompatActivity
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // хранение и визуализация элементов списка
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val idTextView: TextView = itemView.findViewById(R.id.textViewId)
        private val deleteBtn: ImageButton = itemView.findViewById(R.id.delButton)


    @SuppressLint("NotifyDataSetChanged")
    fun deleteTask(index: Int){
        deleteBtn.setOnClickListener {
            val task: TaskEntity? = taskDao.getById(idTextView.text.toString().toInt())
            taskDao.deleteTask(task)
            taskEntities.removeAt(index)
            notifyDataSetChanged()
        }
    }

//        init {
//            itemView.setOnClickListener {
//                println(nameTextView.text)
//                println(idTextView.text)
//            }
//            deleteBtn.setOnClickListener {
//                val task: TaskEntity? = taskDao.getById(idTextView.text.toString().toInt())
//                taskDao.deleteTask(task)
//
//            }
//        }
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
        holder.deleteTask(position)
        holder.nameTextView.text = pos.name
        holder.idTextView.text = pos.id.toString()


    }

    override fun getItemCount(): Int {
        return taskEntities.size
    }



}