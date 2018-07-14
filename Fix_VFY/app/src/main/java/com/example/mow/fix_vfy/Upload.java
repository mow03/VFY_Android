package com.example.mow.fix_vfy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;

public class Upload extends Fragment {

    TextView textView;
    Bitmap bitmap;

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
}
