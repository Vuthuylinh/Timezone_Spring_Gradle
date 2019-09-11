package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
@GetMapping("/worldclock")
    String getTimeByZone(Model model, @RequestParam(name="city", required = false, defaultValue ="Asia/Ho_Chi_Minh") String city){
    Date date = new Date();
    TimeZone local = TimeZone.getDefault();
    System.out.println(local);

    TimeZone locale= TimeZone.getTimeZone(city);
    System.out.println(locale);
    long locale_time = date.getTime()+ (locale.getRawOffset()-local.getRawOffset());
    System.out.println(locale_time);
    date.setTime(locale_time); // Unix time
    System.out.println(date);
  model.addAttribute("city",city);
  model.addAttribute("date",date);
    return "index";


}

}
