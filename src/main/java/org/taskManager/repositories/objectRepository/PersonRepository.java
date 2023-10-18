package org.taskManager.repositories.objectRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

import org.taskManager.models.object.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);

    @Query(value = "select * from second_db.public.person where person_id != 0", nativeQuery = true)
    List<Person> findAllExecutorsWithoutZero();

}
