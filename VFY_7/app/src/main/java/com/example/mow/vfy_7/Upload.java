package com.example.mow.vfy_7;

public class Upload {

    private String mName;
    private String mVideoUrl;

    public Upload(){

    }

    public Upload(String name,String videoUrl){
        if(name.trim().equals("")){
            name="No name";
        }
        mName = name;
        mVideoUrl = videoUrl;
    }
}
