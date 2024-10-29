package com.example.bai2
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.week4.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextNumber)
        val radioEven = findViewById<RadioButton>(R.id.radioEven)
        val radioOdd = findViewById<RadioButton>(R.id.radioOdd)
        val radioSquare = findViewById<RadioButton>(R.id.radioSquare)
        val btnShow = findViewById<Button>(R.id.btnShow)
        val listView = findViewById<ListView>(R.id.listView)
        val errorText = findViewById<TextView>(R.id.errorText)

        btnShow.setOnClickListener {
            val n = editText.text.toString().toIntOrNull()
            if (n == null || n <= 0) {
                errorText.text = "Vui lòng nhập một số nguyên dương"
                errorText.visibility = TextView.VISIBLE  // Hiển thị thông báo lỗi
                listView.adapter = null  // Xóa danh sách nếu có lỗi
                return@setOnClickListener
            }

            // Tạo danh sách số dựa trên lựa chọn của người dùng
            val numbers = when {
                radioEven.isChecked -> (0..n).filter { it % 2 == 0 }
                radioOdd.isChecked -> (0..n).filter { it % 2 != 0 }
                radioSquare.isChecked -> (0..n).filter { k ->
                    val sqrt = Math.sqrt(k.toDouble()).toInt()
                    sqrt * sqrt == k
                }
                else -> emptyList()
            }

            // Xóa thông báo lỗi và cập nhật ListView với kết quả
            errorText.text = ""
            errorText.visibility = TextView.GONE
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numbers)
        }
    }
}
