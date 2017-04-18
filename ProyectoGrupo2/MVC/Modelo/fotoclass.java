package Modelo;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Modelo.ClaseConection;


public class fotoclass {

   private  ClaseConection con = new ClaseConection();
    private Image data =null;
    private String sql=null;
    
    public fotoclass(String sql) {
    this.sql=sql;    
    }
    //metodo que dada una cadena de bytes la convierte en una imagen con extension jpg
  
  private Image ConvertirImagen(byte[] bytes) throws IOException {
	  
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; // File or InputStream
        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
   
		  return reader.read(0, param);
	
    }
   
    //METODO PARA RECUPERAR LA IMAGEN DE LA BASE DE DATOS
    public Image recuperarfotos() {
    	;

        try {
           con.GetConexion("1323027");
           byte[] b=null;
            ResultSet res = con.GetDatos(sql);
            int i = 0;
                while (res.next()) {
                    // se lee la cadena de bytes de la base de datos
                    b = res.getBytes("imag");
                    //esta cadena de bytes sera convertida en una imagen
                                      
                    i++;
                }
                if(i!=0){
                	  data = ConvertirImagen(b);	
                }
                
            res.close();
            con.SetCloseConexion();
        } catch (IOException | SQLException ex) {
        	System.out.println("error");
         }
        return data;

    }
    public void cargarfoto(JLabel ima) {
		
		
        Image dtCat = recuperarfotos();
       
        //Se coloca el nuevo icono modificado
        if (dtCat == null) {
        	JOptionPane.showMessageDialog(null,	"No hay foto",  "Mensaje Informativo", JOptionPane.INFORMATION_MESSAGE);

        } else {
        	 ImageIcon icon = new ImageIcon(dtCat);
             //Se extrae la imagen del icono
             Image img = icon.getImage();
             //Se modifica su tamaño
             Image newimg = img.getScaledInstance(155, 180, java.awt.Image.SCALE_SMOOTH);
             //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
             ImageIcon newIcon = new ImageIcon(newimg);
        	Icon icono = new ImageIcon(newIcon.getImage().getScaledInstance(ima.getWidth(), ima.getHeight(), Image.SCALE_DEFAULT));
        	ima.setIcon(icono); 
        }
    }
}
