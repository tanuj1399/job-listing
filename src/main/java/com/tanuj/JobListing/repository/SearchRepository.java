package com.tanuj.JobListing.repository;

import com.tanuj.JobListing.model.JobPost;

import java.util.List;

public interface SearchRepository {

    List<JobPost> findByText(String text);
}
