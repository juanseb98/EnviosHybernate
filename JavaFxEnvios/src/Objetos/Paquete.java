package Objetos;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

/**
 *
 * @author Juan Sebastian Gonzalez Sanchez
 */
@Entity
@Table(name = "paquete")
public class Paquete implements Serializable {

    @Id
    @Column(name = "codigo_paquete")
    private int codigo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "destino")
    private String destino;
    
    @Column(name = "entregado")
    @Type(type = "boolean")
    private Boolean entregado;

    @ManyToOne
    @JoinColumn(name = "id_reparto")
    private Reparto reparto;

    public Paquete(int codigo, String descripcion, String destino) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.destino = destino;
        this.entregado = false;
        reparto = null;
    }

    public Paquete(String descripcion, String destino) {
        this.descripcion = descripcion;
        this.destino = destino;
        this.entregado = false;
        reparto = null;
    }

    public Paquete() {
        super();
    }
    public int getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDestino() {
        return destino;
    }

    public Reparto getReparto() {
        return reparto;
    }
    
    public boolean isEntregado() {
        return this.entregado;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

}
