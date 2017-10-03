package edu.fhsu.csci466.clubhouse.crm.service.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author ss047890
 *
 *
 */
@Entity
@DiscriminatorValue("LEADER")
public class Leader extends Member
{
    /**
     *
     */
    private static final long serialVersionUID = -1853417858470664394L;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Leader [" + super.toString() + "]";
    }
}
