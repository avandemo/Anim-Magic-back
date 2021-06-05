package org.animmagic.back.repositories;

import org.animmagic.back.entities.MemberDotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDotationRepository extends JpaRepository<MemberDotation, Integer> {

}
