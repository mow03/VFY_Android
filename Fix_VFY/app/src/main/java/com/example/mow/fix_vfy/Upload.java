package com.example.mow.fix_vfy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

import static android.app.Activity.RESULT_OK;

public class Upload extends Fragment {
    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "MainActivity";
    TextView textView;
    Bitmap bitmap;
    ImageView imageView;
Button upload;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Upload");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.upload,container,false);

        textView = (TextView) view.findViewById(R.id.textView3);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
       // upload = (Button) view.findViewById(R.id.button4).setOnClickListener(this);

      //  imageView = (ImageView) view.findViewById(R.id.btnSelectImage).setOnClickListener(this);
       // imageView = (ImageView)view.findViewById(R.id.imageView2).setOnClickListener(this);


        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... voids) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte [] b = baos.toByteArray();

                String encodeImage = Base64.encodeToString(b, Base64.DEFAULT);

                return encodeImage;
            }

            @Override
            protected void onPostExecute(String s) {
                textView.setText(s);
            }
        }.execute();

        return view;

    }

    /* Choose an image from Gallery */
   /* void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture");
    } */

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                   // String path = getPathFromURI(selectedImageUri);
                   // Log.i(TAG, "Image Path : " + path);
                    // Set the image in ImageView
                    //((ImageView) findViewById(R.id.imgView)).setImageURI(selectedImageUri);
                }
            }
        }
    }


  /*  @Override
    public void onClick(View view) {
        openImageChooser();
    } */
}
