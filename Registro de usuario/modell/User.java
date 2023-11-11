package modell;

public class User {

    private String Edad;
    private String Nombre;
    private String Contacto;
    private String Cedula;
    private String Direccion; 
    private String Profesion;
    private String Area_laboral;
    private boolean IsActive;
    
    public User(){
        Nombre = "nn";
        Edad = "nn";
        Cedula = "nn";
        Cedula= "nn";
        Direccion = "nn";
        Profesion = "nn";
        Area_laboral = "nn";
        IsActive = true;
    }

    public User(String Nombre, String Edad, String Contacto, String Cedula , String Direccion, String Profesion, String Area_laboral,boolean IsActive) {
        this.Edad = Edad;
        this.Nombre = Nombre;
        this.Contacto = Contacto;
        this.Cedula = Cedula;
        this.Direccion = Direccion;
        this.Profesion = Profesion;
        this.Area_laboral = Area_laboral;
        this.IsActive = IsActive;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

     public boolean getIsActive() {
        return IsActive;
    }

     public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public void setEdad(String Edad) {
        this.Edad = Edad;
    }

     public String getEdad() {
        return Edad;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }

     public String getContacto() {
        return Contacto;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

     public String getDireccion() {
        return Direccion;
    }

       public String getNombre() {
        return Nombre;
    }

    public void setNombre(String ID) {
        this.Nombre = ID;
    }
    

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setArea_Laboral(String Area_laboral) {
        this.Area_laboral = Area_laboral;
    }

     public String getArea_Laboral() {
        return Area_laboral;
    }

 
    @Override
    public String toString(){
        return "\nNombre" + Nombre + "\nCedula" + Cedula + "\nEdad" + Edad  + "\nProfesion" + Profesion + "\nArea_Laboral" + Area_laboral  + "\nContacto" + Contacto  + "\nDireccion" + Direccion +
         "\nIsActive" + IsActive ;
    }
    public int getTamano(){
        return getNombre().length()*2+2+4+1;
    }

}
