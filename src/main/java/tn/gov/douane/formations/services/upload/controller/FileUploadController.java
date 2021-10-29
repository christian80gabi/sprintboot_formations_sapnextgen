package tn.gov.douane.formations.services.upload.controller;

import com.example.crud_douane.service.upload.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;

/*
@RestController
public class FileUploadController {

    @Autowired
    FileStorageService storageService;

    public FileUploadController() {
    }

    public FileUploadController(FileStorageService storageService) {
        this.storageService = storageService;
    }

    public FileStorageService getStorageService() {
        return storageService;
    }

    public void setStorageService(FileStorageService storageService) {
        this.storageService = storageService;
    }

    //UPLOAD VIA UN FORMULAIRE
    @PostMapping("/upload")
    public UploadClass uploadFile(@RequestParam("file") MultipartFile file) {

        UploadClass resultat;
        String url = MvcUriComponentsBuilder
                .fromMethodName(FileUploadController.class, "getFile", file.getOriginalFilename()).build().toString();
        String message = "";
        try {
            storageService.save(file);

            //message = "Uploaded the file successfully: " + file.getOriginalFilename();
            resultat = new UploadClass(file.getOriginalFilename(), url);
        } catch (Exception e) {
            //message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            resultat = new UploadClass(file.getOriginalFilename(),"file not exist");
        }

        return resultat;
    }

    //LISTE DES FICHIERS CHARGES
    @GetMapping("/files")
    public ResponseEntity<List<FileModel>> getListFiles() {
        List<FileModel> fileInfos = storageService.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "getFile", path.getFileName().toString()).build().toString();

            return new FileModel(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    //TELECHARGER UN FICHIER
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
*/
