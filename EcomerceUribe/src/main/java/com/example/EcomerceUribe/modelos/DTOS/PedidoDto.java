package com.example.EcomerceUribe.modelos.DTOS;

import java.time.LocalDate;

public class PedidoDto {
    private Integer id;
    private Integer montoTotal;
    private LocalDate fechaCreacion;

    public PedidoDto() {
    }

    public PedidoDto(Integer id, Integer montoTotal, LocalDate fechaCreacion) {
        this.id = id;
        this.montoTotal = montoTotal;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Integer montoTotal) {
        this.montoTotal = montoTotal;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
