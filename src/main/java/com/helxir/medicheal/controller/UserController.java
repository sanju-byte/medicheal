package com.helxir.medicheal.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helxir.medicheal.bean.PaymentCallback;
import com.helxir.medicheal.bean.PaymentDetail;
import com.helxir.medicheal.entity.Admin;
import com.helxir.medicheal.entity.Appointment;
import com.helxir.medicheal.enums.PaymentMode;
import com.helxir.medicheal.service.PaymentService;
import com.helxir.medicheal.serviceImpl.AdminServiceImplementation;
import com.helxir.medicheal.serviceImpl.AppointmentServiceImplementation;

@Controller
@RequestMapping("/user")
public class UserController {

	private AppointmentServiceImplementation appointmentServiceImplementation;
	private AdminServiceImplementation adminServiceImplementation;
	
	@Autowired
	private PaymentService paymentService;
	@Autowired
	public UserController(AppointmentServiceImplementation obj1, AdminServiceImplementation obj) {
		appointmentServiceImplementation = obj1;
		adminServiceImplementation = obj;

	}

	@GetMapping("/index")
	public String index(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/index";
	}

	@PostMapping("/save-app")
	public String saveEmploye(@ModelAttribute("app") Appointment obj) {

		appointmentServiceImplementation.save(obj);

		// use a redirect to prevent duplicate submissions
		return "redirect:/user/index";
	}

	@GetMapping("/about")
	public String about(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/about";
	}

	@GetMapping("/blog-single")
	public String bs(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/blog-single";
	}

	@GetMapping("/blog")
	public String blog(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/blog";
	}

	@GetMapping("/contact")
	public String contact(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/contact";
	}

	@GetMapping("/department-single")
	public String d(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/department-single";
	}

	@GetMapping("/departments")
	public String dep(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/departments";
	}

	@GetMapping("/doctor")
	public String doctor(Model model) {

		// get last seen
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);

		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		Admin admin = adminServiceImplementation.findByEmail(username);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date now = new Date();

		String log = now.toString();

		admin.setLastseen(log);

		adminServiceImplementation.save(admin);

		Appointment obj = new Appointment();

		obj.setName(admin.getFirstName() + " " + admin.getLastName());

		obj.setEmail(admin.getEmail());

		System.out.println(obj);

		model.addAttribute("app", obj);

		return "user/doctor";
	}

//	@GetMapping("/payment")
//	public String payment(@ModelAttribute("app") Appointment obj) {
//		System.out.println("Model : " + obj);
//		final String uri = "https://sandboxsecure.payu.in/_payment";
//		final String furl = "http://localhost:8888/user/index";
//		final String surl = "http://localhost:8888/user/index";
//		RestTemplate restTemplate = new RestTemplate();
//		PayURequest payURequest = new PayURequest();
//		payURequest.setPhone(obj.getPhone());
//		payURequest.setEmail(obj.getEmail());
//		payURequest.setFirstname(obj.getName());
//		payURequest.setProductinfo("Health Service");
//		payURequest.setFurl(furl);
//		payURequest.setSurl(surl);
//		payURequest.setServiceProvider("payu_paisa");
//		restTemplate.postForObject(uri, payURequest,null);
//		return "redirect:/user/index";
//	}


	@GetMapping("/payment")
	public String viewPaymentPage(Model model) {
		String username = "";
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			String Pass = ((UserDetails) principal).getPassword();
			System.out.println("One + " + username + "   " + Pass);
		} else {
			username = principal.toString();
			System.out.println("Two + " + username);
		}

		// get the employee from the service

		Admin pmtInfo = adminServiceImplementation.findByEmail(username);

		model.addAttribute("pmtInfo", pmtInfo);
		return "user/paymentview";
	}

	@PostMapping("/payment-details")
	public @ResponseBody PaymentDetail proceedPayment(@RequestBody PaymentDetail paymentDetail) {
		System.out.println("paymentDetail : "+paymentDetail);
		return paymentService.proceedPayment(paymentDetail);
	}

	@PostMapping("/payment-response")
	public @ResponseBody String payuCallback(@RequestParam String mihpayid, @RequestParam String status,
			@RequestParam PaymentMode mode, @RequestParam String txnid, @RequestParam String hash) {
		PaymentCallback paymentCallback = new PaymentCallback();
		paymentCallback.setMihpayid(mihpayid);
		paymentCallback.setTxnid(txnid);
		paymentCallback.setMode(mode);
		paymentCallback.setHash(hash);
		paymentCallback.setStatus(status);
		return paymentService.payuCallback(paymentCallback);
	}
}