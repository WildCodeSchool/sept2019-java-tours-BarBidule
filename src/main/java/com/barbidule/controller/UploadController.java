package com.barbidule.controller;


import com.barbidule.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

/**
 * Controller permettant d'utiliser CRUD sur les différents objets (intervenants)
 * de la page les présentants.
 */
@Controller
public class UploadController {

    private final StorageService storageService;

    @Autowired
    public UploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/admin/program")
    public String uploadedFile(Model model) throws IOException {
        model.addAttribute("file", storageService);
        return "upload_prog";
    }

    @GetMapping(value="/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @PostMapping("/admin/program")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        System.out.println(file.getContentType());
        if (file.getContentType().toLowerCase().contains("pdf") || file.getContentType().toLowerCase().contains("jpg") ||
                file.getContentType().toLowerCase().contains("png") || file.getContentType().toLowerCase().contains("svg")) {
            storageService.store(file, "programmation." + file.getContentType().split("/")[1]);
            redirectAttributes.addFlashAttribute("message",
                    "Le fichier " + file.getOriginalFilename() + " a été correctement téléchargé!");
            return "redirect:/admin/program";
        }
        redirectAttributes.addFlashAttribute("message",
                "Le fichier doit être au format pdf, jpg, png ou svg !");
        return "redirect:/admin/program";
    }

}