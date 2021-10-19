package com.cd.statussaver.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.cd.statussaver.R;
import com.cd.statussaver.databinding.ItemUserListBinding;
import com.cd.statussaver.interfaces.UserListInterface;
import com.cd.statussaver.model.story.TrayModel;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TrayModel> trayModelArrayList;
    private UserListInterface userListInterface;

    public UserListAdapter(Context context, ArrayList<TrayModel> list, UserListInterface listInterface) {
        this.context = context;
        this.trayModelArrayList = list;
        this.userListInterface = listInterface;
    }

    @NonNull
    @Override
    public UserListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.item_user_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.ViewHolder viewHolder, int position) {

        viewHolder.binding.realName.setText(trayModelArrayList.get(position).getUser().getFull_name());
        Glide.with(context).load(trayModelArrayList.get(position).getUser().getProfile_pic_url())
                .thumbnail(0.2f).into(viewHolder.binding.storyIcon);

        viewHolder.binding.RLStoryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userListInterface.userListClick(position,trayModelArrayList.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return trayModelArrayList == null ? 0 : trayModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ItemUserListBinding binding;
        public ViewHolder(ItemUserListBinding mbinding) {
            super(mbinding.getRoot());
            this.binding = mbinding;
        }
    }
}