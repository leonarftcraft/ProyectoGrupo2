package Modelo;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;
import Modelo.fotoclass;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CarruselDeImagenes {
private ImageIcon imag1;
private ImageIcon imag2;
private ImageIcon imag3;
private ImageIcon imag4;
private ImageIcon imag5;
private JLabel carrusel;

public ImageIcon getImag1() {
	return imag1;
}

public ImageIcon getImag2() {
	return imag2;
}

public ImageIcon getImag3() {
	return imag3;
}

public ImageIcon getImag4() {
	return imag4;
}

public ImageIcon getImag5() {
	return imag5;
}




private int identificador=0;//que imagen esta activa
private Timer tiempo =new Timer();
private int velocida=7; //segundos


public CarruselDeImagenes(JLabel carrusel) {
	
	this.carrusel = carrusel;
}

public void cargarImagenes(){
	Image im = null;
	for(int q=1; q<=5;q++){
		String sql= "select imag from carru where id ='"+q+"'";
		fotoclass fo = new fotoclass(sql);
		im = fo.recuperarfotos();
		
		if(q==1){
			imag1 = new ImageIcon(im);
		}
		if(q==2){
			imag2 = new ImageIcon(im);
		}
		if(q==3){
			imag3 = new ImageIcon(im);
		}
		if(q==4){
			imag4 = new ImageIcon(im);
		}
		if(q==5){
			imag5 = new ImageIcon(im);
		}
		
	}
	
}


private TimerTask tarea = new TimerTask() {
	
	@Override
	public void run() {
		cargarImagenes();
		Icon ico;
		switch (identificador) {
		case 0:
			identificador=1;
		
		ico = new ImageIcon(imag1.getImage().getScaledInstance(carrusel.getWidth(), carrusel.getHeight(), Image.SCALE_DEFAULT));
		carrusel.setIcon(ico);
			break;
		case 1:
			identificador=2;
			
			ico = new ImageIcon(imag2.getImage().getScaledInstance(carrusel.getWidth(), carrusel.getHeight(), Image.SCALE_DEFAULT));
			carrusel.setIcon(ico);
			break;
		case 2:
			identificador=3;
			
			ico = new ImageIcon(imag3.getImage().getScaledInstance(carrusel.getWidth(), carrusel.getHeight(), Image.SCALE_DEFAULT));
			carrusel.setIcon(ico);	
			break;
		case 3:
			identificador=4;
		
			ico = new ImageIcon(imag4.getImage().getScaledInstance(carrusel.getWidth(), carrusel.getHeight(), Image.SCALE_DEFAULT));
			carrusel.setIcon(ico);	
			break;
		case 4:
			identificador=0;
		
			ico = new ImageIcon(imag5.getImage().getScaledInstance(carrusel.getWidth(), carrusel.getHeight(), Image.SCALE_DEFAULT));
			carrusel.setIcon(ico);		
			break;
		
		}
		
		
		
		
	}
};
	

public void iniciarCarrusel(){
	
	int VelMilSeg = velocida*1000;
	tiempo.scheduleAtFixedRate(tarea, 0, VelMilSeg);
}
public void detenerCarrusel(){
	tiempo.cancel();
}

}
