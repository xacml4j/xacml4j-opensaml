package org.xacml4j.opensaml;

/*
 * #%L
 * XACML/OpenSAML Integration
 * %%
 * Copyright (C) 2009 - 2014 Xacml4J.org
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import java.util.List;

import org.opensaml.saml2.metadata.AuthzService;
import org.opensaml.saml2.metadata.EntityDescriptor;
import org.opensaml.xml.security.credential.Credential;
import org.opensaml.xml.signature.SignatureTrustEngine;

public interface IDPConfiguration {
	/**
	 * Gets an descriptor for local entity
	 *
	 * @return descriptor for local entity
	 */
	EntityDescriptor getLocalEntity();

	/**
	 * Returns signature trust engine
	 * @return signature trust engine
	 */
	SignatureTrustEngine getSignatureTrustEngine();

	/**
	 * Returns credential used for response signing
	 * @return credential used for response signing
	 * @deprecated see {@link #getSigningCredentials()}
	 */
	@Deprecated
	Credential getSigningCredential();

	/**
	 * Returns a list of available credentials for response signing.
	 * @return a list of available credentials for response signing
	 */
	List<Credential> getSigningCredentials();

	/**
	 * Authorization service implementation for given location URL
	 *
	 * @param locationURL location URL
	 * @return authorization service implementation
	 */
	AuthzService getAuthzServiceByLocation(String locationURL);
}
