package com.project.LinkTo.model;

public class ShortLink {
    String redirectLink;
    String shortId;
    public String getShortId(){return this.shortId;}
    public void setShortId(String shortId){this.shortId=shortId;}

    public String getRedirectLink() {
        return redirectLink;
    }
    public void setRedirectLink(String redirectLink) {
        this.redirectLink = redirectLink;
    }

    public ShortLink(){}
    public ShortLink(String link){
        this.shortId=link;
        this.redirectLink= "https://linkto.onrender.com/goto/"+link;
    }



}
