package usa.sesion3.tiendafestejosv3.Vista;

public class Servicios {
    private String name;
    private byte[] image;

    public Servicios(String name, byte[] image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
