package io.rtdi.hanaappserver.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.DELETE;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

import org.glassfish.jersey.server.internal.LocalizationMessages;
import org.glassfish.jersey.server.model.AnnotatedMethod;

public class RolesAllowedDynamicFeature2 implements DynamicFeature  {
	
	private static Map<String, Map<String, Map<String, Set<String>>>> roles = new HashMap<>();

	public RolesAllowedDynamicFeature2() {
		super();
	}
	
	/**
	 * @return Map of roles
	 */
	public static Map<String, Map<String, Map<String, Set<String>>>> getRoles() {
		return roles;
	}

    @Override
    public void configure(final ResourceInfo resourceInfo, final FeatureContext configuration) {
        final AnnotatedMethod am = new AnnotatedMethod(resourceInfo.getResourceMethod());

        // DenyAll on the method take precedence over RolesAllowed and PermitAll
        if (am.isAnnotationPresent(DenyAll.class)) {
            configuration.register(new RolesAllowedRequestFilter());
            return;
        }

        // RolesAllowed on the method takes precedence over PermitAll
        RolesAllowed ra = am.getAnnotation(RolesAllowed.class);
        if (ra != null) {
        	add(resourceInfo, am);
            configuration.register(new RolesAllowedRequestFilter(ra.value()));
            return;
        }

        // PermitAll takes precedence over RolesAllowed on the class
        if (am.isAnnotationPresent(PermitAll.class)) {
            // Do nothing.
            return;
        }

        // DenyAll can't be attached to classes

        // RolesAllowed on the class takes precedence over PermitAll
        ra = resourceInfo.getResourceClass().getAnnotation(RolesAllowed.class);
        if (ra != null) {
        	add(resourceInfo, am);
            configuration.register(new RolesAllowedRequestFilter(ra.value()));
        }
    }
    
    private void add(ResourceInfo resourceInfo, AnnotatedMethod am) {
    	String classname = resourceInfo.getResourceClass().getSimpleName();
    	if (classname != null) {
            RolesAllowed ra = am.getAnnotation(RolesAllowed.class);
            if (ra != null) {
            	for (String role : ra.value()) {
            		Map<String, Map<String, Set<String>>> r = roles.get(role);
            		if (r == null) {
            			r = new HashMap<>();
            			roles.put(role, r);
            		}
            		Map<String, Set<String>> c = r.get(classname);
            		if (c == null) {
            			c = new HashMap<>();
            			r.put(classname, c);
            		}
                	Path p = am.getAnnotation(Path.class);
                	if (p != null) {
                		Set<String> m = c.get(p.value());
                		if (m == null) {
                			m = new HashSet<>();
                			c.put(p.value(), m);
                		}
                		if (am.getAnnotation(GET.class) != null) {
                			m.add("GET");
                		} else if (am.getAnnotation(POST.class) != null) {
                			m.add("POST");
                		} else if (am.getAnnotation(DELETE.class) != null) {
                			m.add("DELETE");
                		} else if (am.getAnnotation(PUT.class) != null) {
                			m.add("PUT");
                		}
                	}
            	}
            }
    	}
    	
    }

    @Priority(Priorities.AUTHORIZATION) // authorization filter - should go after any authentication filters
    private static class RolesAllowedRequestFilter implements ContainerRequestFilter {

        private final boolean denyAll;
        private final String[] rolesAllowed;

        RolesAllowedRequestFilter() {
            this.denyAll = true;
            this.rolesAllowed = null;
        }

        RolesAllowedRequestFilter(final String[] rolesAllowed) {
            this.denyAll = false;
            this.rolesAllowed = (rolesAllowed != null) ? rolesAllowed : new String[] {};
        }

        @Override
        public void filter(final ContainerRequestContext requestContext) throws IOException {
            if (!denyAll) {
                if (rolesAllowed.length > 0 && !isAuthenticated(requestContext)) {
                    throw new ForbiddenException(LocalizationMessages.USER_NOT_AUTHORIZED());
                }

                for (final String role : rolesAllowed) {
                    if (requestContext.getSecurityContext().isUserInRole(role)) {
                        return;
                    }
                }
            }

            throw new ForbiddenException(LocalizationMessages.USER_NOT_AUTHORIZED());
        }

        private static boolean isAuthenticated(final ContainerRequestContext requestContext) {
            return requestContext.getSecurityContext().getUserPrincipal() != null;
        }
    }

}
