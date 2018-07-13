package com.example.mow.vfy_7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;


public class UploadFragment extends Fragment {

    private static final int PICK_VIDEO = 1;
    private Button mChooseVideo;
    private Button mButtonUpload;
    private TextView mTextViewShowUploads;
    private EditText mEditTextFileName;
    private VideoView mVideoView;
    private ProgressBar mProgressBar;

    private Uri mVideoUri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Button reload = (Button)getView().findViewById(R.id.reload);


        mChooseVideo = getView().findViewById(R.id.button_choose);
        mButtonUpload = getView().findViewById(R.id.button_upload);
        mTextViewShowUploads= getView().findViewById(R.id.show_uploads);
        mEditTextFileName = getView().findViewById(R.id.file_name);
        mVideoView = getView().findViewById(R.id.video_view);
        mProgressBar = getView().findViewById(R.id.progress_bar);


        mChooseVideo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }

        });


        mButtonUpload.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        mTextViewShowUploads.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

            }
        });

        return inflater.inflate(R.layout.fragment_upload,container,false);

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_VIDEO);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_VIDEO
                && data != null && data.getData()!=null) {
            mVideoUri = data.getData();
            mVideoView.setVideoURI(mVideoUri);
        }
    }

}
