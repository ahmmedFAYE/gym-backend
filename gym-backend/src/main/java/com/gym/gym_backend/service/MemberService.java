package com.gym.gym_backend.service;

import com.gym.gym_backend.entity.Member;

import java.util.List;

public interface MemberService {
    // Créer un membre
    Member createMember(Member member);

    // Recupérer la liste de tous les membres
    List<Member> getAllMembers();

    // Rechercher 1 membre par son id
    Member getMemberById(Long id);

    // Supprimer 1 membre
    void deleteMember(Long id);

    // Mis à jour d'un membre existant identifié par son id
    Member updateMember(Long id, Member memberDetails);

}
