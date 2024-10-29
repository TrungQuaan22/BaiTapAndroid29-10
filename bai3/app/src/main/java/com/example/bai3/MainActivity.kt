package com.example.bai3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bai3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: StudentAdapter
    private val students = listOf(
        Student("Nguyễn Văn A", "20210001"),
        Student("Trần Thị B", "20210002"),
        Student("Lê Văn C", "20210003"),
        Student("Phạm Thị D", "20210004"),
        Student("Vũ Văn E", "20210005"),
        Student("Đỗ Thị F", "20210006"),
        Student("Bùi Văn G", "20210007"),
        Student("Lý Thị H", "20210008"),
        Student("Ngô Văn I", "20210009"),
        Student("Trịnh Thị J", "20210010"),
        Student("Lương Văn K", "20210011"),
        Student("Trần Văn L", "20210012"),
        Student("Nguyễn Thị M", "20210013"),
        Student("Đoàn Văn N", "20210014"),
        Student("Võ Thị O", "20210015"),
        Student("Hoàng Văn P", "20210016"),
        Student("Dương Thị Q", "20210017"),
        Student("Nguyễn Văn R", "20210018"),
        Student("Phan Thị S", "20210019"),
        Student("Lê Văn T", "20210020")
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = StudentAdapter(students)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
