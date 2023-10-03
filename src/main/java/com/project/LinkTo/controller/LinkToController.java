package com.project.LinkTo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.LinkTo.model.LongLink;
import com.project.LinkTo.model.RecivedLink;
import com.project.LinkTo.model.ShortLink;
import com.project.LinkTo.service.LinkToService;

@RestController
@RequestMapping("/")
public class LinkToController {
	
	LinkToService service;
	
	@Autowired
	LinkToController(LinkToService service){
		this.service =service;
	}
	
	@PostMapping("savelink")
	public ResponseEntity<ShortLink> getShortLink(@RequestBody RecivedLink userInput) {
		ShortLink shortId=new ShortLink(service.addToDb(userInput));
		
		return new ResponseEntity<ShortLink>(shortId,HttpStatus.CREATED) ;
	}
	
	
	
	@GetMapping()
	public ResponseEntity<String> getHelp(){
		String help="<html><head><script>window.location.href=\"https://github.com/LakshmanxKumar/LinkTo/blob/master/README.md\"</script></head><body></body></html>";
		return new ResponseEntity<String>(help,HttpStatus.OK) ;
	}
	
	@GetMapping("goto/{id}")
	public ResponseEntity<LongLink> getLongLink(@PathVariable String id){
		LongLink ans= service.findLink(id);
		return new ResponseEntity<LongLink>(ans,HttpStatus.OK);
	}
	
	
		
	
}
