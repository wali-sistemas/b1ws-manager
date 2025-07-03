package co.manager.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
@Entity
@Table(name = "asociados")
public class AssociatedFEMPRO implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aso")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_aso")
    private String codAso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nom_aso")
    private String nomAso;
    @Basic(optional = false)
    @Column(name = "ap1_aso")
    private String ap1Aso;
    @Basic(optional = false)
    @Column(name = "ap2_aso")
    private String ap2Aso;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fec_nac")
    private Date fecNac;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fec_ing")
    private Date fecIng;
    @Basic(optional = false)
    @Column(name = "nom_emp")
    private String nomEmp;
    @Basic(optional = false)
    @Column(name = "nom_car")
    private String nomCar;
    @Basic(optional = false)
    @Column(name = "sal_bas")
    private BigDecimal salBas;
    @Basic(optional = false)
    @Column(name = "ing_pre")
    private BigDecimal ingPre;
    @Basic(optional = false)
    @Column(name = "ing_nopre")
    private BigDecimal ingNoPre;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fec_afi")
    private Date fecAfi;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    @Column(name = "fec_ret")
    private Date fecRet;
    @Basic(optional = false)
    @Column(name = "est_aso")
    private String estAso;
    @Basic(optional = false)
    @Column(name = "dir_res")
    private String dirRes;
    @Basic(optional = false)
    @Column(name = "nom_bar")
    private String nomBar;
    @Basic(optional = false)
    @Column(name = "tel_cel")
    private String telCel;
    @Basic(optional = false)
    @Column(name = "e_mail")
    private String email;
    @Basic(optional = false)
    @Column(name = "est_civil")
    private String estCivil;
    @Basic(optional = false)
    @Column(name = "cta_tipo")
    private String ctaTipo;
    @Basic(optional = false)
    @Column(name = "cta_ban")
    private String ctaBan;
    @Basic(optional = false)
    @Column(name = "fdo_ban")
    private String fdoBan;
    @Basic(optional = false)
    @Column(name = "ap_mes")
    private BigDecimal apMes;
    @Basic(optional = false)
    @Column(name = "ap_per1")
    private boolean apPer1;
    @Basic(optional = false)
    @Column(name = "ap_per2")
    private boolean apPer2;
    @Basic(optional = false)
    @Column(name = "cod_ben1")
    private String codBen1;
    @Basic(optional = false)
    @Column(name = "nom_ben1")
    private String nomBen1;
    @Basic(optional = false)
    @Column(name = "par_ben1")
    private String parBen1;
    @Basic(optional = false)
    @Column(name = "cod_ben2")
    private String codBen2;
    @Basic(optional = false)
    @Column(name = "nom_ben2")
    private String nomBen2;
    @Basic(optional = false)
    @Column(name = "par_ben2")
    private String parBen2;

    public AssociatedFEMPRO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodAso() {
        return codAso;
    }

    public void setCodAso(String codAso) {
        this.codAso = codAso;
    }

    public String getNomAso() {
        return nomAso;
    }

    public void setNomAso(String nomAso) {
        this.nomAso = nomAso;
    }

    public String getAp1Aso() {
        return ap1Aso;
    }

    public void setAp1Aso(String ap1Aso) {
        this.ap1Aso = ap1Aso;
    }

    public String getAp2Aso() {
        return ap2Aso;
    }

    public void setAp2Aso(String ap2Aso) {
        this.ap2Aso = ap2Aso;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public Date getFecIng() {
        return fecIng;
    }

    public void setFecIng(Date fecIng) {
        this.fecIng = fecIng;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public String getNomCar() {
        return nomCar;
    }

    public void setNomCar(String nomCar) {
        this.nomCar = nomCar;
    }

    public BigDecimal getSalBas() {
        return salBas;
    }

    public void setSalBas(BigDecimal salBas) {
        this.salBas = salBas;
    }

    public BigDecimal getIngPre() {
        return ingPre;
    }

    public void setIngPre(BigDecimal ingPre) {
        this.ingPre = ingPre;
    }

    public BigDecimal getIngNoPre() {
        return ingNoPre;
    }

    public void setIngNoPre(BigDecimal ingNoPre) {
        this.ingNoPre = ingNoPre;
    }

    public Date getFecAfi() {
        return fecAfi;
    }

    public void setFecAfi(Date fecAfi) {
        this.fecAfi = fecAfi;
    }

    public Date getFecRet() {
        return fecRet;
    }

    public void setFecRet(Date fecRet) {
        this.fecRet = fecRet;
    }

    public String getEstAso() {
        return estAso;
    }

    public void setEstAso(String estAso) {
        this.estAso = estAso;
    }

    public String getDirRes() {
        return dirRes;
    }

    public void setDirRes(String dirRes) {
        this.dirRes = dirRes;
    }

    public String getNomBar() {
        return nomBar;
    }

    public void setNomBar(String nomBar) {
        this.nomBar = nomBar;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    public String getCtaTipo() {
        return ctaTipo;
    }

    public void setCtaTipo(String ctaTipo) {
        this.ctaTipo = ctaTipo;
    }

    public String getCtaBan() {
        return ctaBan;
    }

    public void setCtaBan(String ctaBan) {
        this.ctaBan = ctaBan;
    }

    public String getFdoBan() {
        return fdoBan;
    }

    public void setFdoBan(String fdoBan) {
        this.fdoBan = fdoBan;
    }

    public BigDecimal getApMes() {
        return apMes;
    }

    public void setApMes(BigDecimal apMes) {
        this.apMes = apMes;
    }

    public boolean isApPer1() {
        return apPer1;
    }

    public void setApPer1(boolean apPer1) {
        this.apPer1 = apPer1;
    }

    public boolean isApPer2() {
        return apPer2;
    }

    public void setApPer2(boolean apPer2) {
        this.apPer2 = apPer2;
    }

    public String getCodBen1() {
        return codBen1;
    }

    public void setCodBen1(String codBen1) {
        this.codBen1 = codBen1;
    }

    public String getNomBen1() {
        return nomBen1;
    }

    public void setNomBen1(String nomBen1) {
        this.nomBen1 = nomBen1;
    }

    public String getParBen1() {
        return parBen1;
    }

    public void setParBen1(String parBen1) {
        this.parBen1 = parBen1;
    }

    public String getCodBen2() {
        return codBen2;
    }

    public void setCodBen2(String codBen2) {
        this.codBen2 = codBen2;
    }

    public String getNomBen2() {
        return nomBen2;
    }

    public void setNomBen2(String nomBen2) {
        this.nomBen2 = nomBen2;
    }

    public String getParBen2() {
        return parBen2;
    }

    public void setParBen2(String parBen2) {
        this.parBen2 = parBen2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AssociatedFEMPRO)) {
            return false;
        }
        AssociatedFEMPRO other = (AssociatedFEMPRO) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "AssociatedFEMPRO{" +
                "id=" + id +
                ", codAso='" + codAso + '\'' +
                ", nomAso='" + nomAso + '\'' +
                ", ap1Aso='" + ap1Aso + '\'' +
                ", ap2Aso='" + ap2Aso + '\'' +
                ", fecNac=" + fecNac +
                ", fecIng=" + fecIng +
                ", nomEmp='" + nomEmp + '\'' +
                ", nomCar='" + nomCar + '\'' +
                ", salBas=" + salBas +
                ", ingPre=" + ingPre +
                ", ingNoPre=" + ingNoPre +
                ", fecAfi=" + fecAfi +
                ", fecRet=" + fecRet +
                ", estAso=" + estAso +
                ", dirRes='" + dirRes + '\'' +
                ", nomBar='" + nomBar + '\'' +
                ", telCel='" + telCel + '\'' +
                ", email='" + email + '\'' +
                ", estCivil='" + estCivil + '\'' +
                ", ctaTipo='" + ctaTipo + '\'' +
                ", ctaBan='" + ctaBan + '\'' +
                ", fdoBan='" + fdoBan + '\'' +
                ", apMes=" + apMes +
                ", apPer1=" + apPer1 +
                ", apPer2=" + apPer2 +
                ", codBen1='" + codBen1 + '\'' +
                ", nomBen1='" + nomBen1 + '\'' +
                ", parBen1='" + parBen1 + '\'' +
                ", codBen2='" + codBen2 + '\'' +
                ", nomBen2='" + nomBen2 + '\'' +
                ", parBen2='" + parBen2 + '\'' +
                '}';
    }
}