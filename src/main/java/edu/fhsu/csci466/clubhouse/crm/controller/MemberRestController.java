package edu.fhsu.csci466.clubhouse.crm.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.fhsu.csci466.clubhouse.crm.service.MemberService;
import edu.fhsu.csci466.clubhouse.crm.service.model.EntityList;
import edu.fhsu.csci466.clubhouse.crm.service.model.Member;

/**
 * @author ss047890
 *
 */
@RestController
@RequestMapping( "/crm" )
public class MemberRestController
{
    @Autowired
    MemberService service;

    /**
     * @param lastName
     * @return list of all member
     */
    @GetMapping( value = "/member", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<EntityList<Member>> getMembers()
    {
        EntityList<Member> list = new EntityList<> ( service.getMembers() );
        for ( Member member : list.getEntities() )
        {
            member.add( linkTo(methodOn(MemberRestController.class).getMember(member.getMemberId())).withSelfRel() );
        }
        list.add( linkTo(methodOn(MemberRestController.class).getMembers()).withRel("list") );
        list.add( linkTo(methodOn(MemberRestController.class).addMember(null)).withRel("add") );
        return new ResponseEntity<>( list, HttpStatus.OK );
    }

    /**
     * @param member
     * @return response entity the status to return
     */
    @PostMapping( value = "/member/add", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Member> addMember( @RequestBody Member member )
    {
        service.addMember( member );
        return new ResponseEntity<>( member, HttpStatus.OK );
    }

    /**
     * @param id
     * @return member
     */
    @GetMapping( value = "/member/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
    public HttpEntity<Member> getMember( @PathVariable Long id )
    {
        Member member = service.getMember( id );
        member.add( linkTo(methodOn(MemberRestController.class).getMember(id)).withSelfRel() );
        return new ResponseEntity<>( member, HttpStatus.OK );
    }
}
