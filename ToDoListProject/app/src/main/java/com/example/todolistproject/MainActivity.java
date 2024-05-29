package com.example.todolistproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView toDoList;
    Button addItem,refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toDoList=findViewById(R.id.to_do_list);
        addItem=findViewById(R.id.to_do_add);
        refresh=findViewById(R.id.refreshtodo);
        toDoList.setLayoutManager(new LinearLayoutManager(this));
        DataBaseHandler db=new DataBaseHandler(this);
        List<String> toDo= db.getToDo();
        ToDoAdapter adapter= new ToDoAdapter(toDo);
        toDoList.setAdapter(adapter);
        addItem.setOnClickListener(this::addToDo);
        refresh.setOnClickListener(this::refreshList);
    }

    protected void refreshList(View view) {
        DataBaseHandler db=new DataBaseHandler(this);
        List<String> toDo= db.getToDo();
        ToDoAdapter adapter= new ToDoAdapter(toDo);
        toDoList.setAdapter(adapter);
    }

    protected void addToDo(View view) {
        AddDialog add=new AddDialog(this);
        add.show();
        add.getWindow().setLayout(600,600);
    }
}