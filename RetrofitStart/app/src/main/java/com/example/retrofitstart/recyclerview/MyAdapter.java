package com.example.retrofitstart.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitstart.GitHubRepo;
import com.example.retrofitstart.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<GitHubRepo> gitHubRepoList;
    private Context context;



    // Provide a suitable constructor (depends on the kind of dataset)

    public MyAdapter(List<GitHubRepo> gitHubRepoList, Context context) {
        this.gitHubRepoList = gitHubRepoList;
        this.context = context;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
//        ...
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        GitHubRepo gitHubRepo = gitHubRepoList.get(position);
        holder.name.setText(gitHubRepo.getName());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return gitHubRepoList.size();
    }


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}

