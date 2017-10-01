package edu.fhsu.csci466.clubhouse.crm.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import edu.fhsu.csci466.clubhouse.crm.model.groups.MemberFamilyRel;
import edu.fhsu.csci466.clubhouse.crm.model.groups.MemberTeamRel;
import edu.fhsu.csci466.clubhouse.crm.model.services.Account;
import edu.fhsu.csci466.clubhouse.crm.model.services.Credential;
import edu.fhsu.csci466.clubhouse.crm.model.services.MemberEventRel;
import edu.fhsu.csci466.clubhouse.crm.model.services.PaymentPlan;

/**
 * @author ss047890
 *
 *         Entity class representing a CRM member.
 */
@Entity
public class Member implements Serializable
{

    /**
     * 
     */
    private static final long    serialVersionUID = 4926978862891959688L;

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    @Column( name = "id", unique = true )
    private Long                 id;

    private String               email;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "credential_id" )
    private Credential           credential;

    @OneToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "account_id" )
    private Account              account;

    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn( name = "payment_plan_id" )
    private PaymentPlan          paymentPlan;

    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.REMOVE )
    @JoinColumn( name = "member_family_id" )
    private Set<MemberFamilyRel> memberFamilyRels = new HashSet<>();

    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.REMOVE )
    @JoinColumn( name = "team_id" )
    private Set<MemberTeamRel>   memberTeamRels   = new HashSet<>();

    @ManyToMany( fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.REMOVE )
    @JoinColumn( name = "event_id" )
    private Set<MemberEventRel>  memberEventRels  = new HashSet<>();

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId( Long id )
    {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail( String email )
    {
        this.email = email;
    }

    /**
     * @return the credential
     */
    public Credential getCredential()
    {
        return credential;
    }

    /**
     * @param credential the credential to set
     */
    public void setCredential( Credential credential )
    {
        this.credential = credential;
    }

    /**
     * @return the account
     */
    public Account getAccount()
    {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount( Account account )
    {
        this.account = account;
    }

    /**
     * @return the paymentPlan
     */
    public PaymentPlan getPaymentPlan()
    {
        return paymentPlan;
    }

    /**
     * @param paymentPlan the paymentPlan to set
     */
    public void setPaymentPlan( PaymentPlan paymentPlan )
    {
        this.paymentPlan = paymentPlan;
    }

    /**
     * @return the memberFamilyRels
     */
    public Set<MemberFamilyRel> getMemberFamilyRels()
    {
        return memberFamilyRels;
    }

    /**
     * @param memberFamilyRels the memberFamilyRels to set
     */
    public void setMemberFamilyRels( Set<MemberFamilyRel> memberFamilyRels )
    {
        this.memberFamilyRels = memberFamilyRels;
    }

    /**
     * @return the memberTeamRels
     */
    public Set<MemberTeamRel> getMemberTeamRels()
    {
        return memberTeamRels;
    }

    /**
     * @param memberTeamRels the memberTeamRels to set
     */
    public void setMemberTeamRels( Set<MemberTeamRel> memberTeamRels )
    {
        this.memberTeamRels = memberTeamRels;
    }

    /**
     * @return the memberEventRels
     */
    public Set<MemberEventRel> getMemberEventRels()
    {
        return memberEventRels;
    }

    /**
     * @param memberEventRels the memberEventRels to set
     */
    public void setMemberEventRels( Set<MemberEventRel> memberEventRels )
    {
        this.memberEventRels = memberEventRels;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 19890919;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((credential == null) ? 0 : credential.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((memberEventRels == null) ? 0 : memberEventRels.hashCode());
        result = prime * result + ((memberFamilyRels == null) ? 0 : memberFamilyRels.hashCode());
        result = prime * result + ((memberTeamRels == null) ? 0 : memberTeamRels.hashCode());
        result = prime * result + ((paymentPlan == null) ? 0 : paymentPlan.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Member other = (Member) obj;
        if ( account == null )
        {
            if ( other.account != null )
                return false;
        }
        else if ( !account.equals( other.account ) )
            return false;
        if ( credential == null )
        {
            if ( other.credential != null )
                return false;
        }
        else if ( !credential.equals( other.credential ) )
            return false;
        if ( email == null )
        {
            if ( other.email != null )
                return false;
        }
        else if ( !email.equals( other.email ) )
            return false;
        if ( id == null )
        {
            if ( other.id != null )
                return false;
        }
        else if ( !id.equals( other.id ) )
            return false;
        if ( memberEventRels == null )
        {
            if ( other.memberEventRels != null )
                return false;
        }
        else if ( !memberEventRels.equals( other.memberEventRels ) )
            return false;
        if ( memberFamilyRels == null )
        {
            if ( other.memberFamilyRels != null )
                return false;
        }
        else if ( !memberFamilyRels.equals( other.memberFamilyRels ) )
            return false;
        if ( memberTeamRels == null )
        {
            if ( other.memberTeamRels != null )
                return false;
        }
        else if ( !memberTeamRels.equals( other.memberTeamRels ) )
            return false;
        if ( paymentPlan == null )
        {
            if ( other.paymentPlan != null )
                return false;
        }
        else if ( !paymentPlan.equals( other.paymentPlan ) )
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Member [id=" + id + ", email=" + email + ", credential=" + credential + ", account=" + account
                        + ", paymentPlan=" + paymentPlan + ", memberFamilyRels=" + memberFamilyRels
                        + ", memberTeamRels=" + memberTeamRels + ", memberEventRels=" + memberEventRels + "]";
    }
}
