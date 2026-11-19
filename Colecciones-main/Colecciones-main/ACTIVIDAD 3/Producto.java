package Actividad_3;

public class Producto {
    private String codigo;
    private String descripcion;

    public Producto(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto p = (Producto) o;
        return codigo != null && codigo.equals(p.codigo);
    }

    @Override
    public int hashCode() {
        return codigo == null ? 0 : codigo.hashCode();
    }

    @Override
    public String toString() {
        return "Producto{codigo=" + codigo + ", descripcion=" + descripcion + "}";
    }
}