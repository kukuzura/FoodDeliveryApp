package yurusova.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AuthorizationHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }

        if (isDeliveryAdmin(roles)) {
            url = "/delivery_admin";
        } else if (isCustomerAdmin(roles)) {
            url = "/CustomerAdmin";
        } else if (isSuperAdmin(roles)) {
            url = "/company_list";
        } else if (isDeliveryUser(roles)) {
            url = "/DeliveryUser";
        } else if (isCustomerUser(roles)) {
            url = "/CustomerUser";
        }
        return url;
    }

    private boolean isSuperAdmin(List<String> roles) {
        return roles.contains("SUPER_ADMIN");
    }

    private boolean isCustomerAdmin(List<String> roles) {
        return roles.contains("CUSTOMER_ADMIN");
    }

    private boolean isDeliveryAdmin(List<String> roles) {
        return roles.contains("DELIVERY_ADMIN");
    }

    private boolean isDeliveryUser(List<String> roles) {
        return roles.contains("DELIVERY_USER");
    }

    private boolean isCustomerUser(List<String> roles) {
        return roles.contains("CUSTOMER_USER");
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    // Get the role of logged in use
}
