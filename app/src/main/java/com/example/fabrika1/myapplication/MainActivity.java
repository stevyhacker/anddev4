package com.example.fabrika1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteListAdapter.OnItemClickListener {

    NoteListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView noteList = findViewById(R.id.note_list);
        noteList.setLayoutManager(new LinearLayoutManager
                (this,LinearLayoutManager.VERTICAL,false));

        List<Note> noteListData = new ArrayList<>();
        for(int i = 0; i<50;i++){
            noteListData.add(new Note(i + " task", ""));
        }
        noteListData.add(new Note("Prvi task", "Napravljen adapter"));
        noteListData.add(new Note("Drugi task", "Napravljen layout"));
        noteListData.add(new Note("Treci task", "Napravljen recyclerview"));

        adapter = new NoteListAdapter(this, noteListData, this);
        noteList.setAdapter(adapter);

    }

    @Override
    public void onClickListener(int position) {
        Toast.makeText(this, "Kliknut " + position + " element", Toast.LENGTH_SHORT).show();
    }
}
