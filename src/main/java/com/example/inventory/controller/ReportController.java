package com.example.inventory.controller;

@RestController
@RequestMapping("/api/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/stock")
    public ResponseEntity<String> generateStockReport() {
        return ResponseEntity.ok(reportService.generateStockReport());
    }

    @GetMapping("/orders")
    public ResponseEntity<String> generateOrderReport() {
        return ResponseEntity.ok(reportService.generateOrderReport());
    }

    @GetMapping("/suppliers")
    public ResponseEntity<String> generateSupplierReport() {
        return ResponseEntity.ok(reportService.generateSupplierReport());
    }
}
