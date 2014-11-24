package me.widea.taketurns;

/**
 * Created by Rohit and Viveka on 11/21/14.
 */

import java.util.ArrayList;
import java.util.TreeSet;
import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import me.widea.taketurns.beans.NavigationDrawerListItemHolder;


public class NavigationDrawerAdapter extends BaseAdapter {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<NavigationDrawerListItemHolder> mData = new ArrayList<NavigationDrawerListItemHolder>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    public int getCurrentSelectedPosition() {
        return mCurrentSelectedPosition;
    }

    public void setCurrentSelectedPosition(int mCurrentSelectedPosition) {
        this.mCurrentSelectedPosition = mCurrentSelectedPosition;
    }

    private int mCurrentSelectedPosition = 0;

    private LayoutInflater mInflater;
    private Context mContext;

    public NavigationDrawerAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final NavigationDrawerListItemHolder item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final NavigationDrawerListItemHolder item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public NavigationDrawerListItemHolder getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.navigation_list_item, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.nli_tv_text);
                    holder.imageView = (ImageView)convertView.findViewById(R.id.nli_iv_icon);
                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.navigation_list_section_header, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.nlsh_tv_headertext);
                    convertView.setEnabled(false);
                    convertView.setOnClickListener(null);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(this.getCurrentSelectedPosition() == position) {
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.dark_gray));
        } else {
            convertView.setBackgroundColor(mContext.getResources().getColor(R.color.nav_gray));
        }
        holder.textView.setText(mData.get(position).getText());
        if(holder.imageView != null)
            holder.imageView.setImageDrawable(mData.get(position).getImageId());

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
        public ImageView imageView;
    }
}
