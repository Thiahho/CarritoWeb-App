package servlet;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import modelos.Usuario;

@WebFilter("/*")
public class NavbarFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        if (session != null) {
            Usuario usuario = (Usuario) session.getAttribute("userobj");
            if (usuario != null && usuario.getNombre().equals("Admin")) {
                httpRequest.setAttribute("adminLoggedIn", true);
            }
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Método init requerido por la interfaz Filter
    }

    public void destroy() {
        // Método destroy requerido por la interfaz Filter
    }
}
