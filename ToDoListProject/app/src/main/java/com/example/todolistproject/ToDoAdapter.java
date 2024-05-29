package com.example.todolistproject;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ItemHolder> {
    List<String> ToDoList;

    public ToDoAdapter(List<String> toDo) {
        ToDoList=toDo;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.bind(ToDoList.get(position));
    }

    @Override
    public int getItemCount() {
        return ToDoList.size();
    }
}
