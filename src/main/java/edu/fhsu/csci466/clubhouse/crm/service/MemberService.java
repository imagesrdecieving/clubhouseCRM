package edu.fhsu.csci466.clubhouse.crm.service;

import java.util.List;

/**
 * @author ss047890
 *
 */
public interface MemberService
{
    /**
     * @param member
     */
    public void addMember( final Member member );

    /**
     * @return member
     */
    public List<Member> getMembers();

    /**
     * @param id
     * @return member
     */
    public Member getMember( Long id );

    /**
     * @param id
     */
    public void delete( Long id );

    /**
     * @param name
     * @return member
     */
    public Member getMembersByName( final String name );

    /**
     * @param accountNumber
     * @return member
     */
    public Member getMembersByAccountNumber( final Long accountNumber );
}