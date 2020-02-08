package com.route.quraanpractice2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class VersesActivity extends AppCompatActivity {

    RecyclerView versesRecyclerView;
    VersesAdapter versesAdapter;
    RecyclerView.LayoutManager layoutManager;

    TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        int position = intent.getIntExtra("position", -1);

        versesRecyclerView = findViewById(R.id.versesRecyclerView);
        titleTextView = findViewById(R.id.titleTextView);
        versesAdapter = new VersesAdapter(getVersesList((position + 1) + ".txt"));
        layoutManager = new LinearLayoutManager(this);

        versesRecyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        titleTextView.setText(title);
        versesRecyclerView.setLayoutManager(layoutManager);
        versesRecyclerView.setAdapter(versesAdapter);
    }

    private List<String> getVersesList(String fileName) {
        List<String> verses = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName), StandardCharsets.UTF_8));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                verses.add(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        return verses;
    }
}
