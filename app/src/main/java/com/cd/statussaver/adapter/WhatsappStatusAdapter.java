package com.cd.statussaver.adapter;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.cd.statussaver.R;
import com.cd.statussaver.databinding.ItemsWhatsappViewBinding;
import com.cd.statussaver.model.WhatsappStatusModel;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.cd.statussaver.util.Utils.RootDirectoryWhatsappShow;
import static com.cd.statussaver.util.Utils.createFileFolder;


public class WhatsappStatusAdapter extends RecyclerView.Adapter<WhatsappStatusAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WhatsappStatusModel> fileArrayList;
    private LayoutInflater layoutInflater;
    public String SaveFilePath = RootDirectoryWhatsappShow+ "/";
    public WhatsappStatusAdapter(Context context, ArrayList<WhatsappStatusModel> files) {
        this.context = context;
        this.fileArrayList = files;
    }

    @NonNull
    @Override
    public WhatsappStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.items_whatsapp_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WhatsappStatusAdapter.ViewHolder viewHolder, int i) {
        WhatsappStatusModel fileItem = fileArrayList.get(i);
        if (fileItem.getUri().toString().endsWith(".mp4")){
            viewHolder.binding.ivPlay.setVisibility(View.VISIBLE);
        }else {
            viewHolder.binding.ivPlay.setVisibility(View.GONE);
        }
        Glide.with(context)
                .load(fileItem.getPath())
                .into(viewHolder.binding.pcw);


        viewHolder.binding.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFileFolder();
                final String path = fileItem.getPath();
                String filename=path.substring(path.lastIndexOf("/")+1);
                final File file = new File(path);
                File destFile = new File(SaveFilePath);
                try {
                    FileUtils.copyFileToDirectory(file, destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String fileNameChange=filename.substring(12);
                File newFile = new File(SaveFilePath+fileNameChange);
                String ContentType = "image/*";
                if (fileItem.getUri().toString().endsWith(".mp4")){
                   ContentType = "video/*";
                }else {
                    ContentType = "image/*";
                }
                MediaScannerConnection.scanFile(context, new String[]{newFile.getAbsolutePath()}, new String[]{ContentType},
                        new MediaScannerConnection.MediaScannerConnectionClient() {
                            public void onMediaScannerConnected() {
                            }

                            public void onScanCompleted(String path, Uri uri) {
                            }
                        });

                File from = new File(SaveFilePath,filename);
                File to = new File(SaveFilePath,fileNameChange);
                from.renameTo(to);

                Toast.makeText(context, context.getResources().getString(R.string.saved_to) + SaveFilePath + fileNameChange, Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return fileArrayList == null ? 0 : fileArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemsWhatsappViewBinding binding;

        public ViewHolder(ItemsWhatsappViewBinding mbinding) {
            super(mbinding.getRoot());
            this.binding = mbinding;
        }
    }
}