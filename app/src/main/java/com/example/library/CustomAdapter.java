package com.example.library;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomAdapter extends BaseAdapter {
    // Keep all Images in array

   public Integer[] mThumbIds  = {
            R.drawable.e12341,R.drawable.e12342,R.drawable.e12343,R.drawable.e12345,R.drawable.e12346,
            R.drawable.e12347,R.drawable.e12348,R.drawable.e12349,R.drawable.e12350,R.drawable.e12351,R.drawable.e12352,
            R.drawable.e12353,R.drawable.e12354,R.drawable.e12355,R.drawable.e12356,R.drawable.e12357,R.drawable.e12358,
            R.drawable.e12359,R.drawable.e12360
    };

    public String[] mThumbNames = {
            "Java Fundamentals", "Effective Java", "Java The Complete Reference", "Head First Java", "The C Language", "The C programming Language",
            "C Programming","C Programming A Model Approach","Expert C Programming","C++ From Control Structures",
            "C++ Primer","The C++","Effective Modern C++","Accelerated C++","Python Crash Course","Head First Python",
            "Learn Python The Hard Way","Python Programming","Learning With Python"

    };
    private Context mContext;

    // Constructor
    public CustomAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

 ViewHolderItem viewHolder;


        if (convertView == null) {

            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.row_grid, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem =  convertView.findViewById(R.id.textView);

            viewHolder.imageViewItem =  convertView.findViewById(R.id.imageView);
            // store the holder with the view.
            convertView.setTag(viewHolder);


        } else {
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        // object item based on the position

        // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
        viewHolder.textViewItem.setText(mThumbNames[position]);
        viewHolder.textViewItem.setTag(position);

        viewHolder.imageViewItem.setImageResource(mThumbIds[position]);


        return convertView;

    }

    // our ViewHolder.
// caches our TextView
    static class ViewHolderItem {
        TextView textViewItem;
        ImageView imageViewItem;
    }


}