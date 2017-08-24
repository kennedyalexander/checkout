package at.akmrg.springBootEmpty.controllers;

import at.akmrg.springBootEmpty.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * Created by alex on 4/21/17.
 */
@RestController
public class MainController {
	@Autowired
	MainService mainService;

	@GetMapping("/getOranges")
	public String getOranges(@RequestParam(value="orange") String orange) {
		return orange;
	}

	@GetMapping("/getLemons")
	public String getLemons() {
		return "Lemons";
	}

	@PostMapping("/checkoutSession")
	public String getCheckoutSession() {
	return mainService.test();
	}
}
