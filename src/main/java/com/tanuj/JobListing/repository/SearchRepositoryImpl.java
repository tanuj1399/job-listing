package com.tanuj.JobListing.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tanuj.JobListing.model.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String text){

        final List<JobPost> posts = new ArrayList<>();

        MongoDatabase database = client.getDatabase("TanujDB");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(List.of(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("skills", "jobTitle", "company.companyName", "formattedAddress"))))));

        result.forEach(doc -> posts.add(converter.read(JobPost.class,doc)));

        return posts;
    }
}
