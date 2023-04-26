package my.edu.utem.ftmk.dad.restoredrapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.restoredrapp.model.OrderType;

@Controller
public class OrderTypeMenuController {
	
	@GetMapping("/ordertype/list")
	public String getOrderTypes(Model model)
	{
		String uri = "http://localhost:8080/orderapp/api/ordertypes";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrderType[]>response =
				restTemplate.getForEntity(uri, OrderType[].class);
		OrderType orderTypes[] = response.getBody();
		List<OrderType>orderTypeList = Arrays.asList(orderTypes);
		model.addAttribute("orderTypes",orderTypeList);
		return "ordertypes";
		
	}
	
	/*@GetMapping("/ordertype/list")
	public ResponseEntity<String> getOrderTypes(){
		String uri = "http://localhost:8080/orderapp/api/ordertypes";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<OrderType[]> response = 
				restTemplate.getForEntity(uri,OrderType[].class);
		
		OrderType orderTypes[] = response.getBody();
		
		System.out.println(this.getClass().getSimpleName());
		System.out.println("Total record:"+ orderTypes.length + "\n");
		
		for (OrderType orderType:orderTypes) {
			System.out.print(orderType.getOrderTypeId() + "-");
			System.out.print(orderType.getCode() + "-");
			System.out.println(orderType.getCode());
			
		}
		String message = "Check out the message in the console";
		return new ResponseEntity<>(message, HttpStatus.OK);
	}*/
}
