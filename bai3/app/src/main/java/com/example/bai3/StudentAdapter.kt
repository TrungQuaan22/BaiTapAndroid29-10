package com.example.bai3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val students: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var filteredStudents = students.toMutableList()

    fun filter(query: String) {
        filteredStudents = if (query.length > 2) {
            students.filter {
                it.name.contains(query, ignoreCase = true) ||
                        it.studentId.contains(query, ignoreCase = true)
            }.toMutableList()
        } else {
            students.toMutableList()
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = filteredStudents[position]
        holder.bind(student)
    }

    override fun getItemCount() = filteredStudents.size

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.tvStudentName)
        private val idTextView: TextView = itemView.findViewById(R.id.tvStudentId)

        fun bind(student: Student) {
            nameTextView.text = student.name
            idTextView.text = student.studentId
        }
    }
}
