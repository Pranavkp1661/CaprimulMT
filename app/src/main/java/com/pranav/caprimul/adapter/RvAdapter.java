package com.pranav.caprimul.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pranav.caprimul.R;
import com.pranav.caprimul.models.CarsEntity;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {
    Context context;
    List<CarsEntity> carsEntities = new ArrayList<>();
    CarsInterface carsInterface;

    public RvAdapter(Context context, List<CarsEntity> carsEntities, CarsInterface carsInterface) {
        this.context = context;
        this.carsEntities = carsEntities;
        this.carsInterface = carsInterface;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateAdapter(List<CarsEntity> carsEntities){
        this.carsEntities=carsEntities;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RvViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_layout, parent, false);
        return new RvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvViewHolder holder, int position) {
        holder.tvCarName.setText(carsEntities.get(position).getCarName());
        holder.tvCarColor.setText(carsEntities.get(position).getColor());
        holder.btEdit.setOnClickListener(v -> {

        });
    }

    @Override
    public int getItemCount() {
        return carsEntities.size();
    }

    public static class RvViewHolder extends RecyclerView.ViewHolder {
        TextView tvCarName;
        TextView tvCarColor;
        Button btDelete;
        Button btEdit;

        public RvViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCarName = itemView.findViewById(R.id.tvCarName);
            tvCarColor = itemView.findViewById(R.id.tvCarColor);
            btDelete = itemView.findViewById(R.id.btDelete);
            btEdit = itemView.findViewById(R.id.btEdit);
        }
    }
    public interface CarsInterface {
        void updateCars(CarsEntity carsEntity);
        void deleteCars(CarsEntity carsEntity);
    }
}
