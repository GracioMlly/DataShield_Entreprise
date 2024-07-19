package com.datashield.api.controller;

import com.datashield.api.entities.Customer;
import com.datashield.api.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @PostMapping("/add")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @Value("${images.path}")
    private String imagesPath;

    @GetMapping("/images/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get(imagesPath, imageName);
        byte[] imageBytes = Files.readAllBytes(imagePath);

        HttpHeaders headers = new HttpHeaders();
        String mimeType = Files.probeContentType(imagePath);
        headers.add(HttpHeaders.CONTENT_TYPE, mimeType);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/favicon.ico")
    public ResponseEntity<Void> favicon() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

  /*  @PostMapping("/upload")
    public String uploadExcelFile(@RequestParam("file") MultipartFile excelFile) throws IOException {
        // Vérifier si le fichier est vide
        if (excelFile.isEmpty()) {
            return "Veuillez sélectionner un fichier Excel";
        }

        try (InputStream inputStream = excelFile.getInputStream()) {
            // Charger le fichier Excel en tant que classe de travail
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0); // Supposons que nous lisons à partir de la première feuille

            // Convertir les données de la feuille Excel en une liste d'objets
            List<Object> excelData = parseExcel(sheet);

            // Convertir la liste d'objets en JSON
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(excelData);
        }
    }

    private List<Object> parseExcel(Sheet sheet) {
        List<Object> excelData = new ArrayList<>();

        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row currentRow = iterator.next();
            Iterator<Cell> cellIterator = currentRow.iterator();

            List<Object> rowData = new ArrayList<>();
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                switch (currentCell.getCellType()) {
                    case STRING:
                        rowData.add(currentCell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowData.add(currentCell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        rowData.add(currentCell.getBooleanCellValue());
                        break;
                    default:
                        rowData.add(currentCell.getStringCellValue());
                }
            }
            excelData.add(rowData);
        }
        return excelData;
    }
*/
}
