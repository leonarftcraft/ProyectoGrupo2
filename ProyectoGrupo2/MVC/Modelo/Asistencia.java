package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import java.util.Date;
import Vista.VistaRegistrarCalendarioAcademico;

public class Asistencia extends CalendarioAcademico{
	
	private String cedu;
	private String idpers=null;
	private ClaseConection co = new ClaseConection();
	public Asistencia(VistaRegistrarCalendarioAcademico regCaleAca, String cedu) {
		super(regCaleAca);
		this.cedu= cedu;
	}

	public boolean getValidarPersonal(){
		boolean va = false;
		co.GetConexion("1323027");
	String sql = "select id as a from pers where cedu ='"+cedu+"'";
	ResultSet busCe = co.GetDatos(sql);
	
	try {
		while(busCe.next()){
			va= true;
			this.idpers=busCe.getString("a");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
		co.SetCloseConexion();
		return va;	
	}
	
	public String getFechaActual(){
		Calendar fechaAc = new GregorianCalendar();
		int anio = fechaAc.get(Calendar.YEAR);
        int mes = fechaAc.get(Calendar.MONTH);
        int dia = fechaAc.get(Calendar.DAY_OF_MONTH);
		
        String m =null, d=null;
        
        if((mes+1)>9){
        	m=String.valueOf(mes+1);
        }else{
        	m="0"+String.valueOf(mes+1);
        }
        if((dia)>9){
        	d=String.valueOf(dia);
        }else{
        	d="0"+String.valueOf(dia);
        }
		String fechAct = anio+"-"+m+"-"+d;
	return fechAct;
	}
	
	public String getTipoAsistencia(){
      co.GetConexion("1323027");
		String tiAsi = "Entrada";
		String geDa = "select horaEntr as a, horaSali as b from asispers where fech = '"+getFechaActual()+"' and fk_pers='"+this.idpers+"'";
		ResultSet geTipo = co.GetDatos(geDa);
		
		try {
			while(geTipo.next()){
				if(geTipo.getString("a").equals(" ")){
					tiAsi="Entrada";
				}else{
					if(geTipo.getString("b").equals(" ")){
						tiAsi="Salida";
				
					}else{
						tiAsi="Listo";
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		co.SetCloseConexion();
		return tiAsi;	
	}
	public String getHoraActual(){    
       /* Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm");
      */
        
        int tem=0, tem2=0;
    //   System.out.println(formateador.format(ahora));
      // String h[]=formateador.format(ahora).split(":");
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
       
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minu = fecha.get(Calendar.MINUTE);
        
        
       // int hora = Integer.parseInt(h[0]);
       // int minu = Integer.parseInt(h[1]);
        
        tem=minu-30;
        
        if(tem>=0){
        	
        	minu=tem;
        	
        }else{
        	tem=30-minu;
        	tem2= 60-tem;
        	minu=tem2;
        	hora=hora-1;
        	
        }
        String horaFinal=null;
       String hor =null;
       String min =null;
        if(minu<=9){
        	min= "0"+minu;
        }else{
        	min=String.valueOf(minu);
        }
        if(hora<=9){
        	hor= "0"+hora;
        }else{
        	hor=String.valueOf(hora);
        }
     
     
        return hor+":"+min;	
	}
	public void RegistrarEntrada(){
		
		co.GetConexion("1323027");
		String pp ="update asispers set "
				+ "horaEntr='"+getHoraActual()+"' "
				+ "where fech='"+getFechaActual()+"' and fk_pers='"+this.idpers+"'";
		co.SetDatos(pp);
		co.SetCloseConexion();
	}
	
	
	public void RegistrarSalida(){
		ClaseConection c = new ClaseConection();
		c.GetConexion("1323027");
		String pp ="update asispers set "
				+ "horaSali='"+getHoraActual()+"', "
				+ "horaPerd='"+getHorasPerdidasSalida()+"' "
				+ "where fech='"+getFechaActual()+"' and fk_pers='"+this.idpers+"'";
		
		c.SetDatos(pp);
		c.SetCloseConexion();
		
	}
	
	
	public int getHorasPerdidasSalida(){
		co.GetConexion("1323027");
		String geHor = "select horaEntr as a from asispers where fech='"+getFechaActual()+"' and fk_pers='"+this.idpers+"'";
		String entrada=null;
		ResultSet r = co.GetDatos(geHor);
		
		try {
			while(r.next()){
				entrada=r.getString("a");				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String carHo = "select fk_tipoPers as a from pers where id ='"+this.idpers+"'";
		ResultSet gt = co.GetDatos(carHo);
		int car=0;
		try {
			while(gt.next()){
				
				car= gt.getInt("a");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String CH[] = new String[15];
		int contHorasPer=0;
		
		if(car==1){
			int an=0;
			int me=0;
			int di=0;
			String feAc[]= getFechaActual().split("-");
			
			an = Integer.parseInt(feAc[0]);
			me = Integer.parseInt(feAc[1]);
			di = Integer.parseInt(feAc[2]);
			Calendar cal = new GregorianCalendar(an, me - 1, di);

			int diase = cal.get(Calendar.DAY_OF_WEEK);
			
			String cH = "select horaLabo.decr as a from horaLabo "
					+ "INNER JOIN cargHora ON cargHora.fk_horaLabo=horaLabo.id "
					+ "where cargHora.fk_pers='"+this.idpers+"' and cargHora.fk_diasLabo='"+(diase-1)+"'";
			ResultSet re= co.GetDatos(cH);
			int cont=0;
			try {
				while(re.next()){
					
					CH[cont]=re.getString("a");
					
					cont++;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			for(int a =0; a<=cont-1;a++){
				String te[]=CH[a].split("-");
				
				if(getDiferenciaHoras(te[0], entrada)>=15){
					contHorasPer++;
				}
				
				
			}
			for(int a =0; a<=cont-1;a++){
				String te[]=CH[a].split("-");
				if(getDiferenciaHoras(getHoraActual(), te[1])>=15){
					contHorasPer++;
				}				
			}
			
		}else{
			String re = "select decr as a from inteHora "
					+ "INNER JOIN jornLabo ON jornLabo.fk_inteHora=inteHora.id where jornLabo.fk_pers='"+this.idpers+"'";
			String jorLa[]=null;
			
			ResultSet jo = co.GetDatos(re);
			try {
				while(jo.next()){
				
					jorLa = jo.getString("a").split("-");
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			while(getDiferenciaHoras(jorLa[0], entrada)>=15){
				String sumHoIni[] = jorLa[0].split(":");
				int sumaH = Integer.parseInt(sumHoIni[0])+1;
				if(sumaH<=9){
					sumHoIni[0]= "0"+sumaH;
				}else{
					sumHoIni[0]= String.valueOf(sumaH);
				}
				jorLa[0]=sumHoIni[0]+":"+sumHoIni[1];
				
				contHorasPer++;
				
			}
			while(getDiferenciaHoras(getHoraActual(), jorLa[1])>=15){
				String sumHoIni[] = jorLa[1].split(":");
				int sumaH = Integer.parseInt(sumHoIni[0])-1;
				if(sumaH<=9){
					sumHoIni[0]= "0"+sumaH;
				}else{
					sumHoIni[0]= String.valueOf(sumaH);
				}
				jorLa[1]=sumHoIni[0]+":"+sumHoIni[1];
				contHorasPer++;
				
			}
			
			
		}
		
		
		co.SetCloseConexion();
		
		return contHorasPer;
		
	}

	
	
	private int getDiferenciaHoras(String inic, String fin){
		
		LocalTime ent = null;
	    LocalTime sal = null; 
		try {
				ent = LocalTime.parse(inic);
		       sal = LocalTime.parse(fin);
		       // otra lógica
		    } catch(DateTimeParseException e) {
		       // la hora de entrada o salida es inválida,
		       // informar al usuario y volver a pedirla
		    
		    }
		
		 int minutes = (int) ChronoUnit.MINUTES.between(ent, sal);
		
		return minutes;
		
	}
	public void setRegistroIndivi(String cedu){
		ClaseConection co = new ClaseConection();	
		co.GetConexion("1323027");
		String idPe = "select id as a, fk_tipoPers as b from pers where cedu='"+cedu+"'";
		ResultSet cs = co.GetDatos(idPe);
		String idPers=null;
		int tiPers=0;
		try {
			while(cs.next()){
				idPers = cs.getString("a");
				tiPers=cs.getInt("b");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		int an=0;
		int me=0;
		int di=0;
		String feAc[]= getFechaActual().split("-");
		
		an = Integer.parseInt(feAc[0]);
		me = Integer.parseInt(feAc[1]);
		di = Integer.parseInt(feAc[2]);
		Calendar cal = new GregorianCalendar(an, me - 1, di);

		int diase = cal.get(Calendar.DAY_OF_WEEK);
		
		if(tiPers==1){
			
			String reg = "select count(*) as a from cargHora "
					+ "where cargHora.fk_pers='"+idPers+"' and cargHora.fk_diasLabo='"+(diase-1)+"'";
			System.out.println(reg);
			ResultSet ft = co.GetDatos(reg);
			int horaPerd=0;
			try {
				while(ft.next()){
					horaPerd= ft.getInt("a");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(horaPerd>0){
				
				String En = "insert into asispers (fech, horaEntr, horaSali, horaPerd, fk_pers, fk_caleAcad, fk_horaJust) "
						+ "values ('"+getFechaActual()+"', ' ', ' ', '"+horaPerd+"', '"+idPers+"', '"+getIdCalenAcademico()+"', '1')";
		
				co.SetDatos(En);
				
			}
			
		}else{
			String J[]= null;
			String J1[]= null;
			String J2[]= null;
			String jor = "select decr from inteHora INNER JOIN jornLabo ON jornLabo.fk_inteHora=inteHora.id "
					+ "where jornLabo.fk_pers='"+idPers+"'";
				
			ResultSet re = co.GetDatos(jor);
			
			try {
				while(re.next()){
					J=re.getString("decr").split("-");
					J1=J[0].split(":");
					J2=J[1].split(":");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int horasPer =Integer.parseInt(J2[0])-Integer.parseInt(J1[0]);
			
			String En = "insert into asispers (fech, horaEntr, horaSali, horaPerd, fk_pers, fk_caleAcad, fk_horaJust) "
					+ "values ('"+getFechaActual()+"', ' ', ' ', '"+horasPer+"', '"+idPers+"', '"+getIdCalenAcademico()+"', '1')";
			
			co.SetDatos(En);
		}
		
		
		co.SetCloseConexion();
	}
	
	public void setRegistrosAutomaticos(){
		int an=0;
		int me=0;
		int di=0;
		String feAc[]= getFechaActual().split("-");
		
		an = Integer.parseInt(feAc[0]);
		me = Integer.parseInt(feAc[1]);
		di = Integer.parseInt(feAc[2]);
		Calendar cal = new GregorianCalendar(an, me - 1, di);

		int diase = cal.get(Calendar.DAY_OF_WEEK);
		
		ClaseConection co = new ClaseConection();
		co.GetConexion("1323027");
		String idDoce[]= new String[300];
		String Tip = "select id from pers where fk_tipoPers='1'";
		System.out.println(Tip);
		ResultSet res = co.GetDatos(Tip);
		int conDoce=0;
		try {
			while(res.next()){
				idDoce[conDoce]=res.getString("id");				
				conDoce++;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Tip2 = "select id from pers where fk_tipoPers='2' or fk_tipoPers='3'";		
		String idPer[]= new String[300];
		ResultSet res1 = co.GetDatos(Tip2);
		int conPer=0;
		try {
			while(res1.next()){
				idPer[conPer]=res1.getString("id");				
				conPer++;				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	String fecRe = "select count(*) as a from asispers where fech='"+getFechaActual()+"'";
	ResultSet fe = co.GetDatos(fecRe);
	int valiFec=0;
	try {
		while(fe.next()){
			valiFec=fe.getInt("a");
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	if(valiFec==0){
	
		if(diase>1){
		
		for(int a=0; a<=(conPer-1); a++){
			String J[]= null;
			String J1[]= null;
			String J2[]= null;
			String jor = "select decr from inteHora INNER JOIN jornLabo ON jornLabo.fk_inteHora=inteHora.id "
					+ "where jornLabo.fk_pers='"+idPer[a]+"'";
				
			ResultSet re = co.GetDatos(jor);
			
			try {
				while(re.next()){
					J=re.getString("decr").split("-");
					J1=J[0].split(":");
					J2=J[1].split(":");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int horasPer =Integer.parseInt(J2[0])-Integer.parseInt(J1[0]);
			
			String En = "insert into asispers (fech, horaEntr, horaSali, horaPerd, fk_pers, fk_caleAcad, fk_horaJust) "
					+ "values ('"+getFechaActual()+"', ' ', ' ', '"+horasPer+"', '"+idPer[a]+"', '"+getIdCalenAcademico()+"', '1')";
			System.out.println(En);
			co.SetDatos(En);
			
		}
		for (int f=0; f<=(conDoce-1); f++){
			if(diase>1){
				String reg = "select count(*) as a from cargHora "
						+ "where cargHora.fk_pers='"+idDoce[f]+"' and cargHora.fk_diasLabo='"+(diase-1)+"'";
				System.out.println(reg);
				ResultSet ft = co.GetDatos(reg);
				int horaPerd=0;
				try {
					while(ft.next()){
						horaPerd= ft.getInt("a");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(horaPerd>0){
					
					String En = "insert into asispers (fech, horaEntr, horaSali, horaPerd, fk_pers, fk_caleAcad, fk_horaJust) "
							+ "values ('"+getFechaActual()+"', ' ', ' ', '"+horaPerd+"', '"+idDoce[f]+"', '"+getIdCalenAcademico()+"', '1')";
					System.out.println(En+"  22222222222");
					co.SetDatos(En);
					
				}
				
			}
			
			
			
			
		}
		
		
		
		}
	}
		
		co.SetCloseConexion();
		
		
	}
	
}
