package com.myshop.admin;

import com.myshop.admin.paging.PagingAndSortingArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // exposes the file system location where the images are stored on the local machine
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        exposeDirectory("user-photos", registry);
        exposeDirectory("../category-images", registry);
        exposeDirectory("../brand-logos", registry);
        exposeDirectory("../product-images", registry);
        exposeDirectory("../site-logo", registry);
    }

    private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) {
        Path path = Paths.get(pathPattern);
         String absolutePath = path.toFile().getAbsolutePath();

        String logicalPath = pathPattern.replace("../", "") + "/**";

        registry.addResourceHandler(logicalPath)
                .addResourceLocations("file:" + absolutePath + "/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PagingAndSortingArgumentResolver());
    }


    /* A file URI takes the form of "file:" + userPhotosPath + "/ or file://host/path (note "file://" not "file:/" )
where host is the fully qualified domain name of the system on which the path is accessible, and path is a hierarchical
 directory path of the form directory/directory/.../name. If host is omitted, it is taken to be "localhost", the
 machine from which the URL is being interpreted. Note that when omitting host, the slash is not omitted
 (while "file:///foo.txt" is valid, "file://foo.txt" is not, although some interpreters manage to handle the latter).
    * */

}