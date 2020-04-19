package lk.geeks.controller;

import lk.geeks.dto.ItemDTO;
import lk.geeks.dto.LocalBookBrrowDTO;
import lk.geeks.service.LocalBookBrrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/localbrrows")
public class LocalMemberBrrowController {

    @Autowired
    private LocalBookBrrowService localBookBrrowService;

    @GetMapping
    public List<LocalBookBrrowDTO> getAll(){
        return localBookBrrowService.getAll();
    }

    @PostMapping
    public int save(@RequestBody LocalBookBrrowDTO localBookBrrowDTO){
        return  localBookBrrowService.save(localBookBrrowDTO);
    }

    @GetMapping(value = "/{id}")
    public  LocalBookBrrowDTO findByID(@PathVariable("id") int ID){

        return localBookBrrowService.findByID(ID);
    }

    @DeleteMapping(value = "/{ID}")
    public  boolean delete(@PathVariable("ID") int ID){
        return localBookBrrowService.delete(ID);
    }

    @PutMapping(value = "/{ID}")
    public boolean update(@PathVariable("ID") int ID,@RequestBody LocalBookBrrowDTO localBookBrrowDTO){

        return localBookBrrowService.update(ID,localBookBrrowDTO);
    }

     @PutMapping(value = "/return/{ID}")
     public boolean returnBook(@PathVariable("ID") int ID){
        return localBookBrrowService.returnBook(ID);
    }


    @GetMapping(value = "/byDate/{date}")
    public List<LocalBookBrrowDTO> findByDate(@PathVariable("date") String date){
        return localBookBrrowService.findByDate(date);
    }

    @GetMapping(path = "/notReturn")
    public List<LocalBookBrrowDTO> notReturn(){
        return localBookBrrowService.notReturn();
    }


}
