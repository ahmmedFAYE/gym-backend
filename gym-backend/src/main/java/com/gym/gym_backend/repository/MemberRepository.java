package com.gym.gym_backend.repository;

import com.gym.gym_backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    // Recherche un membre par son email et l'enveloppe dans un Optional pour
    // éviter tout risque de NullPointerException si aucun membre n'est trouvé.
    Optional<Member> findByEmail(String email);
}
