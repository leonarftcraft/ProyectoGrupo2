package classLibreria;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class validarTablas {
	
	//metodo que valida los jtables, para ello el metodo retorna un jatable.
		public JTable Validar() {
			//evita que las celdas sean editables
			JTable val = new javax.swing.JTable() {

				public boolean isCellEditable(int a, int b) {
					if(b==0){
						return false;
					}else{
						return true;
					}
					
				}
			};
			
			
			//evita que se pueda modificar el tamaño de las columnas
			val.getTableHeader().setReorderingAllowed(false);
			val.getTableHeader().setResizingAllowed(false);
			
			//solo se puede selecionar una fila a la ves
			val.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			//debuelve el jtable que se le pasaron todos los atributos anteriores
			return val;
		}
		
		
		
}
