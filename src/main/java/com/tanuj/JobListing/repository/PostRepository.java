package com.tanuj.JobListing.repository;

import com.tanuj.JobListing.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<JobPost,String> {

}
