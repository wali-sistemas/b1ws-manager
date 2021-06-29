package co.manager.dto;

import java.util.List;

/**
 * @author jguisao
 */
public class ClientVendMortradorDTO {
    private String client;
    private List<VendMostradorDTO> vendedoresMostrador;

    public ClientVendMortradorDTO() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<VendMostradorDTO> getVendedoresMostrador() {
        return vendedoresMostrador;
    }

    public void setVendedoresMostrador(List<VendMostradorDTO> vendedoresMostrador) {
        this.vendedoresMostrador = vendedoresMostrador;
    }

    public static class VendMostradorDTO {
        private Integer nro;
        private String vendMostrador;
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

        public String getVendMostrador() {
            return vendMostrador;
        }

        public void setVendMostrador(String vendMostrador) {
            this.vendMostrador = vendMostrador;
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
            return "VendMostradorDTO{" +
                    "nro=" + nro +
                    ", vendMostrador='" + vendMostrador + '\'' +
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
        return "ClientVendMortradorDTO{" +
                "client='" + client + '\'' +
                ", vendedoresMostrador=" + vendedoresMostrador +
                '}';
    }
}