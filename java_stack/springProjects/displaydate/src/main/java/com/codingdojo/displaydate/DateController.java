package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DateController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String dat(Model model) {
		String datePattern ="EEEE , dd MMMMM , yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
		String date = dateFormat.format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String tim(Model model) {
		String timePattern = "hh:mm: a";
		SimpleDateFormat timeFormat = new SimpleDateFormat(timePattern);
		String date = timeFormat.format(new Date());
		model.addAttribute("time", date);
		return "time.jsp";
	}

}
