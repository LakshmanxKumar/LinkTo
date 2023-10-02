package com.project.LinkTo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="LinkTo")
public class LongLink {
	@Id
	String id;
	
	String longLink;
	public LongLink(String id,String longLink){
		this.id=id;
		this.longLink=longLink;
	}
	
	public void setId(String id) {this.id=id;}
	public void setLongLink(String longLink) {this.longLink=longLink;}

	public String getId() {return this.id;}
	public String getLongLink() {return this.longLink;}
}
