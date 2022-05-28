package com.example.recipessocialapp.search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipessocialapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {
    private List<Item> List;
    private List<Item> ListFull;
    private ItemClickListener mOnClickListener;

    public interface ItemClickListener{
        void selectedItem(Item item);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView1 = itemView.findViewById(R.id.text_view1);
            textView2 = itemView.findViewById(R.id.text_view2);
            textView3 = itemView.findViewById(R.id.text_view3);
        }
    }

    Adapter(List<Item> List, ItemClickListener l) {
        this.List = List;
        this.mOnClickListener = l;
        ListFull = new ArrayList<>(List);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item currentItem = List.get(position);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
        holder.textView3.setText(currentItem.getText3());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickListener.selectedItem(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    @Override
    public Filter getFilter() {
        return Filter;
    }

    private Filter Filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Item> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                    for (Item item : ListFull) {

                        if (item.getText1().toLowerCase().contains(filterPattern) && !filteredList.contains(item)) {
                            filteredList.add(item);
                        }
                        if (item.getText2().toLowerCase().contains(filterPattern) && !filteredList.contains(item)) {
                            filteredList.add(item);
                        }
                        if (item.getText3().toLowerCase().contains(filterPattern) && !filteredList.contains(item)) {
                            filteredList.add(item);
                        }

                    }

            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List.clear();
            List.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

