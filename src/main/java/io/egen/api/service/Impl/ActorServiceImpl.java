package io.egen.api.service.Impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.Actor;
import io.egen.api.repository.ActorRepository;
import io.egen.api.service.ActorService;

@Service
@Transactional
public class ActorServiceImpl implements ActorService {

	@Autowired
	ActorRepository repository;
	
	@Override
	public Optional<Actor> findByActorName(String actorname) {
		Optional<Actor> actor= repository.findByActorName(actorname);
		return actor;
		
	}

	@Override
	public Actor createActor(Actor actor) {

		return repository.save(actor);
	}

}
