package com.example.businessapplicationdevelopment.api;


import java.util.List;

import com.example.businessapplicationdevelopment.api.Project;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RaverlyProjects {

    @SerializedName("projects")
    @Expose
    private List<Project> projects = null;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
