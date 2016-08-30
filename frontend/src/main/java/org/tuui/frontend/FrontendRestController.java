package org.tuui.frontend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FrontendRestController {

	private final String version = "1.1";

	@Autowired
	private BackendClient backendClient;

	@RequestMapping(value = "version", method = RequestMethod.GET)
	public BackendClient.Version getVersions() {
		BackendClient.Version versionResponse = backendClient.getVersion();
		versionResponse.setFrontendVersion(version);
		log.debug("frontend version = {}, backend version", version, versionResponse.getBackendVersion());
		return versionResponse;
	}
}
