package com.yubo.yubo.getmyphonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yubo on 2016/7/21.
 */
public class MyAdapter extends BaseAdapter {
    private List<PhoneInfo> lists;
    private Context context;
    private LinearLayout layout;

    public MyAdapter(List<PhoneInfo> lists,Context context){
        this.lists=lists;
        this.context=context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        LayoutInflater inflater=LayoutInflater.from(context);
//        layout=(LinearLayout)inflater.inflate(R.layout.cell,null);
//
//        TextView nametv=(TextView) layout.findViewById(R.id.name);
//        TextView numbertv=(TextView) layout.findViewById(R.id.number);
//        nametv.setText(lists.get(i).getName());
//        numbertv.setText(lists.get(i).getNumber());
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.cell, null);
            holder = new ViewHolder();
            holder.nametv = (TextView) view.findViewById(R.id.name);
            holder.numbertv = (TextView) view.findViewById(R.id.number);
            holder.nametv.setText(lists.get(i).getName());
            holder.numbertv.setText(lists.get(i).getNumber());
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
            holder.nametv.setText(lists.get(i).getName());
            holder.numbertv.setText(lists.get(i).getNumber());
        }
        return view;
    }

    private static class ViewHolder{
        TextView nametv;
        TextView numbertv;
    }
}
