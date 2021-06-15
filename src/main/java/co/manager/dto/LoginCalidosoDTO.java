package co.manager.dto;

import java.io.Serializable;

/**
 * @author jguisao
 */
public class LoginCalidosoDTO implements Serializable {
    private String documento;
    private String programa;
    private String mail;
    private String celular;

    public LoginCalidosoDTO() {
    }

    public LoginCalidosoDTO(String documento, String programa, String mail, String celular) {
        this.documento = documento;
        this.programa = programa;
        this.mail = mail;
        this.celular = celular;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "LoginCalidosoDTO{" +
                "documento='" + documento + '\'' +
                ", programa='" + programa + '\'' +
                ", mail='" + mail + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}