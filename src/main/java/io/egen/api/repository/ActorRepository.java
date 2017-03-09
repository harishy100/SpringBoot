package io.egen.api.repository;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import io.egen.api.entity.Actor;
public interface ActorRepository extends Repository<Actor,String> {
	public Actor save(Actor actor);
	public Optional<Actor> findByActorName(String actorname);
}
