package org.animmagic.back.repositories;

import org.animmagic.back.entities.FormatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatTypeRepository extends JpaRepository<FormatType, Integer> {

}
