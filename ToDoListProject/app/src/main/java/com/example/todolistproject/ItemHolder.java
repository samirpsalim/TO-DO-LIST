package com.example.todolistproject;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder {
    TextView description;
    Button removeButton;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
    }


    public void bind(String toDoItem) {
        description=itemView.findViewById(R.id.item);
        description.setText(toDoItem);
        removeButton =itemView.findViewById(R.id.removebutton);
        removeButton.setOnClickListener(this::DoneItem);
    }

    protected void DoneItem(View view) {
        DoneDialog done=new DoneDialog(view.getContext(),description.getText().toString());
        done.show();
        done.getWindow().setLayout(600, 500);
    }
}
