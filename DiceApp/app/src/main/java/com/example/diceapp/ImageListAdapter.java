package com.example.diceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ImageListAdapter extends ArrayAdapter<Integer> {
    private Context mContext;
    private List<Integer> mImageIds;

    public ImageListAdapter(@NonNull Context context, @NonNull List<Integer> objects) {
        super(context, 0, objects);
        mContext = context;
        mImageIds = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_image, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.image_view);
        imageView.setImageResource(mImageIds.get(position));

        return convertView;
    }
}

