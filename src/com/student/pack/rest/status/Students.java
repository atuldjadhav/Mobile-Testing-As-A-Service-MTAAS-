package com.student.pack.rest.status;

import java.util.Collection;
import java.util.List;

public class Students {
	Collection<Student> students;
	List<Link> links;
	
	public Collection<Student> getStudents() {
		return students;
	}
	public void setStudents(Collection<Student> students) {
		this.students = students;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
	public String getNext() {
		if(links == null) return null;
		for(Link link : links) {
			if("next".equals(link.getRel()))
					return link.getLink();
		}
		return null;
	}
	
	public String getPrevious() {
		if(links == null) return null;
		for(Link link : links) {
			if("previous".equals(link.getRel()))
				return link.getLink();
		}
		return null;
	}
	
	

}
