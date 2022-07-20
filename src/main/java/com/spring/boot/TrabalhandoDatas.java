package com.spring.boot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

public class TrabalhandoDatas {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Date data = new Date();
		
		System.out.println("Data milisegundos  :"  + data.getTime());
		System.out.println("Dia do mês  :"  + data.getDate());
		System.out.println("Dia da semana  :"  + data.getDay());
		System.out.println("Hora do dia  :"  + data.getHours());
		System.out.println("Hora do dia  :"  + data.getSeconds());
		System.out.println("Hora do dia  :"  + (data.getYear()+1900));
		
		
		//formatacao
		
		SimpleDateFormat sdftela = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfbdados= new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfhora= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		
		System.out.println(sdfhora.format(data.getTime()));
		
		//o parse, neste caso transforma uma string em data
		System.out.println(sdftela.format(sdftela.parse("20/12/2002")));
		
		//CALENDAR
		
		
		Calendar datacal = Calendar.getInstance();
		
		System.out.println(" Calendar  DATA E HORA ATUAIS"   +sdftela.format(datacal.getTime()));
		
		System.out.println(" Calendar milisegundos "   +datacal.getTimeInMillis());
		
		System.out.println(" Calendar dia do mes "   +datacal.get(Calendar.DAY_OF_MONTH));
		System.out.println(" Calendar MES "  +datacal.get(Calendar.MONTH +1));
		
		String data1 = "12/07/2022";
		
		String data12 = sdftela.format(sdftela.parse(data1));
		
		System.out.println("Data String formatada assim que chega da tela:  "  +data1);
		
		
		//Essa API é a partir do JAVA 8  -  PARA DATA do pacote TIME
		//já formatada yyyy-mm-dd
		
		LocalDate atual = LocalDate.now();
		System.out.println("Data atual com o java 8 LocalDate.now()  "  +atual);
		
		LocalTime  hora_atual = LocalTime.now();
		
		LocalDateTime data_junta = LocalDateTime.now();
		
		DateTimeFormatter lf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Data e hora atuais com LocalDatetime e formatado com DateTimeFormatter  "  + data_junta.format(lf));
		
		
		//chega uma string da tela, uso o parse
		
		String dataDaTela = "22/04/2022";
		String datax = sdftela.format(sdftela.parse(dataDaTela));
		
		String dt2 = "2022-04-22";
		LocalDate dt3 = LocalDate.parse(dt2);
		System.out.println("Date ADD dias  LocalDate. "  + dt3.plusDays(2));
		System.out.println("Date ADD month "  + dt3.plusMonths(2));
		
		 
		
		
		
	

		
	}

}
