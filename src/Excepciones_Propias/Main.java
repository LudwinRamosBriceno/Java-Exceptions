package Excepciones_Propias;

public class Main {

    // Ejemplo 1: se lanzará una excepción si num1 o num2 son enteros menores que cero
    public void suma(int num1,int num2)  {
        try {
            verificar(num1,num2);
            int sumaDouble =  num1+ num2;
            System.out.println(sumaDouble);
        }catch (CreateExceptions ex){
            System.out.println("Excepción: "+ex.getMessage());
        }
    }

    // verifica si num1 o num2 son menores que cero
    private void verificar (int num1,int num2)throws CreateExceptions{
        if (num1 <0 || num2<0){
            throw new CreateExceptions("Verifique que su parámetro esté correcto");
        }
    }

    // Ejemplo 2: se lanazará una excepción si los parámetros están vacíos
    public void convert(String a, String b){
        try {
            System.out.println(resta(a,b));
        }catch (CreateExceptions ex){
            System.out.println(ex.getMessage());
        }
    }
    // Realiza la operación
    private Double resta (String a,String b) throws CreateExceptions{
        Double suma = 0.0;
        if (a.equals("") || b.equals("")){
            throw new CreateExceptions("No se puede operar sin números");
        }else{
            Double var1 = Double.parseDouble(a);
            Double var2 = Double.parseDouble(b);
            suma = var1 + var2;
            return suma;
        }
    }

    public static void main(String[] args) {
        Main p = new Main();
        p.suma(-7,1); // los parámetros deben ser mayor que cero, sino se lanzará una excepción
        p.convert("","1"); // Las cadenas no pueden ir vacías
    }
}
