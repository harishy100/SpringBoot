package io.egen.api.service;



import java.util.Optional;

import io.egen.api.entity.Actor;

public interface ActorService {
	public Optional<Actor> findByActorName(String actorname);
	public Actor createActor(Actor actor);
}
