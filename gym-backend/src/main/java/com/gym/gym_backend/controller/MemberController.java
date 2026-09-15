package com.gym.gym_backend.controller;

import com.gym.gym_backend.entity.Member;
import com.gym.gym_backend.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List; 

@RestController
@RequestMapping("/members")
@CrossOrigin("http://localhost:4200")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }   

    // Créer un membre : donc Post
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member createdMember = memberService.createMember(member);
        return new ResponseEntity<>(createdMember, HttpStatus.CREATED);
        // status : 201 CREATED
    }

    // Recupérer la liste de tous les membres
    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
        // code 200 Ok
    }

    // Recupérer un user par son id
    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id){
        Member member = memberService.getMemberById(id);
        return ResponseEntity.ok(member);
    }

    // Supprimer un utulisateur
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Membre supprimé avec succés !");
    }

    // Modifier un user
    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member detailsMember){
        Member updatedMember = memberService.updateMember(id, detailsMember);
        return ResponseEntity.ok(updatedMember);
    }
}
