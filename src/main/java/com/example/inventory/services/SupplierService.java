package com.example.inventory.services;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier updateSupplier(Long id, Supplier updatedSupplier) {
        return supplierRepository.findById(id)
            .map(supplier -> {
                supplier.setName(updatedSupplier.getName());
                supplier.setContactInfo(updatedSupplier.getContactInfo());
                return supplierRepository.save(supplier);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + id));
    }

    public void removeSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier getSupplierById(Long id) {
        return supplierRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Supplier not found with id " + id));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public RestockOrder placeRestockOrder(RestockOrder restockOrder) {
        return restockOrderRepository.save(restockOrder);
    }
}

