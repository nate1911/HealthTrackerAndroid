package com.example.healthtrackerapp.classes;

public class HomeDescriptionModel
{
    String title;
    String videoUrl;

    public HomeDescriptionModel(String title, String videoUrl)
    {
        this.title = title;
        this.videoUrl = videoUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getVideoUrl()
    {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl)
    {
        this.videoUrl = videoUrl;
    }
}
