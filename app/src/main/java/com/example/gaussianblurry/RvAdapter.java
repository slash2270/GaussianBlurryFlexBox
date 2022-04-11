package com.example.gaussianblurry;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexboxLayoutManager;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter <ItemViewHolder>{

    private final Activity activity;
    private final Context context;
    private ArrayList<Integer> arrayList;
    private ViewGroup.LayoutParams vlp;

    public RvAdapter(Activity activity, Context context, ArrayList<Integer> arrAdapter) {
        this.activity = activity;
        this.context = context;
        this.arrayList = arrAdapter;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_view1, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        vlp = itemViewHolder.itemView.getLayoutParams();
        vlp.height = (parent.getHeight() / 3);

        return itemViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Log.d("取得 position ", String.valueOf(position));

            /*if(position % 5 == 0){
                holder.iv1.setImageDrawable(context.getResources().getDrawable(arrAdapter.get(position)));
            }else if(position == 1 || position % 6 == 0 ){
                holder.iv2.setImageDrawable(context.getResources().getDrawable(arrAdapter.get(position)));
            }else if(position == 2 || position % 7 == 0 ){
                holder.iv3.setImageDrawable(context.getResources().getDrawable(arrAdapter.get(position)));
            }else if(position == 3 || position % 8 == 0 ){
                holder.iv4.setImageDrawable(context.getResources().getDrawable(arrAdapter.get(position)));
            }else if(position == 4 || position % 9 == 0 ){
                holder.iv5.setImageDrawable(context.getResources().getDrawable(arrAdapter.get(position)));
            }*/

        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        vlp = holder.rlt.getLayoutParams();
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(holder.rlt.getLayoutParams());
        if(position % 5 != 0) {
            lp.width = displayMetrics.widthPixels / 2;
        }else {
            lp.width = displayMetrics.widthPixels;
            lp.topMargin = dip2px(context, 20f);
        }
        holder.iv1.setLayoutParams(lp);

        if (vlp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp = (FlexboxLayoutManager.LayoutParams) vlp;
            flexboxLp.setFlexGrow(1.0f); //超過100%就換行
            flexboxLp.setAlignSelf(AlignItems.FLEX_END);
        }

    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    public int getItemCount() {
        return arrayList == null ? 0 : arrayList.size();
    }

}