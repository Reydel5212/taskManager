package org.taskManager.repositories.objectRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.object.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer> {
}
