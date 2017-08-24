package at.akmrg.springBootEmpty.controllers;

import at.akmrg.springBootEmpty.model.Order;
import at.akmrg.springBootEmpty.services.MainService;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
	public String getCheckoutSession(@RequestBody Order order) throws JSONException, IOException {
	//Hard Setting the order currency for my sins.

		System.out.println("order id: " + order.getOrderID());
		System.out.println("order value: " + order.getOrderValue());
				 if (!order.getOrderID().isEmpty() && !order.getOrderValue().isEmpty()) {
					 return mainService.createCheckoutSession(order, "DKK");
				 } else {
					 return "orderID" + order.getOrderID() + " orderValue" + order.getOrderValue();
				 }
	}

	@PostMapping("/callback")
	public void callbackEndpoint() {
		System.out.println("SOMEONE CALLED HOME");
	}
}
