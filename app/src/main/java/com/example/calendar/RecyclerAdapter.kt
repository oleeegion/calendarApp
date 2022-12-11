package com.example.calendar

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.DB.TaskDao
import com.example.DB.TaskDatabase
import com.example.DB.TaskEntity


class RecyclerAdapter(private val taskEntities: List<TaskEntity>,
                      private val taskDao: TaskDao,
                      private val database: TaskDatabase,
                      private val mAct: AppCompatActivity
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private var tasks: MutableList<TaskEntity> = taskEntities as MutableList<TaskEntity>

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
            tasks.removeAt(index)
            notifyDataSetChanged()
        }
    }

//        init {
//            itemView.setOnClickListener {
//                println(nameTextView.text)
//                println(idTextView.text)
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
//        holder.nameTextView.setText(pos.name)
        holder.nameTextView.text = pos.name.toString()
        holder.idTextView.text = pos.id.toString()
//        holder.nameTextView.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            }
//        })

//        holder.nameTextView.doAfterTextChanged { println(it) }
    }

    override fun getItemCount(): Int {
        return taskEntities.size
    }



}