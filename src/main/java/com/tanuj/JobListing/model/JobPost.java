package com.tanuj.JobListing.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "JobPost")
public class JobPost {

    private Company company;
    private String jobTitle;
    private Double[] location;
    private String[] skills;
    private String formattedAddress;

    public JobPost() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Double[] getLocation() {
        return location;
    }

    public void setLocation(Double[] location) {
        this.location = location;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "company=" + company +
                ", jobTitle='" + jobTitle + '\'' +
                ", location=" + Arrays.toString(location) +
                ", skills='" + Arrays.toString(skills) + '\'' +
                ", formattedAddress='" + formattedAddress + '\'' +
                '}';
    }

}
