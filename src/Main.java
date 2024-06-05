import controller.Controlador;
import view.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        VentanaPrincipal inicio = new VentanaPrincipal(controlador);
    }
}

