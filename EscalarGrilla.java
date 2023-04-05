import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EscalarGrilla extends JPanel {

  public static void main(String[] args) {
    JFrame ventana = new JFrame("Escalar Grilla");
    ventana.getContentPane().add(new EscalarGrilla());
    ventana.setSize(60, 60);
    ventana.setVisible(true);
  }

  public void paint(Graphics g) {
    int ancho = 10; // ancho de cada cuadrado en la grilla original
    int alto = 10; // alto de cada cuadrado en la grilla original
    int centroX = 1; // posición x del cuadrado central en la grilla original
    int centroY = 1; // posición y del cuadrado central en la grilla original
    int escala = 5; // factor de escala

    // crear una imagen que contenga la grilla original
    BufferedImage imgOriginal = new BufferedImage(3 * ancho, 3 * alto, BufferedImage.TYPE_INT_RGB);
    Graphics gOriginal = imgOriginal.getGraphics();
    gOriginal.drawRect(0, 0, ancho, alto); // dibujar el cuadrado superior izquierdo
    gOriginal.drawRect(ancho, 0, ancho, alto); // dibujar el cuadrado superior medio
    gOriginal.drawRect(2 * ancho, 0, ancho, alto); // dibujar el cuadrado superior derecho
    gOriginal.drawRect(0, alto, ancho, alto); // dibujar el cuadrado medio izquierdo
    gOriginal.fillRect(ancho, alto, ancho, alto); // dibujar el cuadrado central
    gOriginal.drawRect(2 * ancho, alto, ancho, alto); // dibujar el cuadrado medio derecho
    gOriginal.drawRect(0, 2 * alto, ancho, alto); // dibujar el cuadrado inferior izquierdo
    gOriginal.drawRect(ancho, 2 * alto, ancho, alto); // dibujar el cuadrado inferior medio
    gOriginal.drawRect(2 * ancho, 2 * alto, ancho, alto); // dibujar el cuadrado inferior derecho

    // dibujar la imagen escalada en el objeto Graphics actual
    g.drawImage(imgOriginal.getScaledInstance(ancho * escala * 3, alto * escala * 3, BufferedImage.SCALE_DEFAULT),
                (centroX * ancho * escala) - (ancho * escala / 2),
                (centroY * alto * escala) - (alto * escala / 2), null);
  }
}