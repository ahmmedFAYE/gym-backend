package com.gym.gym_backend.service;

import com.gym.gym_backend.entity.Member;
import com.gym.gym_backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    // la variable de la dépendnace à MemberRepository
    private final MemberRepository memberRepository;

    // Injetction de la dépendance MemberRepository
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public Member createMember(Member member){
        if(memberRepository.findByEmail(member.getEmail()).isPresent()){
            throw new RuntimeException("Un membre avec cet eamil existe deja !");
        }
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembers(){
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membre introuvable avec l'id: "+id));
    }

    @Override
    public void deleteMember(Long id){
        Member member = getMemberById(id);
        memberRepository.delete(member);
    }

    @Override
    public Member updateMember(Long id, Member memberDetails){
        // on vérifie d'abord si le user existe dans la base :
        Member existingMember = getMemberById(id);

        // On modifie les champs autorisés:
        // firstName, lastName, phoneNumber, et email
        existingMember.setFirstName(memberDetails.getFirstName());
        existingMember.setLastName(memberDetails.getFirstName());
        existingMember.setPhoneNumber(memberDetails.getPhoneNumber());

        // Pour l'email
        // Vérifier en amont si l'email existant n'est pas égal à l'email mis à jour
        // puis vérifier si l'email existe en base ou pas
        if(!existingMember.getEmail().equals(memberDetails.getEmail())){
            if(memberRepository.findByEmail(memberDetails.getEmail()).isPresent()){
                throw new RuntimeException("Un membre avec cet email existe deja en base");
            }
            existingMember.setEmail(memberDetails.getEmail());
        }
        return memberRepository.save(existingMember);
    }

}
