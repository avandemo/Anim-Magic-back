package org.animmagic.back.repositories;

import org.animmagic.back.entities.DotationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DotationTypeRepository extends JpaRepository<DotationType, Integer> {

}
