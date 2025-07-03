package co.manager.persistence.entity;

import org.exolab.castor.types.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author jguisao
 */
@Entity
@Table(name = "chatbot_ia_app")
public class ChatbotAPP {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPrompt")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slpCode")
    private String slpCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "slpName")
    private String slpName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prompt")
    private String prompt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "response")
    private String response;

    public ChatbotAPP() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
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
        if (!(object instanceof ChatbotAPP)) {
            return false;
        }
        ChatbotAPP other = (ChatbotAPP) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "ChatbotAPP{" +
                "id=" + id +
                ", slpCode='" + slpCode + '\'' +
                ", slpName='" + slpName + '\'' +
                ", createDate=" + createDate +
                ", companyName='" + companyName + '\'' +
                ", prompt='" + prompt + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}