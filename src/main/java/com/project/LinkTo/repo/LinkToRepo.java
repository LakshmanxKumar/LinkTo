package com.project.LinkTo.repo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.LinkTo.model.LongLink;

@Repository
public interface LinkToRepo extends MongoRepository<LongLink,String>{

}
