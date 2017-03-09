package io.egen.api.service.Impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Rating;
import io.egen.api.repository.*;
import io.egen.api.service.RatingService;
@Service
@Transactional
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository repository;
	private List<Integer> intg;
	@Override
	public float getmovierating(String id) {
		List<Rating> rtg=repository.findByMveId(id);
		if(rtg==null){
			return 0;
		}
		else{
			for (Rating result : rtg) {
			    intg.add(result.getRating());
			}
		return this.average(intg);
		}
	
	}
	public float average(List<Integer> list) {
	    
	    if (list == null || list.isEmpty())
	        return 0;
	    long sum = 0;
	    int n = list.size();
	    for (int i = 0; i < n; i++)
	        sum += list.get(i);
	    return (float) ((sum) / n);
	}

	@Override
	public Rating insertrating(Rating rtg) {
		Rating rtg1=repository.findByMveAndUsr(rtg.getMve(),rtg.getUsr());
		System.err.println("Done with checking"+ rtg1);
		if(rtg1!=null){
			return repository.save(rtg);
		}
		else{
				return repository.save(rtg);
		}
		
	}

}

