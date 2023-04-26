package com.example.mvceventtracker;

import java.util.List;
// import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

// 
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

// 
@Controller
public class EventController {

	@Autowired
	public MongoRepo repo;
	@Autowired
	public MongoRepo1 repo1;
	@Autowired
	public MongoRepo2 repo2;
	@Autowired
	public MongoRepo3 repo3;



	@GetMapping("/")
	public String homepage(Model model){
		return "homepage";
	}

	@GetMapping("/admin")
	public String admin(Model model){
		return "admin";
	}
	@GetMapping("/sponsor")
	public String sponsor(Model model){
		return "sponsor";
	}

	@GetMapping("/speaker")
	public String speaker(Model model){
		return "speaker";
	}
	@GetMapping("/attendee")
	public String attendee(Model model){
		return "attendee";
	}

	@GetMapping("/viewevents")
	public String viewEvents(Model model) {
		List<Event> events = repo.findAll();
		model.addAttribute("allevents",events);
		return "viewevents";
	}

	
	@GetMapping("/vieweventothers")
	public String viewEventOthers(Model model) {
		List<Event> events = repo.findAll();
		model.addAttribute("allevents",events);
		return "vieweventothers";
	}
	
	@GetMapping("/viewproductothers")
	public String viewProductOthers(Model model) {
		List<Event> products = repo.findAll();
		model.addAttribute("allproducts",products);
		return "viewproductothers";
	}

	@GetMapping("/addevent")
	public String addEvent(Model model) {
		model.addAttribute("event",new Event());
		return "addevent";
	}

	@PostMapping("/addevent")
	public String submitEvent(@ModelAttribute("event") Event event) {
		repo.save(event);
		return "redirect:viewevents";
	}

	@GetMapping("/viewproducts")
	public String viewProducts(Model model) {
		List<Product> products = repo1.findAll();
		model.addAttribute("allproducts",products);
		return "viewproducts";
	}
	
	@GetMapping("/addproduct")
	public String addProduct(Model model) {
		model.addAttribute("product",new Product());
		return "addproduct";
	}

	@PostMapping("/addproduct")
	public String submitProduct(@ModelAttribute("product") Product product) {
		repo1.save(product);
		return "redirect:viewproducts";
	}

	@GetMapping("/updateevent/{id}")
	public String showUpdateFormEvent(@PathVariable("id") String id, Model model) {
    Event event = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid event Id: " + id));
    model.addAttribute("event", event);
    return "updateevent";
	}

	@PostMapping("/updateevent")
	public String updateEvent(@ModelAttribute("event") Event event) {
    repo.save(event);
    return "redirect:viewevents";
	}

	@GetMapping("/updateproduct/{id}")
	public String showUpdateFormProduct(@PathVariable("id") String id, Model model) {
    Product product = repo1.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
    model.addAttribute("product", product);
    return "updateproduct";
	}

	@PostMapping("/updateproduct")
	public String updateProduct(@ModelAttribute("product") Product product) {
    repo1.save(product);
    return "redirect:viewproducts";
	}
	
	@GetMapping("/deleteproduct")
    public String deleteProduct(Model model) {
        model.addAttribute("product", new Product());
        return "deleteproduct";
    }

    @PostMapping("/deleteproduct")
    public String deleteProduct(@ModelAttribute("product") Product product, Model model) {
        repo1.deleteByName(product.getName());
        model.addAttribute("message", "Product deleted successfully");
        return "redirect:viewproducts";
    }

	@GetMapping("/deleteevent")
    public String deleteEvent(Model model) {
        model.addAttribute("event", new Event());
        return "deleteevent";
    }

    @PostMapping("/deleteevent")
    public String deleteEvent(@ModelAttribute("event") Event event, Model model) {
        repo.deleteByName(event.getName());
        model.addAttribute("message", "Product deleted successfully");
        return "redirect:viewevents";
    }

	
	@GetMapping("/viewattendees")
	public String viewAttendees(Model model) {
		List<Attendee> attendees = repo2.findAll();
		model.addAttribute("allattendees",attendees);
		return "viewattendees";
	}

	
	// @GetMapping("/addattendee")
	// public String addAttendee(Model model) {
	// 	model.addAttribute("attendee", new Attendee());
	// 	return "addattendee";
	// }
	@GetMapping("/addattendee")
	public String addAttendee(Model model) {
		model.addAttribute("attendee", new Attendee());
		List<Event> events = repo.findAll();
    	model.addAttribute("events", events);
		return "addattendee";
	}

	@PostMapping("/addattendee")
	public String submitAttendee(@ModelAttribute("attendee") Attendee attendee) {
		repo2.save(attendee);
		return "redirect:viewattendees";
	}

	@GetMapping("/deleteattendee")
    public String deleteAttendee(Model model) {
        model.addAttribute("attendee", new Attendee());
        return "deleteattendee";
    }

    @PostMapping("/deleteattendee")
    public String deleteAttendee(@ModelAttribute("attendee") Attendee attendee, Model model) {
        repo2.deleteByName(attendee.getName());
        model.addAttribute("message", "Attendee deleted successfully");
        return "redirect:viewattendees";
    }

	
	@GetMapping("/viewspeakers")
	public String viewSpeakers(Model model) {
		List<Speaker> speakers = repo3.findAll();
		model.addAttribute("allspeakers",speakers);
		return "viewspeakers";
	}
	
	@GetMapping("/addspeaker")
	public String addSpeaker(Model model) {
		model.addAttribute("speaker", new Speaker());
		return "addspeaker";
	}
// 
	// @PostMapping("/addspeaker")
	// public String submitSpeaker(@ModelAttribute("speaker") Speaker speaker) {
	// 	repo3.save(speaker);
	// 	return "redirect:viewspeakers";
	// }
	@PostMapping("/addspeaker")
	public String submitSpeaker(@ModelAttribute("speaker") Speaker speaker, @RequestParam("audio") MultipartFile audioFile) {
		// Save the audio file to the local directory
		try {
			Path audioUploadsDir = Paths.get("audio_uploads");
			if (!Files.exists(audioUploadsDir)) {
				Files.createDirectories(audioUploadsDir);
			}
	
			Path audioFilePath = audioUploadsDir.resolve(audioFile.getOriginalFilename());
			audioFile.transferTo(audioFilePath);
	
			// Save the file path to the speaker
			speaker.setAudioFilePath(audioFilePath.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		repo3.save(speaker);
		return "redirect:viewspeakers";
	}
	

// 
	// @GetMapping("/deletespeaker")
    // public String deleteSpeaker(Model model) {
    //     model.addAttribute("speaker", new Speaker());
    //     return "deletespeaker";
    // }

    // @PostMapping("/deletespeaker")
    // public String deleteSpeaker(@ModelAttribute("speaker") Speaker speaker, Model model) {
    //     repo3.deleteByName(speaker.getName());
    //     model.addAttribute("message", "Item deleted successfully");
    //     return "redirect:viewspeakers";
    // }
	//vidisha is a cutie. so is vibha. cutiessssssss.

}

