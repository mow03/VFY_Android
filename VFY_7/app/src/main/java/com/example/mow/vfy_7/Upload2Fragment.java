package com.example.mow.vfy_7;

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


public class Upload2Fragment extends Fragment {

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



        View view = inflater.inflate(R.layout.fragment_upload2, container, false);

        Button reload = view.findViewById(R.id.reload);
        mChooseVideo = view.findViewById(R.id.button_choose);
        mButtonUpload = view.findViewById(R.id.button_upload);
        mTextViewShowUploads= view.findViewById(R.id.show_uploads);
        mEditTextFileName = view.findViewById(R.id.file_name);
        mVideoView = view.findViewById(R.id.video_view);
        mProgressBar = view.findViewById(R.id.progress_bar);

        return inflater.inflate(R.layout.fragment_upload2,container,false);

    }


}
