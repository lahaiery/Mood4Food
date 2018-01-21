package com.example.ryanr.spartahack;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ryanr.spartahack.R;

/**
 * Created by ryanr on 1/20/2018.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Integer[] mImagesList;
    private int mList = 0;
    private ImageView imageView;

    private boolean BreakfastChecked = false;
    private boolean LunchChecked = false;
    private boolean DinnerChecked = false;
    private boolean LatenightChecked = false;

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

    public View switchFilterState(int pos) {
        switch(pos)
        {
            case 0:
                BreakfastChecked = !BreakfastChecked;
                break;
            case 1:
                LunchChecked = !LunchChecked;
                break;
            case 2:
                DinnerChecked = !DinnerChecked;
                break;
            case 3:
                LatenightChecked = !LatenightChecked;
                break;
        }
        return imageView;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        imageView = new ImageView(mContext);
        int screenWidth = parent.getMeasuredWidth();
        /*if(position+1 == getCount())
        {
            //imageView.setLayoutParams(new GridView.LayoutParams(screenWidth/2,  screenHeight/10));
        }*/
        if(mList == 0)
        {
            imageView.setLayoutParams(new GridView.LayoutParams(screenWidth/2,screenWidth/2));
            imageView.setImageResource(mImagesList[position]);
        }
        else if(mList == 1)
        {
            imageView.setLayoutParams(new GridView.LayoutParams(screenWidth,screenWidth));
            switch(position)
            {
                case 0:
                    if(BreakfastChecked) {
                        imageView.setImageResource(mFilterCheckedIds[position]);
                    }
                    else {
                        imageView.setImageResource(mImagesList[position]);
                    }
                    break;
                case 1:
                    if(LunchChecked) {
                        imageView.setImageResource(mFilterCheckedIds[position]);
                    }
                    else {
                        imageView.setImageResource(mImagesList[position]);
                    }
                    break;
                case 2:
                    if(DinnerChecked) {
                        imageView.setImageResource(mFilterCheckedIds[position]);
                    }
                    else {
                        imageView.setImageResource(mImagesList[position]);
                    }
                    break;
                case 3:
                    if(LatenightChecked) {
                        imageView.setImageResource(mFilterCheckedIds[position]);
                    }
                    else {
                        imageView.setImageResource(mImagesList[position]);
                    }
                    break;
            }


        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setPadding(0, 0, 0, 0);


        return imageView;
    }

    // references to our images
    private Integer[] mFilterIds = {
            R.drawable.breakfast, R.drawable.lunch, R.drawable.dinner, R.drawable.latenight,
    };

    private Integer[] mFilterCheckedIds = {
            R.drawable.breakfastcheck, R.drawable.lunchcheck, R.drawable.dinnercheck, R.drawable.latenightcheck,
    };

    private Integer[] mMenuIds = {
            R.drawable.akers, R.drawable.brody, R.drawable.ncase, R.drawable.landon,
            R.drawable.holden, R.drawable.holmes, R.drawable.owen, R.drawable.snyphi,
            R.drawable.wilson, R.drawable.shaw, R.drawable.blank,
    };


}