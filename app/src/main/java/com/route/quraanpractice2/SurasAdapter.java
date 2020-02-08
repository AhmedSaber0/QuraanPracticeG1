package com.route.quraanpractice2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SurasAdapter extends RecyclerView.Adapter<SurasAdapter.ViewHolder> {

    String[] suras;

    public SurasAdapter(String[] suras) {
        this.suras = suras;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.suras_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return suras.length;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.titleTextView.setText(suras[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListesner != null)
                    onItemClickListesner.onItemClick(suras[position], position);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
        }
    }

    public void setOnItemClickListesner(OnItemClickListesner onItemClickListesner) {
        this.onItemClickListesner = onItemClickListesner;
    }

    private OnItemClickListesner onItemClickListesner;

    public interface OnItemClickListesner {
        void onItemClick(String title, int position);
    }
}
