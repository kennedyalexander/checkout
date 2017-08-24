package at.akmrg.springBootEmpty.controllers;

import at.akmrg.springBootEmpty.services.MainService;

import org.json.JSONException;
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

	@CrossOrigin
	@PostMapping("/checkoutSession")
	public String getCheckoutSession(String orderId, String orderValue) throws JSONException {
	//Hard Setting the order currency for my sins.
	 mainService.createCheckoutSession(orderId, orderValue, "DKK");

	return mainService.test();
	}

	@PostMapping("/callback")
	public void callbackEndpoint() {
		System.out.println("SOMEONE CALLED HOME");
	}
}
