package com.example.inventory.services;

@Service
public class StockService {
    @Autowired
    private ItemRepository itemRepository;

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        return itemRepository.findById(id)
            .map(item -> {
                item.setName(updatedItem.getName());
                item.setDescription(updatedItem.getDescription());
                item.setPrice(updatedItem.getPrice());
                item.setQuantity(updatedItem.getQuantity());
                return itemRepository.save(item);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
    }

    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}

