package com.codingdojo.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoOverflow.models.Tag;
import com.codingdojo.dojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tagRepo;
	
	public Tag addTag(Tag tag) {
		return tagRepo.save(tag);
	}
	public List<Tag> checkForTags(String stringOfTags){
		String[] splitTags = stringOfTags.trim().split(",");
		if(splitTags.length>3) {
			return null;
		}
		ArrayList<Tag> temp = new ArrayList<Tag>();
		for(String x: splitTags) {
			x= x.trim().toLowerCase();
			if(tagRepo.findBySubjectIs(x)==null && x.length()>0) {
				temp.add(new Tag(x));
			}else {
				temp.add(tagRepo.findBySubjectIs(x));
			}
		}
		return temp;
	}
}

