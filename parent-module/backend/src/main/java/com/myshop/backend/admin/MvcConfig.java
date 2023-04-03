package com.myshop.backend.admin;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    // exposes the file system location where the images are stored on the local machine
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String dirName = "user-photos";
        Path userPhotosDir = Paths.get(dirName);
        String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file:" + userPhotosPath + "/");

        String categoryImagesDirName = "../category-images";
        Path categoryImagesDir = Paths.get(categoryImagesDirName);
        String categoryImagesPath = categoryImagesDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/category-images/**")
                .addResourceLocations("file:" + categoryImagesPath + "/");
    }
    /* A file URI takes the form of "file:" + userPhotosPath + "/ or file://host/path (note "file://" not "file:/" )
where host is the fully qualified domain name of the system on which the path is accessible, and path is a hierarchical
 directory path of the form directory/directory/.../name. If host is omitted, it is taken to be "localhost", the
 machine from which the URL is being interpreted. Note that when omitting host, the slash is not omitted
 (while "file:///foo.txt" is valid, "file://foo.txt" is not, although some interpreters manage to handle the latter).
    * */

}