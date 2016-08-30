package org.tuui.backend;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BackendRestController {

	private final String version = "0.1";

	@RequestMapping(value = "version", method = RequestMethod.GET)
	public Version getVersion() {
		log.debug("backend version = {}", version);
		return Version.builder().backendVersion(version).build();
	}

	@Data
	@Builder
	private static class Version {
		private String backendVersion;
	}
}
