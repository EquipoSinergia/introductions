package AplicativoWeb;

public class Empleado {

        //Atributos
        int id;
        String nombre, perfil,rol,empresa;

        //constructor
    public Empleado(int id,String nombre,String perfil,String rol,String empresa){
        id=this.id;
        nombre=this.nombre;
        perfil=this.perfil;
        rol=this.rol;
        empresa=this.empresa;
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
    public String getPerfil(){
        return  this.perfil;
    }
    public void setPerfil(String perfil){
        this.perfil=perfil;
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
