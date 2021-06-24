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

        @Override
        public String toString() {
            return "VendMostradorDTO{" +
                    "nro=" + nro +
                    ", vendMostrador='" + vendMostrador + '\'' +
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