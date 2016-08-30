package org.tuui.frontend;


import lombok.Data;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("backend-service")
public interface BackendClient {

	@RequestMapping(value = "/version", method = RequestMethod.GET)
	Version getVersion();

	@Data
	class Version {
		private String backendVersion;
		private String frontendVersion;
	}
}
