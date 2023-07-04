package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "custody_detail")
public class CustodyDetail implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "idCustodia", nullable = false)
    private String idCustodia;

    @Basic(optional = false)
    @Column(name = "cardName", nullable = false)
    private String cardName;

}
