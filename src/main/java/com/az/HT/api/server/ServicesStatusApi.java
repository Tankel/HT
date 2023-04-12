package com.az.HT.api.server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az.HT.Entity.Service;
import com.az.HT.Repository.ServicesStatusRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/services/status")
@Tag(name = "Services API", description = "API for managing the status of services")
@CrossOrigin(origins = "http://localhost:3000")
public class ServicesStatusApi {

	@Autowired
	ServicesStatusRepository serviceRespository;

	@GetMapping
	@Operation(summary = "Get all services", description = "Retrieve a list of all services")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Service> services() {
		return (List<Service>) serviceRespository.findAll();
	}

	@PostMapping
	@Operation(summary = "Update service status", description = "Update the status of a service")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Service status updated successfully"),
			@ApiResponse(responseCode = "400", description = "Invalid request", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
			@ApiResponse(responseCode = "404", description = "Service not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))) })
	@CrossOrigin(origins = "http://localhost:3000")
	public void update_status(
			@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The service object with updated status", required = true) @RequestBody Service service) {
		Optional<Service> existingService = serviceRespository.findById(service.getId());
		if (existingService.isPresent()) {
			Service updatedService = existingService.get();
			updatedService.setSystem_status(service.getSystem_status());
			updatedService.setStatus(service.getStatus());
			serviceRespository.save(updatedService);
		}
	}
}

/*
 * @PostMapping public void update(@RequestBody Service service) {
 * Optional<Service> existingService =
 * serviceRespository.findById(service.getId()); if (existingService != null)
 * serviceRespository.save(service); }
 */
