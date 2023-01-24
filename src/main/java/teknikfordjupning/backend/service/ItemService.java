package teknikfordjupning.backend.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import teknikfordjupning.backend.exceptions.ItemNotFoundException;
import teknikfordjupning.backend.model.Item;
import teknikfordjupning.backend.repositories.ItemRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public Item addItem(Item item){
        item.setItemCode(UUID.randomUUID().toString());
        return itemRepository.save(item);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

    public Item findItemById(Long id){
       return itemRepository.findItemById(id).orElseThrow(() -> new ItemNotFoundException("The item with id : " + id + "was not found" ));
    }

    @Transactional
    public void deleteItem(Long id) {
        itemRepository.deleteItemById(id);
    }




}
