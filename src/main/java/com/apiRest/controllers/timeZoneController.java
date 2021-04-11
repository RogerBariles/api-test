package com.apiRest.controllers;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.ws.Response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.DTO.TimeZoneJsonDto;
import com.apiRest.DTO.ResponseJsonDto;


@RestController
@RequestMapping("/timeZone")
@CrossOrigin
public class timeZoneController {

	@PutMapping(name = "Calculate_time_zone")
	public ResponseEntity calculateTimeZone( @RequestParam String dato1, @RequestParam String dato2) {
		
		Long validDato2 = Long.parseLong(dato2.replace(" ", "").replace("-", ""));
		
		if(dato1 == "" || dato2 == "" ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos Incompletos");
		}
		
		if(validDato2 > 11) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Rango UTC sobrepasado");
		}
		
		ResponseJsonDto responseJson = new ResponseJsonDto();
		TimeZoneJsonDto timeZoneJson = new TimeZoneJsonDto();
		
		String[] timeString = dato1.split(":");
		
		int hour = Integer.parseInt(timeString[0]);
		int minute = Integer.parseInt(timeString[1]);
		int seconds = Integer.parseInt(timeString[2]);
		
		String zoneId = dato2.indexOf("-") == -1 ? "GMT+" + dato2.replace(" ", "") : "GMT" + dato2; 
	
		// SETEAMOS CUALQUIER FECHA
		ZonedDateTime fecha = ZonedDateTime.of(2015, 1, 31, hour, minute, seconds, 00, ZoneId.of(zoneId));

		// CONVERTIMOS A UTC
		String fechaTrabajar = fecha.withZoneSameInstant(ZoneId.of("UTC")).toString();
		
		String[] timeResponse = (fechaTrabajar.replace("Z","T")).split("T");
		 
		timeZoneJson.setTime(timeResponse[1]);
		timeZoneJson.setTimeZone("UTC");
	    

		responseJson.setResponse(timeZoneJson);
	    return ResponseEntity.ok().body(responseJson);
	};
}
