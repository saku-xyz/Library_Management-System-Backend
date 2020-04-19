package lk.geeks.controller;

import lk.geeks.dto.ItemDTO;
import lk.geeks.dto.ItemXMLDTO;
import lk.geeks.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/items")
/**
 * This is the API for the Control Items
 */
public class ItemController {

    @Autowired
    private ItemService itemService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Get all Items
     *
     * @return List of All Items
     */
    @GetMapping
    public List<ItemDTO> findAll() {
        log.info("Final All Items");
        return itemService.findAll();
    }

    /**
     * Get Item by Item Code
     *
     * @param itemCode Item Code of Item
     * @return The Item DTO in XML Format
     */
    @GetMapping(value = "/{itemCode}")
    public ItemDTO findByID(@PathVariable("itemCode") String itemCode) {
        return itemService.findById(itemCode);
    }

    /**
     * Save the Item
     *
     * @param itemDTO Item DTO containing all the information of Item
     * @return state of save or not
     */
    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE)
    public boolean save(@RequestBody ItemDTO itemDTO) {
        return itemService.save(itemDTO);

    }

    /**
     * Update the Item
     *
     * @param itemCode Item Code of Item
     * @param itemDTO  Item DTO containing all the information of Item
     * @return state of sava or not
     */
    @PutMapping(value = "/{itemCode}")
    public boolean update(@PathVariable("itemCode") String itemCode, @RequestBody ItemDTO itemDTO) {
        return itemService.update(itemCode, itemDTO);
    }


    /**
     * Delete the Item
     *
     * @param itemCode Item Code of Item
     * @return state of delete or not
     */
    @DeleteMapping(value = "/{itemCode}")
    public boolean deleteItem(@PathVariable("itemCode") String itemCode) {
        return itemService.delete(itemCode);
    }

    /**
     * Set Item Rare
     *
     * @param itemCode Item Code of Item
     * @return state of update or not
     */
    @PutMapping(value = "/setRare/{itemCode}")
    public boolean setItemRare(@PathVariable("itemCode") String itemCode) {
        return itemService.setRare(itemCode);
    }

    /**
     * Set Item Public
     *
     * @param itemCode Item Code of Item
     * @return state of update or not
     */
    @PutMapping(value = "/setPublic/{itemCode}")
    public boolean setItemPublic(@PathVariable("itemCode") String itemCode) {
        return itemService.setPublic(itemCode);
    }

    /**
     * Get Items By Item Category
     *
     * @return List of Item DTO
     */
    @GetMapping(value = "/byItemCategory/{itemCategory}")
    public List<ItemDTO> byItemCategory(@PathVariable("itemCategory") String itemCategory) {
        return itemService.findByitemCategory(itemCategory);
    }


    /**
     * Get Items By Category
     *
     * @return List of Item DTO
     */
    @GetMapping(value = "/byCategory/{category}")
    public List<ItemDTO> byCategory(@PathVariable("category") String category) {
        System.out.println(category);
        return itemService.findByCategory(category);
    }

    /**
     * Get Items By Category
     *
     * @return List of Item DTO
     */
    @GetMapping(value = "/byCategory&itemCategory/{category}/{itemCategory}")
    public List<ItemDTO> byCategoryAndItemCategory(@PathVariable("category") String category, @PathVariable("itemCategory") String itemCategory) {
        return itemService.findByItemCategoryAndCategory(itemCategory, category);
    }


    /**
     * Change status of Item
     *
     * @param itemCode Item Code of Item
     * @param category Status of Item
     * @return state of update or not
     */
    @PutMapping(value = "/changeCategory/{itemCode}/{category}")
    public boolean changeCategory(@PathVariable("itemCode") String itemCode, @PathVariable("category") String category) {
        return itemService.changeCategory(itemCode, category);
    }

    /**
     * Find Item by any Keyword. If you want find all item categories send 'All' with category param
     * @param role role of logged member
     * @param category Item Category Name
     * @param keyword key word
     * @return List of Items
     */
    @GetMapping(value = "findByAny/{role}/{category}/{keyword}")
    public List<ItemDTO> findbyAny(@PathVariable("role") String role, @PathVariable("category") String category, @PathVariable("keyword") String keyword) {
        return itemService.findByAny(role,category, keyword);
    }

    /**
     * Find Items by Item Category and Category
     * @param itemCategory Item Category
     * @param category Category
     * @return List of ItemDTO
     */
    @GetMapping(value = "findItemCat&Cat/{itemCategory}/{category}")
    public List<ItemDTO> findItemCategoryANDCategory(@PathVariable("itemCategory") String itemCategory,@PathVariable("category") String category){
        return  itemService.findByItemCategoryAndCategory(itemCategory,category);
    }


}
