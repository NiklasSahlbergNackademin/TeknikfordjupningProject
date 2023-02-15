package teknikfordjupning.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import teknikfordjupning.backend.model.Item;
import teknikfordjupning.backend.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemResource {

        private final ItemService itemService;





        public ItemResource(ItemService itemService) {
            this.itemService = itemService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<Item>> getAllItems(){
            List<Item> items = itemService.findAllItems();
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
        @GetMapping("/find/{id}")
        public ResponseEntity <Item> getItemById(@PathVariable("id") Long id){
            Item item = itemService.findItemById(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }
        @PostMapping("/add")
        @PreAuthorize("hasAuthority('ADMIN')")
        public ResponseEntity <Item> addItem(@RequestBody Item item){

            itemService.addItem(item);
            return new ResponseEntity<>(item, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        @PreAuthorize("hasAuthority('ADMIN')")
        public ResponseEntity <Item> updateItem (@RequestBody Item item){
            itemService.updateItem(item);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        @PreAuthorize("hasAuthority('ADMIN')")
        public ResponseEntity<?> deleteItem(@PathVariable Long id){
            itemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }


}
