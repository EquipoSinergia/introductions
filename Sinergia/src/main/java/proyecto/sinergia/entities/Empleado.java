package proyecto.sinergia.entities;

public class Empleado {
    //Atributos
    private int id;
    private String nombre;
    private String correo;
    private String empresa;
    private String rol;

    //constructor

    public Empleado(int id, String nombre, String correo, String empresa, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    //getter and setter
    public int getId(){
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getCorreo(){
        return  this.correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getRol(){
        return  this.rol;
    }
    public void setRol(String rol){
        this.rol=rol;
    }

    public String getEmpresa(){
        return  this.empresa;
    }
    public void setEmpresa(){
        this.empresa=empresa;
    }
}
