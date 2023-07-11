package sg.edu.rp.c346.id22017979.demodatabasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    TextView tvID;
    EditText etContent;
    Button btnUpdate, btnDelete, btnBack;
    Note data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        tvID = findViewById(R.id.tvID);
        etContent = findViewById(R.id.etContent);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnBack = findViewById(R.id.btnBack);

        Intent i = getIntent();
        data = (Note) i.getSerializableExtra("data");

        tvID.setText("ID: " + data.getId());
        etContent.setText(data.getNoteContent());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                data.setNoteContent(etContent.getText().toString());
                dbh.updateNote(data);
                dbh.close();
                Intent i = new Intent(EditActivity.this,
                        MainActivity.class);
                startActivity(i);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditActivity.this);
                dbh.deleteNote(data.getId());
                Intent i = new Intent(EditActivity.this,
                        MainActivity.class);
                startActivity(i);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EditActivity.this,
                        MainActivity.class);
                startActivity(i);
            }
        });



    }
}

