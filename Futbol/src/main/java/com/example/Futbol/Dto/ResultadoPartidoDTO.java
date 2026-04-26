package com.example.Futbol.Dto;

import java.time.LocalDate;

public class ResultadoPartidoDTO {

    private Long idPartido;
    private LocalDate fecha;
    private String estadio;
    private String equipoLocal;
    private String equipoVisita;
    private Integer golesLocal;
    private Integer golesVisita;

    public ResultadoPartidoDTO() {
    }

    public ResultadoPartidoDTO(Long idPartido, LocalDate fecha, String estadio, String equipoLocal, String equipoVisita, Integer golesLocal, Integer golesVisita) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.equipoLocal = equipoLocal;
        this.equipoVisita = equipoVisita;
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }

    public Long getIdPartido() {
        return idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisita() {
        return equipoVisita;
    }

    public Integer getGolesLocal() {
        return golesLocal;
    }

    public Integer getGolesVisita() {
        return golesVisita;
    }

    @Override
    public String toString() {
        return "ResultadoPártidoDTO{" +
                "idPartido=" + idPartido +
                ", fecha=" + fecha +
                ", estadio='" + estadio + '\'' +
                ", equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisita='" + equipoVisita + '\'' +
                ", golesLocal=" + golesLocal +
                ", golesVisita=" + golesVisita +
                '}';
    }
}
