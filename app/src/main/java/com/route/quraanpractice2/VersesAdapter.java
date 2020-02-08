package com.route.quraanpractice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder> {

    List<String> verses;

    public VersesAdapter(List<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.verses_item, parent, false));
    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.versesTextView.setText(verses.get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView versesTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            versesTextView = itemView.findViewById(R.id.versesTextView);
        }
    }
}
