package com.project.LinkTo.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.LinkTo.model.LongLink;
import com.project.LinkTo.model.RecivedLink;
import com.project.LinkTo.repo.LinkToRepo;

@Service
public class LinkToService {
	
	LinkToRepo repository;
	
	@Autowired
	LinkToService(LinkToRepo repository){
		this.repository=repository;
	}
		
	public LongLink findLink(String id) {
		Optional<LongLink> ans= this.repository.findById(id);
		if(ans.isPresent()) {return ans.get();}else {
			return new LongLink(id,"Not Found");
		}
	}
	
	
	
	public  String addToDb(RecivedLink userInput) {
		if(userInput.isValid()) {
			
		String customLink=userInput.getCustomString();
		boolean wantsRandomId=userInput.getRandomIdAssignment();
		if(customLink!=null) {
			String assign=userInput.getCustomString();
			if(assign.isEmpty()) {return "Empty String are not accepted";}
			Optional<LongLink> found= repository.findById(assign); 
			if(found.isEmpty()) {
			LongLink insertDoc=new LongLink(assign,userInput.getLongLink());			
			repository.insert(insertDoc);
			return assign;}else return "Id taken";
		}else if(wantsRandomId) {
			String assign;
			while(true) {
				assign=generateRandomId();
				Optional<LongLink> found= repository.findById(assign); 
				if(found.isEmpty()) {break;}
			}
			LongLink insertDoc=new LongLink(assign,userInput.getLongLink());			
			repository.insert(insertDoc);
			return assign;
		}else{
			String assign;
			while(true) {
				assign=generateRandomString();
				Optional<LongLink> found= repository.findById(assign); 
				if(found.isEmpty()) {break;}
			}
			LongLink insertDoc=new LongLink(assign,userInput.getLongLink());			
			repository.insert(insertDoc);
			return assign;
		
		}
	}else {
		return "Invalid Post";
	}
}
	
	
	
	private String generateRandomString() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(4);

        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(randomIndex));
        }

        return sb.toString();
    }
	
	private String generateRandomId() {
		 Random random = new Random();
		 Integer generatedId= random.nextInt(9000)+1000;
		 return generatedId.toString();
		
	}
}

