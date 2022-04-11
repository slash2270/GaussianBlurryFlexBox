package com.example.gaussianblurry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap bitmap = BitmapFactory.decodeResource(getBaseContext().getResources(), R.mipmap.banner);

        bitmap = Blurry.getBlur(getBaseContext(), bitmap, 20);

        ImageView iv = findViewById(R.id.image);
        iv.setImageBitmap(bitmap);

        RecyclerView recyclerView = findViewById(R.id.recycler);

        setRv(recyclerView);

    }

    private void setRv(RecyclerView recyclerView){

        recyclerView.setItemViewCacheSize(5);

        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getBaseContext());
        flexboxLayoutManager.setFlexDirection(FlexDirection.ROW);//按正常方向换行 縱向 设置主轴方向
        flexboxLayoutManager.setFlexWrap(FlexWrap.WRAP);//是否換行
        flexboxLayoutManager.setAlignItems(AlignItems.STRETCH);//每個item填滿 设置item沿次轴方向的位置
        flexboxLayoutManager.setJustifyContent(JustifyContent.FLEX_END);//设置item沿主轴方向的位置
        recyclerView.setLayoutManager(flexboxLayoutManager);

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arrayList.add(R.mipmap.banner);
        }

        RvAdapter rvAdapter = new RvAdapter(this, getBaseContext(), arrayList);
        recyclerView.setAdapter(rvAdapter);

    }

}