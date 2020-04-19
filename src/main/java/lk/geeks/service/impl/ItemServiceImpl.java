package lk.geeks.service.impl;

import lk.geeks.dto.ItemDTO;
import lk.geeks.dto.ItemXMLDTO;
import lk.geeks.entity.Item;
import lk.geeks.repostitory.ItemRepository;
import lk.geeks.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public boolean save(ItemDTO itemDTO) {


        Item item = new Item();
        BeanUtils.copyProperties(itemDTO,item);
        itemRepository.save(item);

        return true;
    }

    @Override
    public boolean update(String itemCode, ItemDTO itemDTO) {

        Item item = itemRepository.findById(itemCode).get();
        BeanUtils.copyProperties(itemDTO,item);
//        itemRepository.save(item);
        return true;
    }

    @Override
    public boolean delete(String itemCode) {

        itemRepository.deleteById(itemCode);

        return true;
    }

    @Override
    public List<ItemDTO> findAll() {

        if(itemRepository.findAll().isEmpty()){
            return null;
        }
        List<ItemDTO> itemDTOS = new ArrayList<>();

        itemRepository.findAll().forEach(item -> {
            ItemDTO itemDTO = new ItemDTO();
            BeanUtils.copyProperties(item,itemDTO);
            itemDTOS.add(itemDTO);
        });

        return itemDTOS;
    }

    @Override
    public ItemDTO findById(String itemCode) {

        if(!itemRepository.findById(itemCode).isPresent()){
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();
//        ItemXMLDTO itemXMLDTO = new ItemXMLDTO();
        BeanUtils.copyProperties(itemRepository.findById(itemCode).get(),itemDTO);
        return  itemDTO;
    }

    @Override
    public boolean changeCategory(String itemCode, String categoryType) {
        Item item = itemRepository.findById(itemCode).get();
        item.setBookCatagory(categoryType);
        return true;
    }

    @Override
    public boolean setRare(String itemCode) {
        Item item = itemRepository.findById(itemCode).get();
        item.setBookCatagory("rare");
        return true;
    }

    @Override
    public boolean setPublic(String itemCode) {
        Item item = itemRepository.findById(itemCode).get();
        item.setBookCatagory("public");
        return true;
    }

    @Override
    public List<ItemDTO> findByitemCategory(String itemCategory) {


        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()){
            return null;
        }

        List<ItemDTO> itemDTOS = new ArrayList<>();
        items.forEach(item -> {
            if(item.getItemCategory().equals(itemCategory)){
                ItemDTO itemDTO = new ItemDTO();
                BeanUtils.copyProperties(item,itemDTO);
                itemDTOS.add(itemDTO);
            }
        });

        return itemDTOS;

    }

    @Override
    public List<ItemDTO> findByCategory(String category) {
        System.out.println(category+" here");
        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()){
            return null;
        }

        List<ItemDTO> itemDTOS = new ArrayList<>();
        items.forEach(item -> {

            if(item.getBookCatagory().equals(category)){
                ItemDTO itemDTO = new ItemDTO();
                BeanUtils.copyProperties(item,itemDTO);
                itemDTOS.add(itemDTO);
            }
        });

        return itemDTOS;
    }

    @Override
    public List<ItemDTO> findByItemCategoryAndCategory(String itemCategory, String category) {
        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()){
            return null;
        }

        List<ItemDTO> itemDTOS = new ArrayList<>();

        if(itemCategory.equals("All Items")){
            items.forEach(item -> {
                if(item.getItemCategory().equals(itemCategory)){
                    ItemDTO itemDTO = new ItemDTO();
                    BeanUtils.copyProperties(item,itemDTO);
                    itemDTOS.add(itemDTO);
                }
            });
        }else if(category.equals("All Categories")){
            items.forEach(item -> {
                if(item.getBookCatagory().equals(itemCategory)){
                    ItemDTO itemDTO = new ItemDTO();
                    BeanUtils.copyProperties(item,itemDTO);
                    itemDTOS.add(itemDTO);
                }
            });
        }else if(!itemCategory.equals("All Items") && !category.equals("All Categories")){
            items.forEach(item -> {
                if(item.getBookCatagory().equals(category) && item.getItemCategory().equals(itemCategory)){
                    ItemDTO itemDTO = new ItemDTO();
                    BeanUtils.copyProperties(item,itemDTO);
                    itemDTOS.add(itemDTO);
                }
            });
        }




        return itemDTOS;
    }

    @Override
    public List<ItemDTO> findByAny(String role,String itemCategory,String findWord) {

        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()){
            return null;
        }
        List<ItemDTO> itemDTOS  = new ArrayList<>();

        if(itemCategory.equals("All")){
            items.forEach(item -> {
                        if(role.equals("local")) {
                            if (item.getTitle().equals(findWord)) {
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            } else if (item.getAuthor().equals(findWord)) {


                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            } else if (item.getPublisher().equals(findWord)) {
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            } else if (item.getItemCode().equals(findWord)) {
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            } else if (item.getBookCatagory().equals(findWord)) {
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            } else if (item.getYear().equals(findWord)) {
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            } else if (item.getItemCategory().equals(findWord)) {
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item, itemDTO);
                                itemDTOS.add(itemDTO);
                            }
                        }else {
                            if(item.getBookCatagory().equals("Public")){
                                if(item.getTitle().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }else if(item.getAuthor().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }else if(item.getPublisher().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }else if(item.getItemCode().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }else if(item.getBookCatagory().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }else if(item.getYear().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }else if(item.getItemCategory().equals(findWord)){
                                    ItemDTO itemDTO = new ItemDTO();
                                    BeanUtils.copyProperties(item,itemDTO);
                                    itemDTOS.add(itemDTO);
                                }
                            }
                        }
            });
        }else{
            items.forEach(item -> {
                if(item.getItemCategory().equals(itemCategory)){

                    if(role.equals("local")){
                        if(item.getTitle().equals(findWord)){
                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }else if(item.getAuthor().equals(findWord)){


                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }else if(item.getPublisher().equals(findWord)){
                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }else if(item.getItemCode().equals(findWord)){
                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }else if(item.getBookCatagory().equals(findWord)){
                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }else if(item.getYear().equals(findWord)){
                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }else if(item.getItemCategory().equals(findWord)){
                            ItemDTO itemDTO = new ItemDTO();
                            BeanUtils.copyProperties(item,itemDTO);
                            itemDTOS.add(itemDTO);
                        }
                    }else {
                        if(item.getBookCatagory().equals("Public")){
                            if(item.getTitle().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }else if(item.getAuthor().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }else if(item.getPublisher().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }else if(item.getItemCode().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }else if(item.getBookCatagory().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }else if(item.getYear().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }else if(item.getItemCategory().equals(findWord)){
                                ItemDTO itemDTO = new ItemDTO();
                                BeanUtils.copyProperties(item,itemDTO);
                                itemDTOS.add(itemDTO);
                            }
                        }
                    }
                }

            });
        }



        return itemDTOS;
    }

    @Override
    public List<ItemDTO> findItemCategoryANDCategory(String itemCategory, String category) {
        List<Item> items = itemRepository.findAll();
        if(items.isEmpty()){
            return null;
        }

        List<ItemDTO> itemDTOS = new ArrayList<>();
        items.forEach(item -> {
            if(item.getItemCategory().equals(itemCategory) && item.getBookCatagory().equals(category)){
                ItemDTO itemDTO = new ItemDTO();
                BeanUtils.copyProperties(item,itemDTO);
                itemDTOS.add(itemDTO);
            }
        });

        return itemDTOS;
    }
}
