package sg.edu.rp.c347.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddTask;

    ListView lvTask;
    ArrayAdapter aaTask;
    ArrayList<Task> task = new ArrayList<Task>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTask = findViewById(R.id.btnAddTask);
        lvTask = findViewById(R.id.lvTask);
        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<Task> data = db.getTaskContent();
        aaTask = new TaskAdapter(this, R.layout.row, data);
        lvTask.setAdapter(aaTask);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
