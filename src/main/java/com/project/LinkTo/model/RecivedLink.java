package com.project.LinkTo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecivedLink {
	@JsonProperty(required=true)
	String longLink;
	@JsonProperty(required=false)
	String customString;
	@JsonProperty(required=false)
	boolean randomStringAssignment=false;
	@JsonProperty(required=false)
	boolean randomIdAssignment=false;
	
	@JsonIgnore
	public boolean isValid() {
        int count = 0;

        if (customString != null) {
            count++;
        }

        if (randomStringAssignment) {
            count++;
        }

        if (randomIdAssignment) {
            count++;
        }

        return count == 1;
    }
	
	public void setCustomString(String customString) {this.customString=customString;}
	public void setRadomStringAssignment(boolean radomStringAssignment) {this.randomStringAssignment=radomStringAssignment;}
	public void setRandomIdAssignment(boolean randomIdAssignment) {this.randomIdAssignment=randomIdAssignment;}  

	public String getCustomString() {return this.customString;}
	public boolean getRadomStringAssignment() {return this.randomStringAssignment;}
	public boolean getRandomIdAssignment() {return this.randomIdAssignment;}
	
	public void setLongLink(String longLink) {this.longLink=longLink;}

	public String getLongLink() {return this.longLink;}
	
}
