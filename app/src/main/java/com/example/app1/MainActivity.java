package com.example.app1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private EditText edtId, edtName, edtAge, edtGpa;
    private Button btnInsert, btnClear;
    private TextView txtDisplayList;
    private ArrayList<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        initViews();
        studentList = new ArrayList<>();
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewStudent();
            }
        });


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearStudentList();
            }
        });
    }

    private void initViews() {
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtGpa = findViewById(R.id.edtGpa);
        btnInsert = findViewById(R.id.btnInsert);
        btnClear = findViewById(R.id.btnClear);
        txtDisplayList = findViewById(R.id.txtDisplayList);
    }


    private void addNewStudent() {
        String id = edtId.getText().toString().trim();
        String name = edtName.getText().toString().trim();
        String ageStr = edtAge.getText().toString().trim();
        String gpaStr = edtGpa.getText().toString().trim();
        if (id.isEmpty() || name.isEmpty() || ageStr.isEmpty() || gpaStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ tất cả thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }
        try {

            int age = Integer.parseInt(ageStr);
            double gpa = Double.parseDouble(gpaStr);


            if (gpa < 0 || gpa > 10) {
                Toast.makeText(this, "Điểm GPA phải nằm trong khoảng từ 0 đến 10!", Toast.LENGTH_SHORT).show();
                return;
            }


            Student newStudent = new Student(id, name, age, gpa);
            studentList.add(newStudent);
            updateStudentDisplay();
            clearInputFields();
            Toast.makeText(this, "Thêm sinh viên thành công!", Toast.LENGTH_SHORT).show();

        } catch (NumberFormatException e) {

            Toast.makeText(this, "Tuổi hoặc Điểm GPA không đúng định dạng số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateStudentDisplay() {
        if (studentList.isEmpty()) {
            txtDisplayList.setText("Chưa có dữ liệu sinh viên.");
            return;
        }

        StringBuilder builder = new StringBuilder();
        int count = 1;

        for (Student student : studentList) {
            builder.append("STT: ").append(count).append("\n");

            builder.append(student.displayInfo());
            count++;
        }

        txtDisplayList.setText(builder.toString());
    }
    private void clearStudentList() {
        studentList.clear();
        updateStudentDisplay();
        Toast.makeText(this, "Đã xóa toàn bộ danh sách sinh viên!", Toast.LENGTH_SHORT).show();
    }
    private void clearInputFields() {
        edtId.setText("");
        edtName.setText("");
        edtAge.setText("");
        edtGpa.setText("");
        edtId.requestFocus();
    }
}
