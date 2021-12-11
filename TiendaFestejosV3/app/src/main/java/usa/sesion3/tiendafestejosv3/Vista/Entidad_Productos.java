package usa.sesion3.tiendafestejosv3.Vista;

public class Entidad_Productos {

    int imagen_productos1;
    String titulo;
    String descripcion;

    public Entidad_Productos(int imagen_productos1, String titulo, String descripcion) {
        this.imagen_productos1 = imagen_productos1;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getImagen_productos1() {
        return imagen_productos1;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
