package com.example.demo.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Reservation;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;

@Component
public class PDFCreator {

	public void generate(Reservation reservation, String filePath) {
		
		Document document = new Document();
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
		
			document.open();
			document.add(generateTable(reservation));
			document.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Reservation details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Airlines");
		table.addCell(reservation.getFlight().getOperating_airlines());
		
		table.addCell("Flight number");
		table.addCell(reservation.getFlight().getFlight_number().toString());
		
		table.addCell("Departure city");
		table.addCell(reservation.getFlight().getDeparture_city());
		
		table.addCell("Arrival city");
		table.addCell(reservation.getFlight().getArrival_city());
		
		table.addCell("Departure date");
		table.addCell(reservation.getFlight().getDeparture_date());
		
		cell = new PdfPCell(new Phrase("Passenger details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("First name");
		table.addCell(reservation.getPassenger().getFirstname());
		
		table.addCell("Last name");
		table.addCell(reservation.getPassenger().getLastname());
		
		table.addCell("Email");
		table.addCell(reservation.getPassenger().getEmail());
		
		return table;
	}
}
