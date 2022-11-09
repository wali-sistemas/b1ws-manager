package co.manager.dto;

import java.util.List;

/**
 * @author jguisao
 */
public class ClientMechanicDTO {
    private String client;
    private List<MechanicDTO> mechanics;

    public ClientMechanicDTO() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<MechanicDTO> getMechanics() {
        return mechanics;
    }

    public void setMechanics(List<MechanicDTO> mechanics) {
        this.mechanics = mechanics;
    }

    public static class MechanicDTO {
        private Integer nro;
        private String mechanic;
        private String nombre;
        private String correo;
        private String celular;
        private String ciudad;
        private String departamento;

        public Integer getNro() {
            return nro;
        }

        public void setNro(Integer nro) {
            this.nro = nro;
        }

        public String getMechanic() {
            return mechanic;
        }

        public void setMechanic(String mechanic) {
            this.mechanic = mechanic;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public String getDepartamento() {
            return departamento;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

        @Override
        public String toString() {
            return "MechanicDTO{" +
                    "nro=" + nro +
                    ", mechanic='" + mechanic + '\'' +
                    ", nombre='" + nombre + '\'' +
                    ", correo='" + correo + '\'' +
                    ", celular='" + celular + '\'' +
                    ", ciudad='" + ciudad + '\'' +
                    ", departamento='" + departamento + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ClientMechanicDTO{" +
                "client='" + client + '\'' +
                ", mechanics=" + mechanics +
                '}';
    }
}