package org.taskManager.repositories.imageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.taskManager.models.image.ProfileImage;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
}
