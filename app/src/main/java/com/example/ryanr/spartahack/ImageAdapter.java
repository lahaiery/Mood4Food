package com.example.ryanr.spartahack;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ryanr.spartahack.R;

/**
 * Created by ryanr on 1/20/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mImagesList;
    private int mList = 0;
    public ImageAdapter(Context c, int index) {
        mContext = c;
        mList = index;
        if(index==0){
            this.mImagesList= mMenuIds;
        } else if(index==1){
            this.mImagesList= mFilterIds;
        }
    }

    public int getCount() {
        return mImagesList.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        imageView = new ImageView(mContext);

        int screenWidth = parent.getMeasuredWidth();
        int screenHeight = parent.getMeasuredHeight();
        /*if(position+1 == getCount())
        {
            //imageView.setLayoutParams(new GridView.LayoutParams(screenWidth/2,  screenHeight/10));
        }*/
        if(mList == 0)
        {
            imageView.setLayoutParams(new GridView.LayoutParams(screenWidth/2,screenWidth/2));
        }
        else if(mList == 1)
        {
            imageView.setLayoutParams(new GridView.LayoutParams(screenWidth,screenWidth));
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setPadding(0, 0, 0, 0);

        imageView.setImageResource(mImagesList[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mFilterIds = {
            R.drawable.breakfast, R.drawable.lunch, R.drawable.dinner, R.drawable.latenight,
    };

    private Integer[] mMenuIds = {
            R.drawable.akers, R.drawable.brody, R.drawable.ncase, R.drawable.landon,
            R.drawable.holden, R.drawable.holmes, R.drawable.owen, R.drawable.snyphi,
            R.drawable.wilson, R.drawable.shaw, R.drawable.blank,
    };


}