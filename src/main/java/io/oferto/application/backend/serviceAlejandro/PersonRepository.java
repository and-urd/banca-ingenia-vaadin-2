package io.oferto.application.backend.serviceAlejandro;


import io.oferto.application.backend.modelbanca.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}