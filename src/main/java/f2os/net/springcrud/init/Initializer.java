
package f2os.net.springcrud.init;


import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
             // Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
                ctx.register(WebAppConfig.class);
		servletContext.addListener(new ContextLoaderListener(ctx));

		ctx.setServletContext(servletContext);
                                    

		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
                                     servlet.setMultipartConfig(new MultipartConfigElement("C:\\tmp", 1024*1024*5, 1024*1024*5*5, 1024*1024));
		servlet.setLoadOnStartup(1);
                
                
                
                System.out.println("******** IN CLASS INITIALIZER *****************" );
              
	}
        
        

}