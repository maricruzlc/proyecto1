package com.proyecto.service;

import com.proyecto.service.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

//El BuketName es el <id_del_proyecto> + ".appspot.com"   
    final String BucketName = "proyecto-122bc.appspot.com";

//Esta es la ruta básica de este proyecto Techshop   
    final String rutaSuperiorStorage = "proyecto";
    
//Ubicación donde se encuentra el archivo de configuración Json   
    final String rutaJsonFile = "firebase";
    
//El nombre del archivo Json  
    final String archivoJsonFile = "proyecto-122bc-firebase-adminsdk-iiy05-643531db6e";
}
