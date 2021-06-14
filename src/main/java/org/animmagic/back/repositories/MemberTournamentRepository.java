package org.animmagic.back.repositories;

import org.animmagic.back.entities.MemberTournament;
import org.animmagic.back.entities.MemberTournamentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberTournamentRepository extends JpaRepository<MemberTournament, MemberTournamentPK> {

}
