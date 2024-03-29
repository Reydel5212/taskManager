package org.taskManager.repositories.imageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.image.ProfileImageModel;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImageModel, Integer> {
}
