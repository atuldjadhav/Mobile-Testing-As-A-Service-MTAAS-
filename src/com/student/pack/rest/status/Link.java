package com.student.pack.rest.status;

public class Link {

	String link;
	String rel;
	String type;
	
	
	public Link() {
		
	}
	
	public Link(String link,String rel,String typ) {
		this.link = link;
		this.rel = rel;
		this.type = typ;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
