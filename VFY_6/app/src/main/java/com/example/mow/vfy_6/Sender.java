package com.example.mow.vfy_6;

import android.os.AsyncTask;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


public class Sender extends AsyncTask<Void,Void,Void>
{
    Socket s;
    DataOutputStream dos;
    PrintWriter pw;


    @Override
    protected Void doInBackground(Void... voids) {


        try{
            s = new Socket("103.27.9.111",7800);
            pw = new PrintWriter(s.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
