package org.tuui.frontend;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FrontendRestController {

	private final String frontendVersion = "1.1";

	@Autowired
	private BackendClient backendClient;

	@RequestMapping(value = "version", method = RequestMethod.GET)
	public Version getVersions() {
		Version version = new Version();
		try {
			version.setBackendVersion(backendClient.getVersion().getBackendVersion());
		} catch (Exception e) {
			version.setBackendVersion("unavailable");
			log.error("Cannot connect to backendClient:", e);
		}
		version.setFrontendVersion(frontendVersion);
		log.debug("frontend version = {}, backend version", frontendVersion, version.getBackendVersion());
		return version;
	}

	@Data
	class Version {
		private String backendVersion;
		private String frontendVersion;
	}
}
