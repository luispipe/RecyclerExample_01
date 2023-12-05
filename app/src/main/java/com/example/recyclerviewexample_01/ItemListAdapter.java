package com.example.recyclerviewexample_01;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private List<ItemList> data;

    private LayoutInflater inflater;

    private Context context;

    public ItemListAdapter(List<ItemList> data, Context context) {
        this.data = data;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public ItemListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.item,null);
        return new ItemListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemListAdapter.ViewHolder holder,final int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<ItemList>items){
        data=items;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;

        TextView name,city,status;
        public ViewHolder(View itemView) {
            super(itemView);
            icon= itemView.findViewById(R.id.ivIcon);
            name=itemView.findViewById(R.id.tvName);
            city=itemView.findViewById(R.id.tvCity);
            status=itemView.findViewById(R.id.tvAvai);
        }

        void bindData(final ItemList item){
            icon.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            city.setText(item.getCity());
            status.setText(item.getStatus());
        }
    }


}
