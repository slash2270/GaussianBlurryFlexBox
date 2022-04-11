package com.example.gaussianblurry;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public RelativeLayout rlt;
    public ImageView iv1, iv2 ,iv3 ,iv4 ,iv5;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        rlt = itemView.findViewById(R.id.relative);
        iv1 = itemView.findViewById(R.id.iv1);
        iv2 = itemView.findViewById(R.id.iv2);
        iv3 = itemView.findViewById(R.id.iv3);
        iv4 = itemView.findViewById(R.id.iv4);
        iv5 = itemView.findViewById(R.id.iv5);
    }

}