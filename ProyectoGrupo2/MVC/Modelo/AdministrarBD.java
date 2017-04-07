package Modelo;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AdministrarBD {
	
	public void ImportarBD(String BD, String pass){
		JFileChooser f = new JFileChooser();
		String dire;
		
		FileNameExtensionFilter sa = new FileNameExtensionFilter("SQL", "sql");
		f.setFileFilter(sa);
	
		int a = f.showOpenDialog(null);
		if(a== JFileChooser.APPROVE_OPTION){
			Connection Cone;
			 dire = f.getSelectedFile().getPath();
			 String so = System.getProperty("os.name");
			 String cmd=null;
			
			 if (so.equals("Linux")){
				 cmd = "mysql -u root -p"+pass+" "+BD+" < "+filtraURL(dire);
			 }else{
				 cmd = "cmd /c mysql -u root -p"+pass+" "+BD+" < "+filtraURL(dire);  
			 }
				 
			 try{		 
	            // Ejecucion Basica del Comando
	        	
	       	     
				 Process p = Runtime.getRuntime().exec(cmd);
	 
	        	JOptionPane.showMessageDialog(null, "El archivo fue restaurado exitosamente");
	        
	        }catch (IOException e1) {
	                System.out.println("Excepción: ");
	                e1.printStackTrace();
	        }
			
			
		}else{
			try {
				Runtime.getRuntime().exec("mysql -u root -p1323027 -e "+"\"drop database tecnidiesel"+"\"");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void ExportarBD(String BD, String pass, JTextField text){
		JFileChooser f = new JFileChooser();

		f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int a = f.showSaveDialog(null);
		if (a == JFileChooser.APPROVE_OPTION) {
			
			String q =""+f.getSelectedFile().getPath();
			String so = System.getProperty("os.name");
			String cmd = "cmd /c mysqldump -u root -p"+pass+" "+BD+" > "+filtraURL(q)+"/"+text.getText()+".sql";
			
			if (so.equals("Linux")){
				 cmd = "mysqldump -u root planfelipe > "+filtraURL(q)+"/"+text.getText()+".sql";
			 }else{
				 cmd = "cmd /c mysqldump -u root -p"+pass+" "+BD+" > "+filtraURL(q)+"/"+text.getText()+".sql";
			 }				 
	        try{		 
	            // Ejecucion Basica del Comando		        
	        	Runtime.getRuntime().exec(cmd);
	        	JOptionPane.showMessageDialog(null, "Archivo guardado en: "+f.getSelectedFile().getPath());
	        	
	        	
	        }catch (IOException e1) {
	                System.out.println("Excepción: ");
	                e1.printStackTrace();
	        }
		}
	
		
		
		
	}
	
	public void crearBD(String BD, String direTXT, String pass){
	
		Connection Cone;  
		java.net.URL url = getClass().getResource(direTXT);
		String line=null, lay =null;
		try {

		java.io.InputStream is = url.openStream();
		java.io.InputStreamReader isr = new java.io.InputStreamReader(is, "UTF-8");
		java.io.BufferedReader reader = new java.io.BufferedReader(isr);


		 line = reader.readLine();
		 lay =line;
		int a=0;
		while(line != null) {
		lay =lay+line;
		line = reader.readLine();
		}

		} catch (java.io.IOException e1) {
		}
		String sql[]=lay.split(";");
		

	
		try {
			            Class.forName("com.mysql.jdbc.Driver");
	             Cone = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+BD+"", "root", pass);
	             Statement k = Cone.createStatement();
	            
	             for(int x=1; x<=sql.length-1; x++){
	            	 System.out.println(sql[x]);
	            	 k.executeUpdate(sql[x]);	            	 
	             }
	             
	             JOptionPane.showMessageDialog(null, "La base de datos fue creada exitosamente");
	             Cone.close();
	        } catch (ClassNotFoundException ex) {
	        	
	            System.out.println("error de drivers");
	        } catch (SQLException ex) {
	        	
	        	 System.out.println("error al conectar ");
	        }
		

	}
	
	private String filtraURL(String url) {
		String m = "\\\\";
		String URLFI = "";
		String tem3 = "";
		String sql[] = url.split(m);
		URLFI = sql[0];
		
		for (int x = 1; x <= sql.length - 1; x++) {

			String tem = sql[x];

			String tem2[] = tem.split(" ");
			if ((tem2.length - 1) > 0) {
				tem3 = "\""+tem2[0]+" ";
				for (int a = 1; a <= tem2.length - 2; a++) {
					
					tem3 = tem3+tem2[a]+" ";

				}
				tem3 = tem3+tem2[tem2.length - 1]+"\"";
				sql[x]=tem3;
			}
			URLFI = URLFI+"\\"+sql[x];
		
		}
		
		return URLFI;
	}

}
