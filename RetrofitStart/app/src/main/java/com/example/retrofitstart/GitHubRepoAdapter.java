package com.example.retrofitstart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laptop Dream on 07-Jul-16.
 */
public class GitHubRepoAdapter extends ArrayAdapter {

    private Context context;
    private List<GitHubRepo> contactList;
    ViewHolder viewHolder;
    public GitHubRepoAdapter(Context context, List<GitHubRepo> contactList) {
        super(context, R.layout.row_layout,contactList);
        this.context=context;
        this.contactList=contactList;
    }
    public class ViewHolder{
        TextView nameTV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.nameTV = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }
        else {
            convertView.getTag();
        }
        viewHolder.nameTV.setText(contactList.get(position).getName());
        return convertView;
    }
}
