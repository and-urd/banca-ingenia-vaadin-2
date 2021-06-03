//package com.example.application.backend.modelbanca;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="prestamo")
//public class Prestamo {
//
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private Double cantidad;
//
//    private Integer duracion; // en meses
//
//    @ManyToOne
//    @JoinColumn(name="id_cuenta")
//    private Cuenta cuentaIngreso;
//
//
//}
